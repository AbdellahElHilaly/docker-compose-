package com.youcode.aftas.core.controller.util;

import com.youcode.aftas.core.utils.pipe.ResponseFormat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor (onConstructor = @__(@Autowired))
public class HomeController {
    private final ResponseFormat<Object> responseFormat;

    @GetMapping
    public ResponseEntity<ResponseFormat<Object>> home() {
        return ResponseEntity.ok(responseFormat.format("welcome to aftas"));
    }

}
