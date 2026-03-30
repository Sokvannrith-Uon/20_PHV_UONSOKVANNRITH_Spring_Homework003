package com.example._0_uon_sokvannrith_spring003.model.request;

import org.hibernate.validator.constraints.NotBlank;

public class AttendeeRequest {
    @NotBlank(message = "Attendee name cannot be blank")
    private String attendeeName;
    @NotBlank(message = "Email cannot be blank")
    private String email;
}
