package com.youcode.aftas.core.database.model.include;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RankId implements Serializable {
    @Column(name = "member_id")
    private UUID memberId;

    @Column(name = "competition_id")
    private UUID competitionId;
}

