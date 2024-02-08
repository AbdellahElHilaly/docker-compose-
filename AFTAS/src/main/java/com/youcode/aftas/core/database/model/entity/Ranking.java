package com.youcode.aftas.core.database.model.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.youcode.aftas.core.database.model.include.RankId;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"member_id", "competition_id"})})
public class Ranking {

    @EmbeddedId
    private RankId id;
    
    @Column(name = "column_rank")
    private Integer rank;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @MapsId("memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    @MapsId("competitionId")
    private Competition competition;

}
