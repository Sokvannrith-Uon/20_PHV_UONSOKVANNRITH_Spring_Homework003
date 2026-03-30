package com.example._0_uon_sokvannrith_spring003.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Long eventId;
    private String eventName;
    private String eventDate;
    private Venue venue;
}
