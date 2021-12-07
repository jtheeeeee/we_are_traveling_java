package com.weling.we_are_traveling_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.weling.we_are_traveling_java.domain.Comment;
import com.weling.we_are_traveling_java.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
