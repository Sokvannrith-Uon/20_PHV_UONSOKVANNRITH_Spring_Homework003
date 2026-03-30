package com.example._0_uon_sokvannrith_spring003.controller;

import com.example._0_uon_sokvannrith_spring003.model.entity.Attendee;
import com.example._0_uon_sokvannrith_spring003.model.request.AttendeeRequest;
import com.example._0_uon_sokvannrith_spring003.model.response.ResponseApi;
import com.example._0_uon_sokvannrith_spring003.service.AttendeeService;
import com.example._0_uon_sokvannrith_spring003.service.serviceImp.AttendeeServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/attendees")
@RequiredArgsConstructor
public class AttendeeController {
    public final AttendeeService attendeeService;
    @Operation(summary = "Retrive all attendees")
    @GetMapping
    public ResponseEntity<?> getAllAttendees(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        ResponseApi<List<Attendee>> response = ResponseApi.<List<Attendee>>builder()
                .timestamp(Instant.now())
                .message("Retrieved attendees successfully.")
                .status(HttpStatus.OK)
                .payload(attendeeService.getAllAttendees(page, size))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{attendee-id}")
    public ResponseEntity<?> getAttendeeById(@PathVariable("attendee-id" ) Long attendeeId) {
        ResponseApi<List<Attendee>> response = ResponseApi.<List<Attendee>>builder()
                .timestamp(Instant.now())
                .message("Retrieved attendees By id successfully.")
                .status(HttpStatus.OK)
                .payload(attendeeService.getAttendeeById(attendeeId))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "Create a new attendee")
    @PostMapping
    public ResponseEntity<?> postNewAttendee(@Valid @RequestBody AttendeeRequest request) {
        ResponseApi<List<Attendee>> response = ResponseApi.<List<Attendee>>builder()
                .timestamp(Instant.now())
                .message("Post attendees successfully.")
                .status(HttpStatus.OK)
                .payload(attendeeService.postNewAttendee(request))
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Delete attendee by Id")
    @DeleteMapping("/{attendee-id}")
    public ResponseEntity<?> deleteAttendeeById(@PathVariable("attendee-id") Long attendeeId) {
        ResponseApi<List<Attendee>> response = ResponseApi.<List<Attendee>>builder()
                .timestamp(Instant.now())
                .message("Delete attendees successfully.")
                .status(HttpStatus.OK)
                .payload(attendeeService.deleteAttendeeById(attendeeId))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "Update attendee by Id")
    @PutMapping("/{attendee-id}")
    public ResponseEntity<?> updateAttendeeById(@PathVariable("attendee-id") Long attendeeId, @Valid @RequestBody AttendeeRequest request) {
        ResponseApi<List<Attendee>> response = ResponseApi.<List<Attendee>>builder()
                .timestamp(Instant.now())
                .message("updated attendees successfully.")
                .status(HttpStatus.OK)
                .payload(attendeeService.updateAttendeeById(attendeeId, request))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
