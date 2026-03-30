package com.example._0_uon_sokvannrith_spring003.service;

import com.example._0_uon_sokvannrith_spring003.model.entity.Attendee;
import com.example._0_uon_sokvannrith_spring003.model.request.AttendeeRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface AttendeeService {
    List<Attendee> getAllAttendees(int page, int size);

    List<Attendee> getAttendeeById(Long attendeeId);

    List<Attendee> postNewAttendee(@Valid AttendeeRequest request);

    List<Attendee> deleteAttendeeById(Long attendeeId);

    List<Attendee> updateAttendeeById(Long attendeeId, @Valid AttendeeRequest request);
}
