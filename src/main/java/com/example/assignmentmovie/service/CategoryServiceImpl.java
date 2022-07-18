package com.example.assignmentmovie.service;

import com.example.assignmentmovie.dto.CategoryDTO;
import com.example.assignmentmovie.entity.CategoryEntity;
import com.example.assignmentmovie.mapper.CategoryMapper;
import com.example.assignmentmovie.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntityConvert = categoryMapper.convertToEntity(categoryDTO);
        CategoryEntity categoryEntity = categoryRepository.save(categoryEntityConvert);
        CategoryDTO dto = categoryMapper.convertToDTO(categoryEntity);
        return dto;
    }

    @Override
    public CategoryDTO getById(int id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).get();
        CategoryDTO dto = categoryMapper.convertToDTO(categoryEntity);
        return dto;
    }

    @Override
    public List<CategoryDTO> getAllCategory(Pageable pageable) {
       List<CategoryEntity> list = categoryRepository.findAll(pageable).getContent();
       List<CategoryDTO> list1 = categoryMapper.convertListToDTO(list);
       return list1;
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
