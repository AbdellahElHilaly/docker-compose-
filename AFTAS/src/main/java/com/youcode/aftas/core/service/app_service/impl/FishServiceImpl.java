package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.database.model.entity.Fish;
import com.youcode.aftas.core.database.model.dto.response.FishResponse;
import com.youcode.aftas.core.database.repository.FishRepository;
import com.youcode.aftas.core.service.app_service.FishService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FishServiceImpl implements FishService {

    private final FishRepository fishRepository;
    private final ModelMapper modelMapper;


    @Override
    public FishResponse save(Fish fish) {
        return modelMapper.map(fishRepository.save(fish), FishResponse.class);
    }

    @Override
    public FishResponse findById(UUID uuid) {
        return modelMapper.map(findOrThrow(uuid), FishResponse.class);
    }

    @Override
    public List<FishResponse> getAll() {
        List<Fish> fishList = fishRepository.findAll();
        return fishList.stream()
                .map(fish -> modelMapper.map(fish, FishResponse.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public FishResponse update(Fish fish, UUID uuid) {
        fish.setId(findOrThrow(uuid).getId());
        return modelMapper.map(fishRepository.save(fish), FishResponse.class);
    }

    @Override
    public void deleteById(UUID uuid) {
        fishRepository.delete(findOrThrow(uuid));
    }

    @Override
    public void deleteAll() {
        fishRepository.deleteAll();
    }

    @Override
    public Fish findOrThrow(UUID uuid) {
        return fishRepository.findById(uuid).orElseThrow(
                () -> new NoSuchElementException("Fish not found with id: " + uuid)
        );
    }
}
