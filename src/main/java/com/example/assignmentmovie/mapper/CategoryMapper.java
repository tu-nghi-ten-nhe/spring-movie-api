package com.example.assignmentmovie.mapper;

import com.example.assignmentmovie.dto.CategoryDTO;
import com.example.assignmentmovie.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CategoryMapper {
    CategoryEntity convertToEntity(CategoryDTO categoryDTO);
    CategoryDTO convertToDTO(CategoryEntity categoryEntity);

    List<CategoryDTO> convertListToDTO(List<CategoryEntity> list);
}
