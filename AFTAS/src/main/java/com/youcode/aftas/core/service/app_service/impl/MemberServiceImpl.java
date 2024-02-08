package com.youcode.aftas.core.service.app_service.impl;

import com.youcode.aftas.core.database.model.dto.response.MemberResponse;
import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Hunting;
import com.youcode.aftas.core.database.model.entity.Member;
import com.youcode.aftas.core.database.repository.MemberRepository;
import com.youcode.aftas.core.service.app_service.HuntingService;
import com.youcode.aftas.core.service.app_service.MemberService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;


    @Override
    public MemberResponse save(Member member) {
        return modelMapper.map(memberRepository.save(member), MemberResponse.class);
    }

    @Override
    public MemberResponse findById(UUID uuid) {
           return modelMapper.map(findOrThrow(uuid), MemberResponse.class);
    }

    @Override
    public List<MemberResponse> getAll() {
        List<Member> memberList = memberRepository.findAll();
        return memberList.stream()
                .map(member -> modelMapper.map(member, MemberResponse.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public MemberResponse update(Member member, UUID uuid) {
        Member source = findOrThrow(uuid);
        member.setId(source.getId());
        member.setHuntingList(source.getHuntingList());
        return modelMapper.map(memberRepository.save(member), MemberResponse.class);
    }

    @Override
    public void deleteById(UUID id) {
        memberRepository.delete(findOrThrow(id));
    }

    @Override
    public void deleteAll() {
        memberRepository.deleteAll();
    }

    @Override
    public Member findOrThrow(UUID uuid) {
        return memberRepository.findById(uuid).orElseThrow(
                () -> new NoSuchElementException("Member not found with id: " + uuid)
        );
    }

}
