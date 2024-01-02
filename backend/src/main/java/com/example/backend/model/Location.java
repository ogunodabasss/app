package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data(staticConstructor = "of")
@Getter(onMethod = @__(@JsonProperty))
public class Location {
    @NotNull private final Double longitude;
    @NotNull private final Double latitude;
    @NotNull private final String json;

}
