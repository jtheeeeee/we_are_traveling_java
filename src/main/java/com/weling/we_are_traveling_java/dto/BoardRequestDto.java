package com.weling.we_are_traveling_java.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class BoardRequestDto {
    private String title;
    private String content;
    private String tags;
    private MultipartFile image;
}
