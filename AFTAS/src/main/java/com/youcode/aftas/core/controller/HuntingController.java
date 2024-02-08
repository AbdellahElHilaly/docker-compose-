package com.youcode.aftas.core.controller;

import com.youcode.aftas.core.database.model.dto.request.HuntingRequest;
import com.youcode.aftas.core.database.model.entity.Hunting;
import com.youcode.aftas.core.service.app_service.HuntingService;
import com.youcode.aftas.core.utils.pipe.ResponseFormat;
import com.youcode.aftas.shared.Const.AppEndpoints;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(AppEndpoints.HUNTING)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HuntingController {

    private final HuntingService HuntingService;
    private final ModelMapper modelMapper;
    private final ResponseFormat<List<Hunting>> responseFormatList;
    private final ResponseFormat<Hunting> responseFormat;
    private final ResponseFormat<Void> responseFormatVoid;

    @GetMapping
    public ResponseEntity<ResponseFormat<List<Hunting>>> getAll() {
        return ResponseEntity.ok(
                responseFormatList.format(
                        HuntingService.getAll(),
                        "Hunting list retrieved successfully"
                ));
    }



    @PostMapping
    public ResponseEntity<ResponseFormat<Hunting>> save(@Valid @RequestBody HuntingRequest HuntingRequest) {
        return ResponseEntity.ok(responseFormat.format(
                HuntingService.save(modelMapper.map(HuntingRequest, Hunting.class)),
                "Hunting saved successfully"
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFormat<Hunting>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                HuntingService.getById(id),
                "Hunting retrieved successfully"
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseFormat<Hunting>> update(@Valid  @RequestBody HuntingRequest HuntingRequest, @PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                HuntingService.update(modelMapper.map(HuntingRequest, Hunting.class), id),
                "Hunting updated successfully"
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseFormat<Void>> deleteById(@PathVariable UUID id) {
        HuntingService.deleteById(id);
        return ResponseEntity.ok(responseFormatVoid.format(
                "Hunting deleted successfully"
        ));
    }

    @DeleteMapping
    public ResponseEntity<ResponseFormat<Void>> deleteAll() {
        HuntingService.deleteAll();
        return ResponseEntity.ok(responseFormatVoid.format(
                "Hunting list deleted successfully"
        ));
    }
    
    
    
}
