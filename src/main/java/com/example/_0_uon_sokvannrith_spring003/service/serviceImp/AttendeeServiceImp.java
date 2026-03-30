package com.example._0_uon_sokvannrith_spring003.service.serviceImp;

import com.example._0_uon_sokvannrith_spring003.model.entity.Attendee;
import com.example._0_uon_sokvannrith_spring003.model.request.AttendeeRequest;
import com.example._0_uon_sokvannrith_spring003.repository.AttendeeRepository;
import com.example._0_uon_sokvannrith_spring003.service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class AttendeeServiceImp implements AttendeeService {
public final AttendeeRepository attendeeRepository;
    @Override
    public List<Attendee> getAllAttendees(int page, int size) {
        int offset = size * (page - 1);
        return attendeeRepository.getAllAttendees(offset, size);
    }

    @Override
    public List<Attendee> getAttendeeById(Long attendeeId) {
        return attendeeRepository.getAttendeeById(attendeeId);
    }

    @Override
    public List<Attendee> postNewAttendee(AttendeeRequest request) {
        return attendeeRepository.postNewAttendee(request);
    }

    @Override
    public List<Attendee> deleteAttendeeById(Long attendeeId) {
        return attendeeRepository.deleteAttendeeById(attendeeId);
    }

    @Override
    public List<Attendee> updateAttendeeById(Long attendeeId, AttendeeRequest request) {
        return attendeeRepository.updateAttendeeById(attendeeId,request);
    }
}
