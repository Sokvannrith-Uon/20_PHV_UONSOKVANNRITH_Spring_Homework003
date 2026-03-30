package com.example._0_uon_sokvannrith_spring003.repository;

import com.example._0_uon_sokvannrith_spring003.model.entity.Attendee;
import com.example._0_uon_sokvannrith_spring003.model.request.AttendeeRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EvenRepository {

    @Results(id = "eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venue", column = "venue_id", one = @One(select = "org.me.homework003.repository.VenueRepository.getVenueById"))
    })
    @Select("""
            SELECT * FROM events OFFSET #{offset} LIMIT #{size}
            """)
    List<Attendee> getAllEvens(int offset, int size);
    @ResultMap("eventMapper")
    @Select("""
            SELECT * FROM events WHERE event_id = #{eventId}
            """)
    List<Attendee> getEvenById(Long attendeeId);
    @ResultMap("eventMapper")
    @Select("""
            INSERT INTO events (event_name, event_date, venue_id)
            VALUES (#{req.eventName}, #{req.eventDate}, #{req.venue.venueId})
            RETURNING *
            """)
    List<Attendee> postNewEven(AttendeeRequest request);
    @ResultMap("eventMapper")
    @Select("""
            DELETE FROM events WHERE event_id = #{eventId} RETURNING *
            """)
    List<Attendee> deleteEvenById(Long attendeeId);
    @ResultMap("eventMapper")
    @Select("""
            UPDATE events
            SET event_name = #{req.eventName},
                event_date = #{req.eventDate},
                venue_id = #{req.venue.venueId}
            WHERE event_id = #{eventId}
            RETURNING *
            """)
    List<Attendee> updateEvenById(Long attendeeId, AttendeeRequest request);
}
