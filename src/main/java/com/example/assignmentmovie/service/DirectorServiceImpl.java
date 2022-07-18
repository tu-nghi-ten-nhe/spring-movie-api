package com.example.assignmentmovie.service;

import com.example.assignmentmovie.dto.DirectorDTO;
import com.example.assignmentmovie.entity.DirectorEntity;
import com.example.assignmentmovie.mapper.DirectorMapper;
import com.example.assignmentmovie.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DirectorServiceImpl implements DirectorService{
    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    DirectorMapper directorMapper;

    @Override
    public List<DirectorDTO> getAllDirector(Pageable pageable) {
        List<DirectorEntity> list = directorRepository.findAll(pageable).getContent();
        List<DirectorDTO> list1 = directorMapper.convertListDTO(list);
        return list1;
    }

    @Override
    public DirectorDTO createDirector(DirectorDTO directorDTO) {
        DirectorEntity directorEntityConvert = directorMapper.convertToEntity(directorDTO);
        DirectorEntity directorEntity = directorRepository.save(directorEntityConvert);
        DirectorDTO dto = directorMapper.convertToDTO(directorEntity);
        return dto;
    }

    @Override
    public DirectorDTO getById(int id) {
        DirectorEntity directorEntity = directorRepository.findById(id).get();
        DirectorDTO dto = directorMapper.convertToDTO(directorEntity);
        return dto;
    }

    @Override
    public void deleteById(int id) {
        directorRepository.deleteById(id);
    }
}
