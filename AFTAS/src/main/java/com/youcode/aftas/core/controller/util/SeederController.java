package com.youcode.aftas.core.controller.util;

import com.youcode.aftas.core.service.dummy_service.impl.SeederService;
import com.youcode.aftas.core.utils.pipe.ResponseFormat;
import com.youcode.aftas.shared.Const.AppEndpoints;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping(AppEndpoints.SEEDER)
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class SeederController {


    private final SeederService seederService;
    private final ResponseFormat<?> responseFormat;


    @GetMapping("/{size}")
    public ResponseEntity<ResponseFormat<?>> seedAll( @PathVariable int size) {
        seederService.seedAll(size);
        return ResponseEntity.ok(responseFormat.format(
                "Seeded successfully"
        ));
    }


}
