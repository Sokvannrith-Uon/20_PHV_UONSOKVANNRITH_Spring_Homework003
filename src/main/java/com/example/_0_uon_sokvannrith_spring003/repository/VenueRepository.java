package com.example._0_uon_sokvannrith_spring003.repository;

import com.example._0_uon_sokvannrith_spring003.model.entity.Venue;
import com.example._0_uon_sokvannrith_spring003.model.request.VenueRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VenueRepository {
    List<Venue> getAllVenues(int offset, int size);

    List<Venue> getAllVenuesById(Long venueId);

    List<Venue> deleteVenueById(Long venueId);

    List<Venue> updateVenueById(Long venueId, VenueRequest request);
}
