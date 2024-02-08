package com.youcode.aftas.core.controller.util;

import com.youcode.aftas.shared.Const.AppEndpoints;
import com.youcode.aftas.shared.Enum.IdentityDocumentTypeEnum;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(AppEndpoints.IDENTITY_DOCUMENT_TYPE)
public class IdentityDocumentTypeController {

    @GetMapping
    public ResponseEntity<List<IdentityDocumentTypeEnum>> getIdentityDocumentTypes() {
        return ResponseEntity.ok(List.of(IdentityDocumentTypeEnum.values()));
    }


}
