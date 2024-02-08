package com.youcode.aftas.core.utils.Config;

import com.youcode.aftas.core.database.model.dto.request.HuntingRequest;
import com.youcode.aftas.core.database.model.dto.request.RankingRequest;
import com.youcode.aftas.core.database.model.entity.*;
import com.youcode.aftas.core.database.model.dto.response.CompetitionResponse;
import com.youcode.aftas.core.database.model.dto.response.FishResponse;
import com.youcode.aftas.core.database.model.dto.response.LevelResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class Mapper {

    @Configuration
    public static class ModelMapperConfig {
        @Bean
        public ModelMapper modelMapper() {
            ModelMapper modelMapper = new ModelMapper();



            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

            modelMapper.typeMap(Competition.class, CompetitionResponse.class)
                    .addMapping(Competition::getRankingList, CompetitionResponse::setRankingList);

            modelMapper.typeMap(Level.class, LevelResponse.class)
                    .addMapping(Level::getFishList, LevelResponse::setFishList);

            modelMapper.typeMap(Fish.class, FishResponse.class)
                    .addMapping(Fish::getHuntingList, FishResponse::setHuntingList);

            modelMapper.typeMap(Fish.class, FishResponse.class)
                    .addMapping(Fish::getHuntingList, FishResponse::setHuntingList);

            modelMapper.createTypeMap(HuntingRequest.class, Hunting.class)
                    .addMapping(HuntingRequest::getNumberOfFish, Hunting::setNumberOfFish)
                    .addMapping(HuntingRequest::getFishId, (destination, value) -> destination.getFish().setId((UUID) value))
                    .addMapping(HuntingRequest::getCompetitionId, (destination, value) -> destination.getCompetition().setId((UUID) value))
                    .addMapping(HuntingRequest::getMemberId, (destination, value) -> destination.getMember().setId((UUID) value));

            modelMapper.createTypeMap(RankingRequest.class, Ranking.class)

                    .addMapping(RankingRequest::getRank, Ranking::setRank)
                    .addMapping(RankingRequest::getScore, Ranking::setScore)

                    .addMapping(RankingRequest::getMemberId, (destination, value) -> destination.getMember().setId((UUID) value))
                    .addMapping(RankingRequest::getCompetitionId, (destination, value) -> destination.getCompetition().setId((UUID) value));

            return modelMapper;
        }
    }
}

