package com.game.play.service.impl;

import com.game.play.service.GameService;
import com.youcode.aftas.core.service.app_service.CompetitionService;
import com.youcode.aftas.core.service.app_service.MemberService;
import com.youcode.aftas.core.service.app_service.RankingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GameServiceImpl implements GameService {

    private final CompetitionService competitionService;
    private final MemberService memberService;
    private final RankingService rankingService;






}
