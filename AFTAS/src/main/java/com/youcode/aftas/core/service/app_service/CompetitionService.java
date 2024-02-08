package com.youcode.aftas.core.service.app_service;

import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.dto.response.CompetitionResponse;
import com.youcode.aftas.core.service.app_service.base.CrudVmService;

import java.util.UUID;

public interface CompetitionService extends CrudVmService<Competition, CompetitionResponse, UUID> {

    CompetitionResponse clearHuntingAndRanking(UUID id);

}
