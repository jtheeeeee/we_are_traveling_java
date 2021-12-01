package com.weling.we_are_traveling_java.controller;

import com.weling.we_are_traveling_java.domain.InfoContent;
import com.weling.we_are_traveling_java.dto.InfoContentRequestDto;
import com.weling.we_are_traveling_java.dto.JwtResponse;
import com.weling.we_are_traveling_java.dto.SignupRequestDto;
import com.weling.we_are_traveling_java.service.InfoContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class InfoContentApiController {

    private final InfoContentService infoContentService;

    @PostMapping(value = "/infoContents")
    public InfoContent createInfoContent(@RequestBody InfoContentRequestDto infoDto) {
        return infoContentService.setInfoContent(infoDto);
    }
}
