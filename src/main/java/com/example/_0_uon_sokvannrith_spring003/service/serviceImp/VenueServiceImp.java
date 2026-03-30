package com.example._0_uon_sokvannrith_spring003.service.serviceImp;

import com.example._0_uon_sokvannrith_spring003.model.entity.Venue;
import com.example._0_uon_sokvannrith_spring003.model.request.VenueRequest;
import com.example._0_uon_sokvannrith_spring003.repository.VenueRepository;
import com.example._0_uon_sokvannrith_spring003.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenueServiceImp implements VenueService {
    public final VenueRepository venueRepository;

    @Override
    public List<Venue> getAllVenues(int page, int size) {
        int offset = size * (page - 1);
        return venueRepository.getAllVenues(offset,size);
    }

    @Override
    public List<Venue> getAllVenuesById(Long venueId) {
        return venueRepository.getAllVenuesById(venueId);
    }

    @Override
    public List<Venue> createNewVenue(VenueRequest request) {
        return List.of();
    }

    @Override
    public List<Venue> deleteVenueById(Long venueId) {
        return venueRepository.deleteVenueById(venueId);
    }

    @Override
    public List<Venue> updateVenueById(Long venueId, VenueRequest request) {
        return venueRepository.updateVenueById(venueId,request);
    }
}
