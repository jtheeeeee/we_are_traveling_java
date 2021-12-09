package com.weling.we_are_traveling_java.service;

import com.weling.we_are_traveling_java.domain.Board;
import com.weling.we_are_traveling_java.domain.Comment;
import com.weling.we_are_traveling_java.domain.Tag;
import com.weling.we_are_traveling_java.dto.BoardCommentRequestDto;
import com.weling.we_are_traveling_java.dto.BoardRequestDto;
import com.weling.we_are_traveling_java.repository.BoardRepository;
import com.weling.we_are_traveling_java.repository.CommentRepository;
import com.weling.we_are_traveling_java.repository.TagRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
        Board board=boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        return board;
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

}
