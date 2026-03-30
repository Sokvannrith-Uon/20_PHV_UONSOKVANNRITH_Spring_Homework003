package com.example._0_uon_sokvannrith_spring003.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class EventRequest {
    @NotBlank(message = "Event name cannot be blank")
    @Schema(example = "Hello")
    private String eventName;

    @NotBlank(message = "Event date cannot be null")
    @Schema(example = "2020-04-20", description = "Format: yyyy-MM-dd")
    private String eventDate;

    @NotNull(message = "Venue ID cannot be null")
    @Schema(example = "0123456788")
    private Long venueId;

    @NotNull(message = "Attendee IDs cannot be null")
    @Schema(example = "[0123456789]")
    private List<Long> attendeeIds;
}
