package com.weling.we_are_traveling_java.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequestDto {
    private Long id;
    private String username;
    private String comment;
}
