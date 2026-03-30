package com.example._0_uon_sokvannrith_spring003.repository;

import com.example._0_uon_sokvannrith_spring003.model.entity.Event;
import com.example._0_uon_sokvannrith_spring003.model.request.EventRequest;
import jakarta.validation.Valid;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EvenRepository {

    @Results(id = "eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venue", column = "venue_id",
                    one = @One(select = "com.example._0_uon_sokvannrith_spring003.repository.VenueRepository.getVenueById"))
    })
    @Select("""
            SELECT * FROM events OFFSET #{offset} LIMIT #{size}
            """)
    List<Event> getAllEvents(int offset, int size);

    @ResultMap("eventMapper")
    @Select("""
            SELECT * FROM events WHERE event_id = #{eventId}
            """)
    List<Event> getEventById(Long eventId);

    @ResultMap("eventMapper")
    @Insert("""
            INSERT INTO events (event_name, event_date, venue_id)
            VALUES (#{eventName}, #{eventDate}, #{venue.venueId})
            RETURNING *
            """)
    List<Event> postNewEvent(@Valid EventRequest request);

    @ResultMap("eventMapper")
    @Delete("""
            DELETE FROM events WHERE event_id = #{eventId}
            RETURNING *
            """)
    List<Event> deleteEventById(Long eventId);

    @ResultMap("eventMapper")
    @Update("""
            UPDATE events
            SET event_name = #{request.eventName},
                event_date = #{request.eventDate},
                venue_id = #{request.venue.venueId}
            WHERE event_id = #{eventId}
            RETURNING *
            """)
    List<Event> updateEventById(@Param("eventId") Long eventId,
                                @Param("request") EventRequest request);
}
