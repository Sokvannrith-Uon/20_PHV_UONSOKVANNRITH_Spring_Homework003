package com.example._0_uon_sokvannrith_spring003.controller;

import com.example._0_uon_sokvannrith_spring003.model.entity.Venue;
import com.example._0_uon_sokvannrith_spring003.model.request.VenueRequest;
import com.example._0_uon_sokvannrith_spring003.model.response.ResponseApi;
import com.example._0_uon_sokvannrith_spring003.service.VenueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class VenueController {
    public final VenueService venueService;


    @GetMapping
    public ResponseEntity<?> getAllVenues(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {

        ResponseApi<List<Venue>> response = ResponseApi.<List<Venue>>builder()
                .timestamp(Instant.now())
                .message("Retrieved venues successfully.")
                .status(HttpStatus.OK)
                .payload(venueService.getAllVenues(page, size))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{venue-id}")
    public ResponseEntity<?> getAllVenuesById(@PathVariable("venue-id") Long venueId) {
        ResponseApi<List<Venue>> response = ResponseApi.<List<Venue>>builder()
                .timestamp(Instant.now())
                .message("Retrieved venues successfully.")
                .status(HttpStatus.OK)
                .payload(venueService.getAllVenuesById(venueId))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<?> createNewVenue(@Valid @RequestBody VenueRequest request) {
        ResponseApi<List<Venue>> response = ResponseApi.<List<Venue>>builder()
                .timestamp(Instant.now())
                .message("Retrieved venues successfully.")
                .status(HttpStatus.OK)
                .payload(venueService.createNewVenue(request))
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{venue-id}")
    public ResponseEntity<?> deleteVenueById(@PathVariable("venue-id") Long venueId) {
        ResponseApi<List<Venue>> response = ResponseApi.<List<Venue>>builder()
                .timestamp(Instant.now())
                .message("Retrieved venues successfully.")
                .status(HttpStatus.OK)
                .payload(venueService.deleteVenueById(venueId))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{venue-id}")
    public ResponseEntity<?> updateVenueById(@PathVariable("venue-id") Long venueId, @Valid @RequestBody VenueRequest request) {
        ResponseApi<List<Venue>> response = ResponseApi.<List<Venue>>builder()
                .timestamp(Instant.now())
                .message("Retrieved venues successfully.")
                .status(HttpStatus.OK)
                .payload(venueService.updateVenueById(venueId, request))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
