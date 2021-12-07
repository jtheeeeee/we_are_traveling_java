package com.weling.we_are_traveling_java.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import com.weling.we_are_traveling_java.dto.BoardCommentRequestDto;
=======
import com.weling.we_are_traveling_java.dto.CommentRequestDto;
>>>>>>> taehee
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

<<<<<<< HEAD
@NoArgsConstructor
@Setter
@Getter
@Entity
=======
@Entity
@Getter
@Setter
@NoArgsConstructor
>>>>>>> taehee
public class InfoComment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
<<<<<<< HEAD
    private Long idx;
=======
    private Long id;

    @Column(nullable = false)
    private String username;
>>>>>>> taehee

    @Column(nullable = false)
    private String comment;

    @JsonIgnore
    @ManyToOne
<<<<<<< HEAD
    @JoinColumn(name="board_idx", nullable = false)
    private Board board;

    public InfoComment(BoardCommentRequestDto requestDto, Board board) {
        this.comment = requestDto.getComment();
    }

=======
    @JoinColumn(name="info_id", nullable = false)
    private InfoContent infoContent;

    public InfoComment(CommentRequestDto requestDto, InfoContent infoContent) {
        this.comment = requestDto.getComment();
        this.infoContent = infoContent;
        this.username = requestDto.getUsername();
    }
>>>>>>> taehee
}
