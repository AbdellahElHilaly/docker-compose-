package com.youcode.aftas.core.service.app_service;

import com.youcode.aftas.core.database.model.dto.response.FishResponse;
import com.youcode.aftas.core.database.model.entity.Fish;
import com.youcode.aftas.core.database.repository.FishRepository;
import com.youcode.aftas.core.service.app_service.impl.FishServiceImpl;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@Data
class FishServiceTest {

    @Autowired
    private FishServiceImpl fishService;

    @SpyBean
    private FishRepository fishRepository;

    @Test
    public void testSaveFish() {
        
        Fish fish = new Fish();
        when(fishRepository.save(fish)).thenReturn(fish);

        FishResponse fishResponse = fishService.save(fish);

        assertNotNull(fishResponse);
    }

    @Test
    public void testFindByNonExistingId() {
        UUID uuid = UUID.randomUUID();
        Fish fish = Fish.builder().id(uuid).build();
        when(fishRepository.findById(uuid)).thenReturn(Optional.of(fish));

        FishResponse fishResponse = fishService.findById(uuid);

        assertNotNull(fishResponse);
    }
}