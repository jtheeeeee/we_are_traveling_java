package com.weling.we_are_traveling_java.controller;

import com.weling.we_are_traveling_java.domain.InfoComment;
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

    @PutMapping(value = "/infoContents")
    public Long updateInfoContent(@RequestParam Long id, InfoContentRequestDto requestDto) throws IOException{
        return infoContentService.updateInfoContent(id, requestDto);

    }

    @DeleteMapping(value = "/infoContents")
    public Long deleteInfoContent(@RequestParam Long id) {
        infoContentService.deleteInfoContent(id);
        return id;
    }

    @GetMapping(value = "/infoContentList")
    public List<InfoContent> getInfoContents() {
        return infoContentService.getInfoContents();
    }

    @GetMapping(value = "/infoContents/comment")
    public InfoComment getInfoContentComment(@RequestParam Long id) {
        return infoContentService.getComment(id);
    }

    @PostMapping("/infoContents/comment")
    public void  setArticleComment(@RequestBody InfoCommentRequestDto commentRequestDto){
        infoContentService.setComment(commentRequestDto);
    }

    @PutMapping(value = "/infoContents/comment")
    public Long updateInfoContentComment(@RequestParam Long id, @RequestBody InfoCommentRequestDto requestDto) throws IOException{
        return infoContentService.updateComment(id, requestDto);

    }

    @DeleteMapping("/infoContents/comment")
    public Long deleteArticleComment(@RequestParam Long id){
        infoContentService.deleteComment(id);
        return id;
    }
}