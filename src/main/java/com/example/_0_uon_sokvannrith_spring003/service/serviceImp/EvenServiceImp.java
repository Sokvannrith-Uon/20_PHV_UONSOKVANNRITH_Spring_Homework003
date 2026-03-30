package com.example._0_uon_sokvannrith_spring003.service.serviceImp;

import com.example._0_uon_sokvannrith_spring003.model.entity.Attendee;
import com.example._0_uon_sokvannrith_spring003.model.entity.Event;
import com.example._0_uon_sokvannrith_spring003.model.request.EventRequest;
import com.example._0_uon_sokvannrith_spring003.repository.EvenRepository;
import com.example._0_uon_sokvannrith_spring003.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvenServiceImp implements EventService {
    public final EvenRepository evenRepository;

    @Override
    public List<Event> getAllEvents(int page, int size) {
        int offset = size * (page - 1);
        return evenRepository.getAllEvents(offset, size);
    }

    @Override
    public List<Event> getEventById(Long eventId) {
        return evenRepository.getEventById(eventId);
    }

    @Override
    public List<Event> postNewEvent(@Valid EventRequest request) {
        return evenRepository.postNewEvent(request);
    }

    @Override
    public List<Event> deleteEventById(Long eventId) {
        return evenRepository.deleteEventById(eventId);
    }

    @Override
    public List<Event> updateEventById(Long eventId, @Valid EventRequest request) {
        return evenRepository.updateEventById(eventId, request);
    }
}