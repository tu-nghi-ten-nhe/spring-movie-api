package com.example.assignmentmovie.service;

import com.example.assignmentmovie.dto.CategoryDTO;
import com.example.assignmentmovie.entity.CategoryEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO getById(int id);
    List<CategoryDTO> getAllCategory(Pageable pageable);
    void deleteCategory(int id);
}
