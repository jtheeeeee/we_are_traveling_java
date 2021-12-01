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

}


