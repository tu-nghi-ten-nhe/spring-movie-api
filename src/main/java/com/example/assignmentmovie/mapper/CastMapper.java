package com.example.assignmentmovie.mapper;

import com.example.assignmentmovie.dto.CastDTO;
import com.example.assignmentmovie.entity.CastEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CastMapper {
    CastEntity convertToEntity(CastDTO castDTO);
    CastDTO convertToDTO(CastEntity castEntity);

    List<CastDTO> convertListDTO(List<CastEntity> list);
}
