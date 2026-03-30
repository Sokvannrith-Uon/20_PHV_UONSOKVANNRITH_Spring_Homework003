package com.example._0_uon_sokvannrith_spring003.repository;

import com.example._0_uon_sokvannrith_spring003.model.entity.Venue;
import com.example._0_uon_sokvannrith_spring003.model.request.VenueRequest;
import org.apache.ibatis.annotations.*;

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

    @ResultMap("eventMapper")
    @Delete("""
            DELETE FROM venues WHERE venue_id = #{venueId}
            RETURNING *
            """)
    List<Venue> getAllVenuesById(Long venueId);
    @ResultMap("venueMapper")
    @Select("""
            SELECT * FROM venues WHERE venue_id = #{venueId}
            """)
    List<Venue> deleteVenueById(Long venueId);
    @ResultMap("venueMapper")
    @Select("""
            UPDATE venues
            SET venue_name = #{req.venueName},
                location = #{req.location}
            WHERE venue_id = #{venueId}
            RETURNING *
            """)
    List<Venue> updateVenueById(Long venueId, VenueRequest request);
}
