package com.weling.we_are_traveling_java.controller;

import com.weling.we_are_traveling_java.domain.InfoContent;
import com.weling.we_are_traveling_java.dto.InfoCommentRequestDto;
import com.weling.we_are_traveling_java.dto.InfoContentRequestDto;
import com.weling.we_are_traveling_java.service.InfoContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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

    @GetMapping(value = "/infoContentList")
    public List<InfoContent> getInfoContents() {
        return infoContentService.getInfoContents();
    }

    @DeleteMapping(value = "/infoContents")
    public Long deleteInfoContent(@RequestParam Long id) {
        infoContentService.deleteInfoContent(id);
        return id;
    }

    @PostMapping("/infoContents/comment")
    public void  setArticleComment(@RequestBody InfoCommentRequestDto commentRequestDto){
        infoContentService.setComment(commentRequestDto);
    }

    @DeleteMapping("/infoContents/comment")
    public Long  deleteArticleComment(@RequestParam Long id){
        infoContentService.deleteComment(id);
        return id;
    }
}