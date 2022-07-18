package com.example.assignmentmovie.service;

import com.example.assignmentmovie.dto.MovieDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {
    List<MovieDTO> getAllMovie(Pageable pageable);
    MovieDTO createMovie(MovieDTO movieDTO);
    MovieDTO getById(int id);
    void deleteById(int id);
}
