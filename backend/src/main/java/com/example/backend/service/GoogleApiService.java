package com.example.backend.service;

import com.example.backend.model.Location;
import com.example.backend.model.LocationPojo;
import com.example.backend.model.req.LocationReqDTO;
import com.example.backend.utils.GoogleApiUtil;
import com.example.backend.utils.JacksonUtil;
import com.example.backend.utils.RequestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

@Service
@RequiredArgsConstructor
public class GoogleApiService {

    private final LocationService locationService;
    private final ThreadPoolExecutor threadPoolExecutor;

    @SneakyThrows
    public List<Location> load(LocationReqDTO locationReqDTO) {
        Map<String, String> params = Map.ofEntries(
               // Map.entry("keyword", "cruise"),
                Map.entry("location", locationReqDTO.locationToStr()),
                Map.entry("radius", locationReqDTO.radius().toString()),
               // Map.entry("type", "restaurant"),
                Map.entry("key", GoogleApiUtil.KEY)
        );
        final String json = RequestUtil.getRequest(GoogleApiUtil.URL, params);
        final JsonNode jsonNode = JacksonUtil.MAPPER.readTree(json);

        if (GoogleApiUtil.Page.isZero(jsonNode))
            return Collections.emptyList();

        List<Location> locations = GoogleApiUtil.jsonFindLocations(jsonNode);
        boolean isFindNext = GoogleApiUtil.Page.isNext(jsonNode);
        if (isFindNext) {
            //String nextToken = GoogleApiUtil.Page.nextToken(jsonNode);
            //locations.addAll(loadNext(nextToken));
            locations.addAll(loadNext(null));
        }
            threadPoolExecutor.execute(() -> {
                boolean[] findByExits = locationService.findByExitsBatch(locations.stream()
                        .map(location -> LocationPojo.of(location.longitude(), location.latitude(), null))
                        .toList()
                );
                List<Location> locationsInsertBatch = new ArrayList<>(locations.size());
                for (byte i = 0; i < findByExits.length; i++)
                    if (!findByExits[i])
                        locationsInsertBatch.add(locations.get(i));
                locationService.insertBatch(locationsInsertBatch);
            });
        return locations;
    }

    private List<Location> loadNext(String nextPageToken) throws JsonProcessingException {
        if (nextPageToken == null)
            return Collections.emptyList();
        List<Location> res = new ArrayList<>();
        JsonNode jsonNode = null;
        do {
            Map<String, String> params = Map.ofEntries(
                    Map.entry("next_page_token", nextPageToken),
                    Map.entry("key", GoogleApiUtil.KEY)
            );
            final String json = RequestUtil.getRequest(GoogleApiUtil.URL, params);
            jsonNode = JacksonUtil.MAPPER.readTree(json);
            nextPageToken = GoogleApiUtil.Page.nextToken(jsonNode);
            List<Location> locations = GoogleApiUtil.jsonFindLocations(jsonNode);
            res.addAll(locations);
        }
        while (GoogleApiUtil.Page.isNext(jsonNode) && !GoogleApiUtil.Page.isZero(jsonNode));
        return res;
    }
}
