package com.weling.we_are_traveling_java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
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

    @GetMapping("/infoContent/update")
    public String update(){
        return "infoUpdate";
    }

    @GetMapping("/board")
    public String board(){ return "board";
    }

    @GetMapping("/board_insert")
    public String board_insert(){
        return "board_insert";
    }

    @GetMapping("/view")
    public String view(){
        return "view";
    }
}


