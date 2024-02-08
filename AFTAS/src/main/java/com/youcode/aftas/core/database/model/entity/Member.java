package com.youcode.aftas.core.database.model.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.aftas.shared.Enum.IdentityDocumentTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer number;
    private String familyName;
    private Date accessionDate;
    private String nationality;
    private IdentityDocumentTypeEnum identityDocumentType;
    private String identityDocumentNumber;

    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    @JsonIgnore
    private List<Hunting> huntingList;

}
