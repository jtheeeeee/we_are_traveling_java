package com.weling.we_are_traveling_java.repository;


import com.weling.we_are_traveling_java.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
