package com.weling.we_are_traveling_java.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.weling.we_are_traveling_java.dto.InfoCommentRequestDto;
import com.weling.we_are_traveling_java.dto.InfoContentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InfoComment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="info_id", nullable = false)
    private InfoContent infoContent;

    public InfoComment(InfoCommentRequestDto requestDto, InfoContent infoContent) {
        this.comment = requestDto.getComment();
        this.infoContent = infoContent;
        this.username = requestDto.getUsername();
    }

    public void update(InfoCommentRequestDto requestDto, InfoContent infoContent) {
        this.username=requestDto.getUsername();
        this.comment=requestDto.getComment();
        this.infoContent=infoContent;
    }
}
