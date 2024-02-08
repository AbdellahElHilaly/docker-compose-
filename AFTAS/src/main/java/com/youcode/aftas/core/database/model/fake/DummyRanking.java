package com.youcode.aftas.core.database.model.fake;

import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Member;
import com.youcode.aftas.core.database.model.include.RankId;
import com.youcode.aftas.core.database.model.entity.Ranking;
import com.youcode.aftas.core.database.repository.CompetitionRepository;
import com.youcode.aftas.core.database.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DummyRanking extends BaseFaker<Ranking>{

    private final CompetitionRepository competitionRepository;
    private final MemberRepository memberRepository;


    @Override
    public Ranking  generate() {

        List<Member>  memberList = memberRepository.findAll();
        List<Competition> competitionList = competitionRepository.findAll();

        return Ranking.builder()
                .id(RankId.builder()
                        .memberId(UUID.randomUUID())
                        .competitionId(UUID.randomUUID())
                        .build())
                .rank(faker.number().numberBetween(0, 1000))
                .score(faker.number().numberBetween(0, 1000))
                .competition(competitionList.get(faker.number().numberBetween(0, competitionList.size())))
                .member(memberList.get(faker.number().numberBetween(0, memberList.size())))
                .build();
    }


}
