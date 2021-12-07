package com.weling.we_are_traveling_java.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weling.we_are_traveling_java.dto.BoardCommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String comment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="board_idx", nullable = false)
    private Board board;

    public Comment(BoardCommentRequestDto requestDto, Board board) {
        this.comment = requestDto.getComment();
    }

}
