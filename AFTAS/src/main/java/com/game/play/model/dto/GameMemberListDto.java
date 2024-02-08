package com.game.play.model.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GameMemberListDto {

    @NotNull(message = "gameId is required")
    private UUID gameId;

    @NotNull(message = "memberIds is required")
    @NotEmpty(message = "memberIds is should not be empty")
    private List<UUID> memberIds;

}
