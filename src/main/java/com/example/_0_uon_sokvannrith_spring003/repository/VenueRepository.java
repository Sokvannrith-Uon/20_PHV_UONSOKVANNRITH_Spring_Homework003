package com.example._0_uon_sokvannrith_spring003.repository;

import com.example._0_uon_sokvannrith_spring003.model.entity.Venue;
import com.example._0_uon_sokvannrith_spring003.model.request.VenueRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VenueRepository {
    @Results(id = "venueMapper", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name"),
            @Result(property = "location", column = "location")
    })
    @Select("""
            SELECT * FROM venues OFFSET #{offset} LIMIT #{size}
            """)
    List<Venue> getAllVenues(int offset, int size);
    List<Venue> getAllVenuesById(Long venueId);
    List<Venue> deleteVenueById(Long venueId);
    List<Venue> updateVenueById(Long venueId, VenueRequest request);
}
