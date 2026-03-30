package com.example._0_uon_sokvannrith_spring003.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendee {
    private Long attendeeId;
    private String attendeeName;
    private String email;
}
