package com.weling.we_are_traveling_java.controller;

import com.weling.we_are_traveling_java.domain.InfoContent;
import com.weling.we_are_traveling_java.dto.CommentRequestDto;
import com.weling.we_are_traveling_java.dto.InfoContentRequestDto;
import com.weling.we_are_traveling_java.service.InfoContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class InfoContentApiController {

    private final InfoContentService infoContentService;

    @PostMapping(value = "/infoContents")
    public InfoContent createInfoContent(InfoContentRequestDto infoDto) throws IOException {
        return infoContentService.setInfoContent(infoDto);
    }

    @GetMapping(value = "/infoContents")
    public InfoContent getInfoContent(@RequestParam Long id) {
        return infoContentService.getInfoContent(id);
    }

    @PostMapping("/infoContents/comment")
    public void  setArticleComment(@RequestBody CommentRequestDto commentRequestDto){
        infoContentService.setComment(commentRequestDto);
    }

}