package com.example.backend.model.req;

import com.example.backend.utils.clazz.Pair;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public record LocationReqDTO(@NotNull @Min(-180) @Max(180) Double longitude,
                             @NotNull @Min(-90) @Max(90) Double latitude, @NotNull @Min(1) @Max(500) Double radius) {

    public String locationToStr() {
        return latitude + "%2C" + longitude;
    }

    /**
     * TODO <a href="https://en.wikipedia.org/wiki/Haversine_formula">Haversine_formula</a>
     * <br><br>
     * <pre>
     *     +--------------------------------+
     *     |                                |
     *     |    P1                   P2     |
     *     |    .____________________.      |
     *     |    |                    |      |
     *     |    |                    |      |
     *     |    |                    |      |
     *     |    |                    |      |
     *     |    |   M(longitude,latitude)   |
     *     |    |          .         |      |
     *     |    |           \        |      |
     *     |    |     radius  \      |      |
     *     |    |               \    |      |
     *     |    |                 \  |      |
     *     |    .___________________\.      |
     *     |   P3               P4          |
     *     |                                |
     *     |                                |
     *     +--------------------------------+
     *
     * </pre>
     * <br>
     */
    @SuppressWarnings("all")
    public Pair<Double, Double>[] locationToPoint() {
        double radiusKm = radius / (1_000.0);
        Pair<Double, Double> p1 = Pair.of(longitude + radiusKm, latitude - radiusKm);
        Pair<Double, Double> p2 = Pair.of(longitude + radiusKm, latitude + radiusKm);
        Pair<Double, Double> p3 = Pair.of(longitude - radiusKm, latitude - radiusKm);
        Pair<Double, Double> p4 = Pair.of(longitude - radiusKm, latitude + radiusKm);
        Pair[] point = {p1, p2, p3, p4};

        return point;
    }
}
