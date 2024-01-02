package com.example.backend.model;

import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Data(staticConstructor = "of")
public class LocationPojo {

    @Nullable private final Double longitude;
    @Nullable private final Double latitude;
    @Nullable private final String json;
}
