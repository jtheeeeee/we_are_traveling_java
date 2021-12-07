package com.weling.we_are_traveling_java.repository;


import com.weling.we_are_traveling_java.domain.InfoComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoCommentRepository extends JpaRepository<InfoComment, Long> {
}
