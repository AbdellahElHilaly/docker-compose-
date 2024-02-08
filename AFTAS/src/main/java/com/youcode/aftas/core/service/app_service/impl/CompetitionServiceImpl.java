package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.dto.response.CompetitionResponse;
import com.youcode.aftas.core.database.model.entity.Hunting;
import com.youcode.aftas.core.database.model.entity.Ranking;
import com.youcode.aftas.core.database.repository.CompetitionRepository;
import com.youcode.aftas.core.service.app_service.CompetitionService;
import com.youcode.aftas.core.service.app_service.HuntingService;
import com.youcode.aftas.core.service.app_service.RankingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;
    private final ModelMapper modelMapper;


    @Override
    public CompetitionResponse save(Competition competition) {
        return modelMapper.map(
                competitionRepository.save(competition), CompetitionResponse.class
        );
    }

    @Override
    public CompetitionResponse findById(UUID uuid) {
        return modelMapper.map(
                findOrThrow(uuid), CompetitionResponse.class
        );
    }

    @Override
    public List<CompetitionResponse> getAll() {
        List<Competition> competitions = competitionRepository.findAll();
        return competitions.stream()
                .map(competition -> modelMapper.map(competition, CompetitionResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompetitionResponse update(Competition competition, UUID uuid) {
        Competition source = findOrThrow(uuid);
        competition.setId(source.getId());
        competition.setHuntingList(source.getHuntingList());
        competition.setRankingList(source.getRankingList());

        return modelMapper.map(
                competitionRepository.save(competition), CompetitionResponse.class
        );
    }

    @Override
    public void deleteById(UUID uuid) {
        competitionRepository.delete(findOrThrow(uuid));
    }

    @Override
    public void deleteAll() {
        competitionRepository.deleteAll();
    }

    @Override
    public Competition findOrThrow(UUID uuid) {
        return competitionRepository.findById(uuid).orElseThrow(
                () -> new NoSuchElementException("Competition with id " + uuid + " not found")
        );
    }

    @Override
    public CompetitionResponse clearHuntingAndRanking(UUID id) {
        Competition source = findOrThrow(id);
        source.setHuntingList(null);
        source.setRankingList(null);
        return modelMapper.map(
                competitionRepository.save(source), CompetitionResponse.class
        );

    }



}

