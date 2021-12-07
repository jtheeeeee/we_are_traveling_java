package com.weling.we_are_traveling_java.repository;

import com.weling.we_are_traveling_java.domain.Board;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @EntityGraph(attributePaths = {"comments","tags"})
    List<Board> findAllByTagsName(String name);
    List<Board> findAllByTitleOrContent(String title, String content);

    @EntityGraph(attributePaths = {"comments","tags"})
    @Override
    List<Board> findAll();
}

