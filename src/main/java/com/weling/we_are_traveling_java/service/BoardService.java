package com.weling.we_are_traveling_java.service;

import com.weling.we_are_traveling_java.domain.Board;
import com.weling.we_are_traveling_java.domain.Comment;
import com.weling.we_are_traveling_java.domain.InfoContent;
import com.weling.we_are_traveling_java.domain.Tag;
import com.weling.we_are_traveling_java.dto.BoardCommentRequestDto;
import com.weling.we_are_traveling_java.dto.BoardRequestDto;
import com.weling.we_are_traveling_java.dto.InfoContentRequestDto;
import com.weling.we_are_traveling_java.repository.BoardRepository;
import com.weling.we_are_traveling_java.repository.CommentRepository;
import com.weling.we_are_traveling_java.repository.TagRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;
    private final AwsService awsService;
    private final S3Uploader s3Uploader;

    @Transactional
    public Board setBoard(BoardRequestDto boardRequestDto) throws IOException {
        String url = null;
        if(boardRequestDto.getImage() != null) url = awsService.upload(boardRequestDto.getImage());
        Board board = new Board(boardRequestDto, url);
        boardRepository.save(board);

        List<String> items = Arrays.asList(boardRequestDto.getTags().split("\\s*,\\s*"));
        List<Tag> tags = items.stream().map(tag -> new Tag(tag, board)).collect(Collectors.toList());
        tagRepository.saveAll(tags);

        return board;
    }

    public Board getBoard(Long id){
        return boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
    }

    public List<Board> getBoards(String searchTag){
        if(searchTag.isEmpty()){
            return boardRepository.findAll();
        } else {
            return boardRepository.findAllByTagsName(searchTag);
        }
    }

    @Transactional
    public void setBoardComment(BoardCommentRequestDto boardCommentRequestDto){
        Board board = boardRepository.findById(boardCommentRequestDto.getIdx()).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        Comment comment = new Comment(boardCommentRequestDto, board);
        commentRepository.save(comment);
    }

    @Transactional
    public Long updateBoard(Long id, BoardRequestDto requestDto) throws IOException {
        String url=null;


        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(board.getImageUrl().equals( requestDto.getImage())){
            url=requestDto.getImageUrl();
        }else{
            if(requestDto.getImage() != null) url = s3Uploader.upload(requestDto.getImage(),"data");
        }
        board.update(requestDto,url);
        return board.getIdx();
    }

    public void deleteBoard(Long idx){
        Board board = boardRepository.findById(idx).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + idx));
        boardRepository.delete(board);
    }

}
