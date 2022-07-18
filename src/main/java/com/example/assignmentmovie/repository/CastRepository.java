package com.example.assignmentmovie.repository;

import com.example.assignmentmovie.entity.CastEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CastRepository extends JpaRepository<CastEntity, Integer> {
}
