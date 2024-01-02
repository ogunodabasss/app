package com.example.backend.rest;

import com.example.backend.model.Location;
import com.example.backend.model.req.LocationReqDTO;
import com.example.backend.service.GoogleApiService;
import com.example.backend.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class AppRestController {

    private final GoogleApiService googleApiService;
    private final LocationService locationService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Location>> findAll(@Valid LocationReqDTO locationReqDTO) {
        List<Location> res = locationService.findBy(locationReqDTO);
        log.warn("""

                load db =
                *******************
                
                {}
                
                *******************
                load db END........
                """, res);
        if (res.isEmpty()) {
            res = googleApiService.load(locationReqDTO);
            log.warn("""

                    load Google API =
                    *******************
                    
                    {}
                    
                    *******************
                    load Google API END.....
                    """, res);
        }
        return ResponseEntity.ok(res);
    }
}
