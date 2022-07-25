package com.sparta.spring1.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {
    List<FreeBoard> findAllByOrderByCreatedAtDesc();
}
