package com.weling.we_are_traveling_java.domain;

import com.weling.we_are_traveling_java.dto.InfoContentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class InfoContent extends Timestamped{

    public InfoContent(InfoContentRequestDto infoDto){
        this.username = infoDto.getUsername();
        this.title = infoDto.getTitle();
        this.accommodation = infoDto.getAccommodation();
        this.transportation = infoDto.getTransportation();
        this.food = infoDto.getFood();
        this.content = infoDto.getContent();
        this.entertainment = infoDto.getEntertainment();
        this.others = infoDto.getOthers();
        this.shopping = infoDto.getShopping();
        this.total = infoDto.getTotal();


    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( nullable = false)
    private String username;
    @Column( nullable = false)
    private String title;
    @Column( nullable = false)
    private String content;
    @Column( nullable = false)
    private int accommodation;
    @Column( nullable = false)
    private int transportation;
    @Column( nullable = false)
    private int food;
    @Column( nullable = false)
    private int shopping;
    @Column( nullable = false)
    private int entertainment;
    @Column( nullable = false)
    private int others;
    @Column( nullable = false)
    private int total;




}
