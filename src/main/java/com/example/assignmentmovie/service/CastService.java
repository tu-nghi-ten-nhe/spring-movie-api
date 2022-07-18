package com.example.assignmentmovie.service;

import com.example.assignmentmovie.dto.CastDTO;
import com.example.assignmentmovie.entity.CastEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CastService {
    List<CastDTO> getAllCast(Pageable pageable);
    CastDTO createCast(CastDTO castDTO);
    CastDTO getById(int id);
    void deleteById(int id);
}
