package com.youcode.aftas.core.database.model.dto.request;

import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Member;
import com.youcode.aftas.core.database.model.entity.Ranking;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Ranking}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankingRequest implements Serializable {
    @NotNull(message = "Rank is required")
    @PositiveOrZero(message = "Rank should be positive or zero")
    Integer rank;

    @NotNull(message = "Score is required")
    @PositiveOrZero(message = "Rank should be positive or zero")
    Integer score;

    @NotNull(message = "Competition id is required")
    UUID competitionId;

    @NotNull(message = "Member id is required")
    UUID memberId;

}