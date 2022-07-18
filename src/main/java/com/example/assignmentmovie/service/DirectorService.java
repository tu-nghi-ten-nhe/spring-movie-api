package com.example.assignmentmovie.service;

import com.example.assignmentmovie.dto.DirectorDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DirectorService {
    List<DirectorDTO> getAllDirector(Pageable pageable);
    DirectorDTO createDirector(DirectorDTO directorDTO);
    DirectorDTO getById(int id);
    void deleteById(int id);
}
