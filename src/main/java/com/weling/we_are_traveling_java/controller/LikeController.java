package com.weling.we_are_traveling_java.controller;

import com.weling.we_are_traveling_java.domain.User;
import com.weling.we_are_traveling_java.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {
//    private final LikesService likesService;

    @GetMapping("/likes/{id}")
    public User getLike(@PathVariable Long id,
                        @AuthenticationPrincipal UserDetailsImpl userDetails){
        return userDetails.getUser();
    }

}
