package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Fish;
import com.youcode.aftas.core.database.model.entity.Hunting;
import com.youcode.aftas.core.database.model.entity.Member;
import com.youcode.aftas.core.database.repository.HuntingRepository;
import com.youcode.aftas.core.service.app_service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HuntingServiceImpl implements HuntingService {

    private final HuntingRepository HuntingRepository;
    private final MemberService memberService;
    private final FishService fishService;
    private final CompetitionService competitionService;
    private final RankingService rankingService;

    @Override
    public Hunting save(Hunting hunting) {
        Hunting result;

        hunting.setMember(memberService.findOrThrow(hunting.getMember().getId()));
        hunting.setFish(fishService.findOrThrow(hunting.getFish().getId()));
        hunting.setCompetition(competitionService.findOrThrow(hunting.getCompetition().getId()));


        result = saveExistingHunting(hunting);
        
        if(result != null) {
            return result;
        }

        checkIfMemberIsInCompetition(hunting);

        return HuntingRepository.save(hunting);

    }

    private void checkIfMemberIsInCompetition(Hunting hunting) {
        rankingService.findByCompetitionAndMemberOrThrow( hunting.getCompetition(), hunting.getMember());
    }

    private Hunting saveExistingHunting(Hunting hunting) {
        Hunting existingHunting = findByMemberAndFishAndCompetition(
                hunting.getMember(),
                hunting.getFish(),
                hunting.getCompetition()
        );

        if (existingHunting != null) {
            existingHunting.setNumberOfFish(existingHunting.getNumberOfFish() + hunting.getNumberOfFish());
            return HuntingRepository.save(existingHunting);
        }
        return null;
    }

    @Override
    public Hunting getById(UUID uuid) {
        return HuntingRepository.findById(uuid).orElseThrow(
                () -> new NoSuchElementException("Hunting not found with id: " + uuid)
        );
    }

    @Override
    public List<Hunting> getAll() {
        return HuntingRepository.findAll();
    }

    @Override
    public Hunting update(Hunting Hunting, UUID uuid) {
        Hunting.setId(getById(uuid).getId());
        return HuntingRepository.save(Hunting);
    }

    @Override
    public void deleteById(UUID uuid) {
        HuntingRepository.deleteById(uuid);
    }

    @Override
    public void deleteAll() {
        HuntingRepository.deleteAll();
    }


    @Override
    public Hunting findByMemberAndFishAndCompetition(Member member, Fish fish, Competition competition) {
        return HuntingRepository.findByMemberAndFishAndCompetition(member, fish, competition
        ).orElse(null);
    }
}
