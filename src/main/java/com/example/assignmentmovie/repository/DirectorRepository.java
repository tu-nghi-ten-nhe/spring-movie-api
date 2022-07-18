package com.example.assignmentmovie.repository;

import com.example.assignmentmovie.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<DirectorEntity, Integer> {
}
