package com.example.assignmentmovie.service;

import com.example.assignmentmovie.dto.CastDTO;
import com.example.assignmentmovie.entity.CastEntity;
import com.example.assignmentmovie.mapper.CastMapper;
import com.example.assignmentmovie.repository.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CastServiceImpl implements CastService{
    @Autowired
    CastRepository castRepository;
    @Autowired
    CastMapper castMapper;

    @Override
    public List<CastDTO> getAllCast(Pageable pageable) {
        List<CastEntity> list = castRepository.findAll(pageable).getContent();
        List<CastDTO> dtoList = castMapper.convertListDTO(list);
        return dtoList;
    }

    @Override
    public CastDTO createCast(CastDTO castDTO) {
        CastEntity castEntityConvert = castMapper.convertToEntity(castDTO);
        CastEntity castEntity = castRepository.save(castEntityConvert);
        CastDTO dto = castMapper.convertToDTO(castEntity);

        return dto;
    }

    @Override
    public CastDTO getById(int id) {
        CastEntity castEntity = castRepository.findById(id).get();
        CastDTO dto = castMapper.convertToDTO(castEntity);
        return dto;
    }

    @Override
    public void deleteById(int id) {
        castRepository.deleteById(id);
    }
}
