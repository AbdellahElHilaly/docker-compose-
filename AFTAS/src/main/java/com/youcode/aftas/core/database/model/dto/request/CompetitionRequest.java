package com.youcode.aftas.core.database.model.dto.request;


import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Hunting;
import com.youcode.aftas.core.database.model.entity.Ranking;
import jakarta.validation.constraints.*;
import lombok.Value;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

/**
 * DTO for {@link Competition}
 */
@Value
public class CompetitionRequest {

    @NotBlank(message = "Code is required")
    @Size(max = 255, message = "Code should not exceed 255 characters")
    String code;

    @NotNull(message = "Date is required")
    @Future(message = "Date should be in the future")
    Date date;

    @NotNull(message = "Start time is required")
    @FutureOrPresent(message = "Start time should be in the present or future")
    LocalTime startTime;

    @NotNull(message = "End time is required")
    @FutureOrPresent(message = "End time should be in the present or future")
    LocalTime endTime;

    Integer numberOfParticipants;

    @NotBlank(message = "Location is required")
    @Size(max = 255, message = "Location should not exceed 255 characters")
    String location;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount should be positive")
    Double amount;

    @AssertTrue(message = "End time should be greater than Start time")
    public boolean isEndTimeAfterStartTime() {
        return endTime.isAfter(startTime);
    }

    List<Ranking> rankingList;


}



