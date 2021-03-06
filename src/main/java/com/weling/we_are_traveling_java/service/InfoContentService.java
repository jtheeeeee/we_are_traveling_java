package com.weling.we_are_traveling_java.service;

import com.weling.we_are_traveling_java.domain.Comment;
import com.weling.we_are_traveling_java.domain.InfoComment;
import com.weling.we_are_traveling_java.domain.InfoContent;
import com.weling.we_are_traveling_java.dto.InfoCommentRequestDto;
import com.weling.we_are_traveling_java.dto.InfoContentRequestDto;
import com.weling.we_are_traveling_java.repository.InfoCommentRepository;
import com.weling.we_are_traveling_java.repository.InfoContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InfoContentService {

    private final InfoContentRepository infoContentRepository;
    private final InfoCommentRepository commentRepository;
    private final S3Uploader s3Uploader;

    @Transactional
    public InfoContent setInfoContent(InfoContentRequestDto infoDto)  throws IOException {
        String url = null;
        if(infoDto.getImage() != null) url = s3Uploader.upload(infoDto.getImage(),"data");

        InfoContent infoContent = new InfoContent(infoDto,url);
        infoContentRepository.save(infoContent);

        return infoContent;
    }

    @Transactional
    public Long updateInfoContent(Long id, InfoContentRequestDto requestDto) throws IOException {
        String url=null;


        InfoContent infoContent = infoContentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(infoContent.getImageUrl().equals( requestDto.getImageUrl())){
            url=requestDto.getImageUrl();
        }else{
            if(requestDto.getImage() != null) url = s3Uploader.upload(requestDto.getImage(),"data");
        }
        infoContent.update(requestDto,url);
        return infoContent.getId();
    }

    public InfoContent getInfoContent(Long id){
        return infoContentRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다." ));
    }

    public List<InfoContent> getInfoContents(){
        return infoContentRepository.findAll();

    }

    public void deleteInfoContent(Long id){
        InfoContent infoContent = infoContentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        infoContentRepository.delete(infoContent);
    }

    @Transactional
    public void setComment(InfoCommentRequestDto commentRequestDto){
        InfoContent infoContent = infoContentRepository.findById(commentRequestDto.getId()).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        InfoComment comment = new InfoComment(commentRequestDto, infoContent);
        commentRepository.save(comment);
    }

    public InfoComment getComment(Long id){
        InfoComment infoComment= commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 대댓글이 없습니다. id=" + id));
        return infoComment;
    }

    public void deleteComment(Long id){
        InfoComment infoComment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));
        commentRepository.delete(infoComment);
    }

    @Transactional
    public Long updateComment(Long id, InfoCommentRequestDto requestDto) {
        InfoContent infoContent = infoContentRepository.findById(requestDto.getId()).orElseThrow(
                () -> new NullPointerException("해당 인포아이디가 존재하지 않습니다."+requestDto.getId())
        );
        InfoComment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));
        comment.update(requestDto, infoContent);
        return comment.getId();
    }
}