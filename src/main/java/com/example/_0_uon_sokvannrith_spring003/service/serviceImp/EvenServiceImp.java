package com.example._0_uon_sokvannrith_spring003.service.serviceImp;

import com.example._0_uon_sokvannrith_spring003.model.entity.Attendee;
import com.example._0_uon_sokvannrith_spring003.model.request.AttendeeRequest;
import com.example._0_uon_sokvannrith_spring003.repository.EvenRepository;
import com.example._0_uon_sokvannrith_spring003.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvenServiceImp implements EventService {
    public final EvenRepository evenRepository;

    @Override
    public List<Attendee> getAllEvens(int page, int size) {
        int offset = size * (page - 1);
        return evenRepository.getAllEvens(offset, size);
    }

    @Override
    public List<Attendee> getEvenById(Long attendeeId) {
        return evenRepository.getEvenById(attendeeId);
    }

    @Override
    public List<Attendee> postNewEven(AttendeeRequest request) {
        return evenRepository.postNewEven(request);
    }

    @Override
    public List<Attendee> deleteEvenById(Long attendeeId) {
        return evenRepository.deleteEvenById(attendeeId);
    }

    @Override
    public List<Attendee> updateEvenById(Long attendeeId, AttendeeRequest request) {
        return evenRepository.updateEvenById(attendeeId, request);
    }
}