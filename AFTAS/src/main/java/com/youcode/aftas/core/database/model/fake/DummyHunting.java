package com.youcode.aftas.core.database.model.fake;

import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Fish;
import com.youcode.aftas.core.database.model.entity.Hunting;
import com.youcode.aftas.core.database.repository.CompetitionRepository;
import com.youcode.aftas.core.database.repository.FishRepository;
import com.youcode.aftas.core.database.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DummyHunting extends BaseFaker<Hunting> {

    private final FishRepository fishRepository;
    private final CompetitionRepository competitionRepository;
    private final MemberRepository memberRepository;

    @Override
    public Hunting generate() {
        List<Fish> fishList = fishRepository.findAll();
        List<Competition> competitionList = competitionRepository.findAll();
        return Hunting.builder()
                .id(UUID.randomUUID())
                .numberOfFish(faker.number().randomDigit())
                .fish(fishList.get(faker.number().numberBetween(0, fishList.size())))
                .competition(competitionList.get(faker.number().numberBetween(0, competitionList.size())))
                .member(memberRepository.findAll().get(faker.number().numberBetween(0, memberRepository.findAll().size())))
                .build();
    }
}
