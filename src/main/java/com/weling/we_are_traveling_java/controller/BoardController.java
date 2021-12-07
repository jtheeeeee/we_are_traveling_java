package com.weling.we_are_traveling_java.controller;


import com.weling.we_are_traveling_java.domain.Board;
import com.weling.we_are_traveling_java.dto.BoardCommentRequestDto;
import com.weling.we_are_traveling_java.dto.BoardRequestDto;
import com.weling.we_are_traveling_java.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public Board setBoard(BoardRequestDto boardRequestDto) throws IOException {
        return boardService.setBoard(boardRequestDto);
    }

    @GetMapping("/boards")
    public List<Board> getBoards(@RequestParam(required = false) String searchTag){
        return boardService.getBoards(searchTag);
    }

    @GetMapping("/board/{id}")
    public Board getBoard(@PathVariable Long id){
        return boardService.getBoard(id);
    }


    @PostMapping("/board/comment")
    public void setBoardComment(@RequestBody BoardCommentRequestDto boardCommentRequestDto){
        boardService.setBoardComment(boardCommentRequestDto);
    }
}