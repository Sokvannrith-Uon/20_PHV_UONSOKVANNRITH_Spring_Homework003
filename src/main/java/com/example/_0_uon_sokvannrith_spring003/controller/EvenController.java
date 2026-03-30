package com.example._0_uon_sokvannrith_spring003.controller;

import com.example._0_uon_sokvannrith_spring003.model.entity.Attendee;
import com.example._0_uon_sokvannrith_spring003.model.request.AttendeeRequest;
import com.example._0_uon_sokvannrith_spring003.model.response.ResponseApi;
import com.example._0_uon_sokvannrith_spring003.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
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
public class EvenController {
    public final EventService eventService;
    @Operation(summary = "Retrive all attendees")
    @GetMapping
    public ResponseEntity<?> getAllEvens(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        ResponseApi<List<Attendee>> response = ResponseApi.<List<Attendee>>builder()
                .timestamp(Instant.now())
                .message("Retrieved attendees successfully.")
                .status(HttpStatus.OK)
                .payload(eventService.getAllEvens(page, size))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{attendee-id}")
    public ResponseEntity<?> getEvenById(@PathVariable("attendee-id" ) Long attendeeId) {
        ResponseApi<List<Attendee>> response = ResponseApi.<List<Attendee>>builder()
                .timestamp(Instant.now())
                .message("Retrieved attendees By id successfully.")
                .status(HttpStatus.OK)
                .payload(eventService.getEvenById(attendeeId))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "Create a new attendee")
    @PostMapping
    public ResponseEntity<?> postNewEven(@Valid @RequestBody AttendeeRequest request) {
        ResponseApi<List<Attendee>> response = ResponseApi.<List<Attendee>>builder()
                .timestamp(Instant.now())
                .message("Post attendees successfully.")
                .status(HttpStatus.OK)
                .payload(eventService.postNewEven(request))
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Delete attendee by Id")
    @DeleteMapping("/{attendee-id}")
    public ResponseEntity<?> deleteEvenById(@PathVariable("attendee-id") Long attendeeId) {
        ResponseApi<List<Attendee>> response = ResponseApi.<List<Attendee>>builder()
                .timestamp(Instant.now())
                .message("Delete attendees successfully.")
                .status(HttpStatus.OK)
                .payload(eventService.deleteEvenById(attendeeId))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "Update attendee by Id")
    @PutMapping("/{attendee-id}")
    public ResponseEntity<?> updateEvenById(@PathVariable("attendee-id") Long attendeeId, @Valid @RequestBody AttendeeRequest request) {
        ResponseApi<List<Attendee>> response = ResponseApi.<List<Attendee>>builder()
                .timestamp(Instant.now())
                .message("updated attendees successfully.")
                .status(HttpStatus.OK)
                .payload(eventService.updateEvenById(attendeeId, request))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
