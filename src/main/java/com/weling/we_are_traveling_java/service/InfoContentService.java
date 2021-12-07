package com.weling.we_are_traveling_java.service;

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

    public InfoContent getInfoContent(Long id){
        return infoContentRepository.findById(id).orElseThrow(
                    () -> new NullPointerException("해당 아이디가 존재하지 않습니다." ));
    }

    @Transactional
    public void setComment(InfoCommentRequestDto commentRequestDto){
        InfoContent infoContent = infoContentRepository.findById(commentRequestDto.getId()).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        InfoComment comment = new InfoComment(commentRequestDto, infoContent);
        commentRepository.save(comment);
    }



}