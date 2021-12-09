package com.weling.we_are_traveling_java.controller;

import com.weling.we_are_traveling_java.domain.Board;

import com.weling.we_are_traveling_java.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class FrontController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/content")
    public String content(){
        return "insert";
    }

    @GetMapping("/insert")
    public String insert(){
        return "insert_form";
    }

    @GetMapping("/infoContent")
    public String detail(){
        return "infoContent";
    }

    @GetMapping("/board")
    public String board(){ return "board";
    }

    @GetMapping("/board_insert")
    public String board_insert(){
        return "board_insert";
    }

    @GetMapping(value="/view?idx={idx}")
    public String findOneBoard(@PathVariable Long id){
        BoardService boardService = new BoardService();
        Board board=boardService.getBoard(id);
        return board.toString();
    }
}


