package com.weling.we_are_traveling_java.service;

import com.weling.we_are_traveling_java.domain.InfoContent;
import com.weling.we_are_traveling_java.dto.InfoContentRequestDto;
import com.weling.we_are_traveling_java.repository.InfoContentRepository;
import com.weling.we_are_traveling_java.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InfoContentService {

    private final InfoContentRepository infoContentRepository;

    @Transactional
    public InfoContent setInfoContent(InfoContentRequestDto infoDto) {

        InfoContent infoContent = new InfoContent(infoDto);
        infoContentRepository.save(infoContent);

        return infoContent;
    }

    public InfoContent getInfoContent(Long id){
        return infoContentRepository.findById(id).orElseThrow(
                    () -> new NullPointerException("해당 아이디가 존재하지 않습니다." ));
    }

}