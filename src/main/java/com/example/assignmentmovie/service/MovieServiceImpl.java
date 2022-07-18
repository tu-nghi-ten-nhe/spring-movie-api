package com.example.assignmentmovie.service;

import com.example.assignmentmovie.dto.MovieDTO;
import com.example.assignmentmovie.entity.MovieEntity;
import com.example.assignmentmovie.mapper.MovieMapper;
import com.example.assignmentmovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieMapper movieMapper;
    @Override
    public List<MovieDTO> getAllMovie(Pageable pageable) {
        List<MovieEntity> list = movieRepository.findAll(pageable).getContent();
        List<MovieDTO> list1 = movieMapper.convertListDTO(list);
        return list1;
    }

    @Override
    public MovieDTO createMovie(MovieDTO movieDTO) {
        MovieEntity movieEntityConvert = movieMapper.convertToEntity(movieDTO);
        MovieEntity movieEntity = movieRepository.save(movieEntityConvert);
        MovieDTO dto = movieMapper.convertToDTO(movieEntity);
        return dto;
    }

    @Override
    public MovieDTO getById(int id) {
        MovieEntity movie = movieRepository.findById(id).get();
        MovieDTO dto = movieMapper.convertToDTO(movie);
        return dto;
    }

    @Override
    public void deleteById(int id) {
        movieRepository.deleteById(id);
    }
}
