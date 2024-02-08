package com.youcode.aftas.core.controller;

import com.youcode.aftas.core.database.model.dto.request.MemberRequest;
import com.youcode.aftas.core.database.model.dto.response.MemberResponse;
import com.youcode.aftas.core.database.model.entity.Member;
import com.youcode.aftas.core.service.app_service.MemberService;
import com.youcode.aftas.core.utils.pipe.ResponseFormat;
import com.youcode.aftas.shared.Const.AppEndpoints;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(AppEndpoints.MEMBER)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MemberController {

    private final MemberService memberService;
    private final ModelMapper modelMapper;
    private final ResponseFormat<List<MemberResponse>> responseFormatList;
    private final ResponseFormat<MemberResponse> responseFormat;
    private final ResponseFormat<Void> responseFormatVoid;

    @GetMapping
    public ResponseEntity<ResponseFormat<List<MemberResponse>>> getAll() {
        return ResponseEntity.ok(
                responseFormatList.format(
                        memberService.getAll(),
                        "Members retrieved successfully"
                ));
    }

    @PostMapping
    public ResponseEntity<ResponseFormat<MemberResponse>> save(@Valid  @RequestBody MemberRequest memberRequest) {
        return ResponseEntity.ok(responseFormat.format(
                memberService.save(modelMapper.map(memberRequest, Member.class)),
                "Member saved successfully"
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFormat<MemberResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                memberService.findById(id),
                "Member retrieved successfully"
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseFormat<MemberResponse>> update(@Valid  @RequestBody MemberRequest memberRequest, @PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                memberService.update(modelMapper.map(memberRequest, Member.class), id),
                "Member updated successfully"
        ));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseFormat<Void>> deleteById(@PathVariable UUID id) {
        memberService.deleteById(id);
        return ResponseEntity.ok(responseFormatVoid.format(
                "Member deleted successfully"
        ));
    }

    @DeleteMapping
    public ResponseEntity<ResponseFormat<Void>> deleteAll() {
        memberService.deleteAll();
        return ResponseEntity.ok(responseFormatVoid.format(
                "Members deleted successfully"
        ));
    }

}

