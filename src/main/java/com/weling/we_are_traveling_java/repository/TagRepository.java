package com.weling.we_are_traveling_java.repository;

import com.weling.we_are_traveling_java.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
