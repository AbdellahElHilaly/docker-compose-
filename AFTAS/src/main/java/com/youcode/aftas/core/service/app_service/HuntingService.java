package com.youcode.aftas.core.service.app_service;

import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Fish;
import com.youcode.aftas.core.database.model.entity.Hunting;
import com.youcode.aftas.core.database.model.entity.Member;
import com.youcode.aftas.core.service.app_service.base.CrudService;

import java.util.UUID;

public interface HuntingService extends CrudService<Hunting, UUID> {
    Hunting findByMemberAndFishAndCompetition(Member member, Fish fish, Competition competition);
}
