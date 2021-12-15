package com.weling.we_are_traveling_java.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;

@Getter
@Setter
public class InfoContentRequestDto {
    private String username;
    private String title;
    private String content;
    private MultipartFile image;
    private String imageUrl;
    private int accommodation;
    private int transportation;
    private int food;
    private int shopping;
    private int entertainment;
    private int others;
    private int total;

}
