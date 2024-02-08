package com.youcode.aftas.core.database.model.dto.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.youcode.aftas.core.database.model.entity.Member;
import com.youcode.aftas.core.database.model.include.RankId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class RankingResponse {
    private RankId id;
    private Integer rank;
    private Integer score;
    private Member member;
}
