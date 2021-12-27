package com.weling.we_are_traveling_java.controller;


import com.weling.we_are_traveling_java.domain.Board;
import com.weling.we_are_traveling_java.dto.BoardCommentRequestDto;
import com.weling.we_are_traveling_java.dto.BoardRequestDto;
import com.weling.we_are_traveling_java.dto.InfoContentRequestDto;
import com.weling.we_are_traveling_java.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
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

    @GetMapping("/view/{idx}")
    public Board getBoard(@PathVariable Long idx){
        return boardService.getBoard(idx);
    }


    @PostMapping("/board/comment")
    public void setBoardComment(@RequestBody BoardCommentRequestDto boardCommentRequestDto){
        boardService.setBoardComment(boardCommentRequestDto);
    }

    @PutMapping(value = "/board/update/{idx}")
    public Long updateBoard(@RequestParam Long idx, BoardRequestDto requestDto) throws IOException{
        return boardService.updateBoard(idx, requestDto);
    }

    @DeleteMapping(value = "/board")
    public Long deleteBoard(@RequestParam Long idx) {
        boardService.deleteBoard(idx);
        return idx;
    }
}