package com.youcode.aftas.core.service.dummy_service.impl;

import com.youcode.aftas.core.database.repository.*;
import com.youcode.aftas.core.database.model.fake.*;
import com.youcode.aftas.core.service.dummy_service.DummyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DummyServiceImpl implements DummyService {

    private final MemberRepository memberRepository;
    private final CompetitionRepository competitionRepository;
    private final FishRepository fishRepository;
    private final HuntingRepository huntingRepository;
    private final LevelRepository levelRepository;
    private final RankingRepository rankingRepository;


    private final DummyCompetition dummyCompetition;
    private final DummyMember dummyMember;
    private final DummyFish dummyFish;
    private final DummyHunting dummyHunting;
    private final DummyLevel dummyLevel;
    private final DummyRanking dummyRanking;

    @Override
    public void save() {
        memberRepository.save(dummyMember.generate());
        competitionRepository.save(dummyCompetition.generate());
        levelRepository.save(dummyLevel.generate());
        fishRepository.save(dummyFish.generate());
        huntingRepository.save(dummyHunting.generate());
        rankingRepository.save(dummyRanking.generate());
    }

    @Override
    public void saveCollection(int size) {
        clear();
        memberRepository.saveAll(dummyMember.generateCollection(size*3));
        levelRepository.saveAll(dummyLevel.generateCollection(size));
        fishRepository.saveAll(dummyFish.generateCollection(size*3));
        competitionRepository.saveAll(dummyCompetition.generateCollection(size));
        huntingRepository.saveAll(dummyHunting.generateCollection(size));
        rankingRepository.saveAll(dummyRanking.generateCollection(size));

    }

    @Override
    public void clear() {

        rankingRepository.deleteAll();
        huntingRepository.deleteAll();


        memberRepository.deleteAll();
        competitionRepository.deleteAll();
        fishRepository.deleteAll();
        levelRepository.deleteAll();
    }


}














