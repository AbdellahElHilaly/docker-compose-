package com.youcode.aftas.core.database.model.fake;

import com.youcode.aftas.core.database.model.entity.Hunting;
import com.youcode.aftas.core.database.model.entity.Member;
import com.youcode.aftas.core.service.app_service.HuntingService;
import com.youcode.aftas.core.service.app_service.MemberService;
import com.youcode.aftas.shared.Enum.IdentityDocumentTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DummyMember extends BaseFaker<Member> {

    private final HuntingService huntingService;
    private final MemberService memberService;

    @Override
    public Member generate() {
        return Member.builder()
                .id(UUID.randomUUID())

                .familyName(faker.name().lastName())
                .accessionDate(new Date(faker.date().birthday().getTime()))
                .nationality(faker.country().name())
                .number(faker.number().numberBetween(0, 1000))
                .identityDocumentType(IdentityDocumentTypeEnum.values()[faker.number().numberBetween(0, IdentityDocumentTypeEnum.values().length)])
                .identityDocumentNumber(faker.idNumber().valid())
                .build();
    }




}
