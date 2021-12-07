package com.weling.we_are_traveling_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.weling.we_are_traveling_java.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
