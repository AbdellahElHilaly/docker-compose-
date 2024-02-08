package com.youcode.aftas.core.controller;

import com.youcode.aftas.core.database.model.dto.request.FishRequest;
import com.youcode.aftas.core.database.model.entity.Fish;
import com.youcode.aftas.core.database.model.dto.response.FishResponse;
import com.youcode.aftas.core.service.app_service.FishService;
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
@RequestMapping(AppEndpoints.FISH)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FishController {

    private final FishService FishService;
    private final ModelMapper modelMapper;
    private final ResponseFormat<List<FishResponse>> responseFormatList;
    private final ResponseFormat<FishResponse> responseFormat;
    private final ResponseFormat<Void> responseFormatVoid;


    @GetMapping
    public ResponseEntity<ResponseFormat<List<FishResponse>>> getAll() {
        return ResponseEntity.ok(
                responseFormatList.format(
                        FishService.getAll(),
                        "Fish list retrieved successfully"
                ));
    }

    @PostMapping
    public ResponseEntity<ResponseFormat<FishResponse>> save(@Valid @RequestBody FishRequest FishRequest) {
        return ResponseEntity.ok(responseFormat.format(
                FishService.save(modelMapper.map(FishRequest, Fish.class)),
                "Fish saved successfully"
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFormat<FishResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                FishService.findById(id),
                "Fish retrieved successfully"
        ));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ResponseFormat<FishResponse>> update(@Valid @RequestBody FishRequest FishRequest, @PathVariable UUID id) {
        return ResponseEntity.ok(responseFormat.format(
                FishService.update(modelMapper.map(FishRequest, Fish.class), id),
                "Fish updated successfully"
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseFormat<Void>> deleteById(@PathVariable UUID id) {
        FishService.deleteById(id);
        return ResponseEntity.ok(responseFormatVoid.format(
                "Fish deleted successfully"
        ));
    }

    @DeleteMapping
    public ResponseEntity<ResponseFormat<Void>> deleteAll() {
        FishService.deleteAll();
        return ResponseEntity.ok(responseFormatVoid.format(
                "Fish deleted successfully"
        ));
    }

    

}