package com.youcode.aftas.core.database.model.fake;

import com.youcode.aftas.core.database.model.entity.Level;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class DummyLevel extends BaseFaker<Level> {


    @Override
    public Level generate() {
        return Level.builder()
                .id(UUID.randomUUID())
                .code(faker.number().numberBetween(0, 1000))
                .description(faker.lorem().characters(100))
                .points(faker.number().numberBetween(0, 1000))
                .build();
    }
}



