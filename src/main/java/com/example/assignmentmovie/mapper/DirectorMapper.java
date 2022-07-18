package com.example.assignmentmovie.mapper;

import com.example.assignmentmovie.dto.DirectorDTO;
import com.example.assignmentmovie.entity.DirectorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DirectorMapper {
    DirectorEntity convertToEntity(DirectorDTO directorDTO);
    DirectorDTO convertToDTO(DirectorEntity directorEntity);
    List<DirectorDTO> convertListDTO(List<DirectorEntity> list);
}
