package com.example._0_uon_sokvannrith_spring003.controller;

import com.example._0_uon_sokvannrith_spring003.model.entity.Event;
import com.example._0_uon_sokvannrith_spring003.model.request.EventRequest;
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
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @Operation(summary = "Retrieve all events")
    @GetMapping
    public ResponseEntity<?> getAllEvents(@RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "10") int size) {
        ResponseApi<List<Event>> response = ResponseApi.<List<Event>>builder()
                .timestamp(Instant.now())
                .message("Retrieved events successfully.")
                .status(HttpStatus.OK)
                .payload(eventService.getAllEvents(page, size))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<?> getEventById(@PathVariable Long eventId) {
        ResponseApi<Event> response = ResponseApi.<Event>builder()
                .timestamp(Instant.now())
                .message("Retrieved event by id successfully.")
                .status(HttpStatus.OK)
                .payload((Event) eventService.getEventById(eventId))
                .build();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a new event")
    @PostMapping
    public ResponseEntity<?> postNewEvent(@Valid @RequestBody EventRequest request) {
        ResponseApi<Event> response = ResponseApi.<Event>builder()
                .timestamp(Instant.now())
                .message("Event created successfully.")
                .status(HttpStatus.CREATED)
                .payload((Event) eventService.postNewEvent(request))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Delete event by Id")
    @DeleteMapping("/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) {
        ResponseApi<Void> response = ResponseApi.<Void>builder()
                .timestamp(Instant.now())
                .message("Event deleted successfully.")
                .status(HttpStatus.OK)
                .payload(null)
                .build();
        eventService.deleteEventById(eventId);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update event by Id")
    @PutMapping("/{eventId}")
    public ResponseEntity<?> updateEvent(@PathVariable("eventId") Long eventId,
                                         @Valid @RequestBody EventRequest request) {
        ResponseApi<List<Event>> response = ResponseApi.<List<Event>>builder()
                .timestamp(Instant.now())
                .message("Event updated successfully.")
                .status(HttpStatus.OK)
                .payload(eventService.updateEventById(eventId,request))
                .build();
        return ResponseEntity.ok(response);
    }
}