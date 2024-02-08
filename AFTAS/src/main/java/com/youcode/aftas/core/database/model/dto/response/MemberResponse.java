package com.youcode.aftas.core.database.model.dto.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.aftas.core.database.model.entity.Hunting;
import com.youcode.aftas.shared.Enum.IdentityDocumentTypeEnum;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MemberResponse {

    private UUID id;

    private Integer number;
    private String familyName;
    private Date accessionDate;
    private String nationality;
    private IdentityDocumentTypeEnum identityDocumentType;
    private String identityDocumentNumber;

    private List<Hunting> huntingList;








}
