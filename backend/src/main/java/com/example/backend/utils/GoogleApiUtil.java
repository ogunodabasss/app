package com.example.backend.utils;

import com.example.backend.model.Location;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoogleApiUtil {
    public static final String KEY = System.getenv("google.api.key");
    public static final String URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";


    @SneakyThrows
    public static List<Location> jsonFindLocations(final JsonNode jsonNode) {
        final List<Location> locations;
        if (!Page.isZero(jsonNode)) {
            ArrayNode arrayNode = jsonNode.withArray("/results");
            locations = new ArrayList<>(arrayNode.size());
            for (JsonNode node : arrayNode) {
                locations.add(Location.of(
                        node.at("/geometry/location/lng").doubleValue(),
                        node.at("/geometry/location/lat").doubleValue(),
                        node.toString()
                ));
            }
        } else locations = Collections.emptyList();
        return locations;
    }

   public static class Page {
        @SneakyThrows
        public static boolean isZero(JsonNode jsonNode) {
            return jsonNode.at("/status").asText().equals("ZERO_RESULTS");
        }

        @SneakyThrows
        public static boolean isNext(JsonNode jsonNode) {
            return !jsonNode.at("/next_page_token").isMissingNode();
        }

        @SneakyThrows
        public static String nextToken(JsonNode jsonNode) {
            return jsonNode.at("/next_page_token").asText();
        }

    }
}
