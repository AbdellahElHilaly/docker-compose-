package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.database.model.entity.Level;
import com.youcode.aftas.core.database.model.dto.response.LevelResponse;
import com.youcode.aftas.core.database.repository.LevelRepository;
import com.youcode.aftas.core.service.app_service.LevelService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LevelServiceImpl implements LevelService {

    private final LevelRepository LevelRepository;
    private final ModelMapper modelMapper;

    @Override
    public LevelResponse save(Level level) {
        return modelMapper.map(
                LevelRepository.save(level), LevelResponse.class
        );
    }

    @Override
    public LevelResponse findById(UUID uuid) {
        return modelMapper.map(
                findOrThrow(uuid), LevelResponse.class
        );
    }

    @Override
    public List<LevelResponse> getAll() {
        List<Level> levels = LevelRepository.findAll();
        return levels.stream()
                .map(level -> modelMapper.map(level, LevelResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public LevelResponse update(Level level, UUID uuid) {
        level.setId(findOrThrow(uuid).getId());
        return modelMapper.map(
                LevelRepository.save(level), LevelResponse.class
        );
    }

    @Override
    public void deleteById(UUID uuid) {
        LevelRepository.delete(findOrThrow(uuid));
    }

    @Override
    public void deleteAll() {
        LevelRepository.deleteAll();
    }

    @Override
    public Level findOrThrow(UUID uuid) {
        return LevelRepository.findById(uuid).orElseThrow(
                () -> new NoSuchElementException("Level with id " + uuid + " not found")
        );
    }
}
