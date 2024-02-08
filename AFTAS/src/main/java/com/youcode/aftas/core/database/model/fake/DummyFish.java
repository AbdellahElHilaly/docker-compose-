package com.youcode.aftas.core.database.model.fake;

import com.youcode.aftas.core.database.model.entity.Fish;
import com.youcode.aftas.core.database.model.entity.Level;
import com.youcode.aftas.core.database.repository.LevelRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor (onConstructor = @__(@Autowired))
@Component
public class DummyFish extends BaseFaker<Fish> {

    private final LevelRepository levelRepository;

    @Override
    public Fish generate() {
        List<Level> levelList = levelRepository.findAll();
        int huntingListSize = faker.number().numberBetween(0, levelList.size());

        return Fish.builder()
                .name(faker.lorem().characters(5))
                .averageWeight(faker.number().randomDouble(2, 0, 1000))
                .level(levelList.get(faker.number().numberBetween(0, levelList.size())))
                .build();
    }

}
