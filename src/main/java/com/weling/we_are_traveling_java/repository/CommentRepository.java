package com.weling.we_are_traveling_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.stream.events.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
