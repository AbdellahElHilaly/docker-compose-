package com.youcode.aftas.core.database.model.fake;

import com.youcode.aftas.core.database.model.entity.Competition;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalTime;
import java.util.UUID;

@Component
public class DummyCompetition extends BaseFaker<Competition> {

    @Override
    public Competition generate() {
        return Competition.builder()
                .id(UUID.randomUUID())
                .code(faker.lorem().characters(5))
                .date(new Date(faker.date().birthday().getTime()))
                .startTime(LocalTime.of(faker.number().numberBetween(0, 24), faker.number().numberBetween(0, 60), faker.number().numberBetween(0, 60)))
                .endTime(LocalTime.of(faker.number().numberBetween(0, 24), faker.number().numberBetween(0, 60), faker.number().numberBetween(0, 60)))
                .numberOfParticipants(faker.number().numberBetween(0, 1000))
                .location(faker.address().fullAddress())
                .amount(faker.number().randomDouble(2, 0, 1000))
                .build();

    }
}



