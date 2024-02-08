package com.youcode.aftas.core.controller;

import com.youcode.aftas.core.database.model.dto.request.RankingRequest;
import com.youcode.aftas.core.database.model.include.RankId;
import com.youcode.aftas.core.database.model.entity.Ranking;
import com.youcode.aftas.core.service.app_service.RankingService;
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
@RequestMapping(AppEndpoints.RANKING)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RankingController {

    private final RankingService RankingService;
    private final ModelMapper modelMapper;
    private final ResponseFormat<List<Ranking>> responseFormatList;
    private final ResponseFormat<Ranking> responseFormat;
    private final ResponseFormat<Void> responseFormatVoid;


    @GetMapping
    public ResponseEntity<ResponseFormat<List<Ranking>>> getAll() {
        return ResponseEntity.ok(
                responseFormatList.format(
                        RankingService.getAll(),
                        "Ranking list retrieved successfully"
                ));
    }



    @PostMapping
    public ResponseEntity<ResponseFormat<Ranking>> save(@Valid @RequestBody RankingRequest RankingRequest) {
        return ResponseEntity.ok(responseFormat.format(
                RankingService.save(modelMapper.map(RankingRequest, Ranking.class)),
                "Ranking saved successfully"
        ));
    }

    @GetMapping("/{memberId}/{competitionId}")
    public ResponseEntity<ResponseFormat<Ranking>> getById(
            @PathVariable UUID memberId, @PathVariable UUID competitionId) {

        return ResponseEntity.ok(responseFormat.format(
                RankingService.getById(RankId.builder().memberId(memberId).competitionId(competitionId).build()),
                "Ranking retrieved successfully"
        ));
    }


    @PutMapping("/{memberId}/{competitionId}")
    public ResponseEntity<ResponseFormat<Ranking>> update(
            @Valid @RequestBody RankingRequest RankingRequest, @PathVariable UUID memberId,
            @PathVariable UUID competitionId) {

        return ResponseEntity.ok(responseFormat.format(
                RankingService.update(modelMapper.map(RankingRequest, Ranking.class),
                        RankId.builder().memberId(memberId).competitionId(competitionId).build()),
                "Ranking updated successfully"
        ));

    }


    @DeleteMapping("/{memberId}/{competitionId}")
    public ResponseEntity<ResponseFormat<Void>> deleteById(@PathVariable UUID memberId, @PathVariable UUID competitionId) {
        RankingService.deleteById(RankId.builder().memberId(memberId).competitionId(competitionId).build());
        return ResponseEntity.ok(responseFormatVoid.format(
                "Ranking deleted successfully"
        ));
    }

    @DeleteMapping
    public ResponseEntity<ResponseFormat<Void>> deleteAll() {
        RankingService.deleteAll();
        return ResponseEntity.ok(responseFormatVoid.format(
                "Ranking deleted successfully"
        ));
    }

}
