package com.example._0_uon_sokvannrith_spring003.service;

import com.example._0_uon_sokvannrith_spring003.model.entity.Attendee;
import com.example._0_uon_sokvannrith_spring003.model.request.AttendeeRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface EventService {
    List<Attendee> getAllEvens(int page, int size);

    List<Attendee> getEvenById(Long attendeeId);

    List<Attendee> postNewEven(@Valid AttendeeRequest request);

    List<Attendee> deleteEvenById(Long attendeeId);

    List<Attendee> updateEvenById(Long attendeeId, @Valid AttendeeRequest request);
}
