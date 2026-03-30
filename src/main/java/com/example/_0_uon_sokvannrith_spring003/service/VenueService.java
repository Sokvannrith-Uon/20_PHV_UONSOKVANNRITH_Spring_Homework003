package com.example._0_uon_sokvannrith_spring003.service;

import com.example._0_uon_sokvannrith_spring003.model.entity.Venue;
import com.example._0_uon_sokvannrith_spring003.model.request.VenueRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface VenueService {
    List<Venue> getAllVenues(int page, int size);

    List<Venue> getAllVenuesById(Long venueId);

    List<Venue> createNewVenue(@Valid VenueRequest request);

    List<Venue> deleteVenueById(Long venueId);

    List<Venue> updateVenueById(Long venueId, @Valid VenueRequest request);
}
