package com.example._0_uon_sokvannrith_spring003.service;

import com.example._0_uon_sokvannrith_spring003.model.entity.Attendee;
import com.example._0_uon_sokvannrith_spring003.model.entity.Event;
import com.example._0_uon_sokvannrith_spring003.model.request.EventRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents(int page, int size);

    List<Event> getEventById(Long eventId);

    List<Event> postNewEvent(@Valid EventRequest request);

    List<Event> deleteEventById(Long eventId);

    List<Event> updateEventById(Long eventId, @Valid EventRequest request);
}
