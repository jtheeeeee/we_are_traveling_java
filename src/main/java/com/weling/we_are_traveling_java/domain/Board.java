package com.weling.we_are_traveling_java.domain;

import com.weling.we_are_traveling_java.dto.BoardRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Board extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = true)
    private String imageUrl;

    @OneToMany(mappedBy="board")
    private List<Comment> comments;

    @OneToMany(mappedBy="board")
    private Set<Tag> tags;

    public Board(BoardRequestDto requestDto, String imageUrl) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.imageUrl = imageUrl;
    }

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
    public void update(BoardRequestDto requestDto, String url) {
        this.content = requestDto.getContent();
        this.title = requestDto.getTitle();
        this.imageUrl = url;
    }
}
