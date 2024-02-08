package com.game.play.controller;

import com.game.play.model.dto.GameMemberListDto;
import com.game.play.service.GameService;
import com.youcode.aftas.shared.Const.AppEndpoints;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppEndpoints.GAME_PLAY)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GamePlayController {

    private final GameService gameService;

    @PostMapping("/add-members")
    public ResponseEntity<GameMemberListDto> addMembers(@Valid @RequestBody GameMemberListDto gameMemberListDto) {
        return ResponseEntity.ok(gameMemberListDto);
    }

    @PostMapping("/remove-members")
    public ResponseEntity<GameMemberListDto> removeMembers(@Valid @RequestBody GameMemberListDto gameMemberListDto) {
        return ResponseEntity.ok(gameMemberListDto);
    }

}
