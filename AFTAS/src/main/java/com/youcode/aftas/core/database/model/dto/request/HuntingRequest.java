package com.youcode.aftas.core.database.model.dto.request;

import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Fish;
import com.youcode.aftas.core.database.model.entity.Hunting;
import com.youcode.aftas.core.database.model.entity.Member;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Hunting}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HuntingRequest implements Serializable {

    @NotNull(message = "Number of fish is required")
    @Positive(message = "Number of fish should be a positive value")
    Integer numberOfFish;

    @NotNull(message = "Fish id is required")
    UUID fishId;

    @NotNull(message = "Competition id is required")
    UUID competitionId;

    @NotNull(message = "Member id is required")
    UUID memberId;

}

