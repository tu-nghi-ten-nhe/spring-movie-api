package com.example.assignmentmovie.mapper;

import com.example.assignmentmovie.dto.MovieDTO;
import com.example.assignmentmovie.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MovieMapper {
    MovieEntity convertToEntity(MovieDTO movieDTO);
    MovieDTO convertToDTO(MovieEntity movie);
    List<MovieDTO> convertListDTO(List<MovieEntity> list);
}
