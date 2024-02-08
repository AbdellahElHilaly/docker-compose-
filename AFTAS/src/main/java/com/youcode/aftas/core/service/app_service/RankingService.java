package com.youcode.aftas.core.service.app_service;

import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Member;
import com.youcode.aftas.core.database.model.include.RankId;
import com.youcode.aftas.core.database.model.entity.Ranking;
import com.youcode.aftas.core.service.app_service.base.CrudService;

public interface RankingService extends CrudService<Ranking, RankId> {
    void findByCompetitionAndMemberOrThrow(Competition competition, Member member);
}
