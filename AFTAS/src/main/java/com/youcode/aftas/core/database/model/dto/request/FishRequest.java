package com.youcode.aftas.core.database.model.dto.request;

import com.youcode.aftas.core.database.model.entity.Fish;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Fish}
 */
@Value
public class FishRequest implements Serializable {

    @NotBlank(message = "name is required")
    @Size(min = 4, max = 255, message = "Name should be between 4 and 255 characters")
    String name;

    @NotBlank(message = "averageWeight is required")
    @Size(max = 255, message = "averageWeight should not exceed 255 characters")
    @Positive(message = "Average weight should be a positive value")
    Double averageWeight;
}