package com.youcode.aftas.core.database.model.dto.request;

import com.youcode.aftas.core.database.model.entity.Level;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Level}
 */
@Value
public class LevelRequest implements Serializable {

    @NotNull(message = "Code is required")
    @Positive(message = "Code should be a positive value")
    Integer code;

    @NotBlank(message = "Description is required")
    String description;

    @NotNull(message = "Points are required")
    @Positive(message = "Points should be a positive value")
    Integer points;
}
