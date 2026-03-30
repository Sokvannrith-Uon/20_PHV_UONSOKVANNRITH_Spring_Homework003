package com.example._0_uon_sokvannrith_spring003.repository;

import com.example._0_uon_sokvannrith_spring003.model.entity.Attendee;
import com.example._0_uon_sokvannrith_spring003.model.request.AttendeeRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeeRepository {
    @Results(id = "attendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name")
    })
    @Select("""
select * from attendees OFFSET #{offset} LIMIT #{size} ;
""")
     List<Attendee> getAllAttendees(int offset, int size) ;
    @ResultMap("attendeeMapper")
    @Select("""
            SELECT * FROM attendees WHERE attendee_id = #{attendeeId}
            """)
    List<Attendee> getAttendeeById(Long attendeeId);
    @ResultMap("attendeeMapper")
    @Select("""
            DELETE FROM attendees
            WHERE attendee_id = #{attendeeId}
            RETURNING *
            """)
    List<Attendee> deleteAttendeeById(@Param("attendeeId") Long attendeeId);
    @ResultMap("attendeeMapper")
    @Select("""
            UPDATE attendees
            SET attendee_name = #{req.attendeeName},
                email = #{req.email}
            WHERE attendee_id = #{attendeeId}
            RETURNING *
            """)
    List<Attendee> updateAttendeeById(@Param("attendeeId") Long attendeeId, @Param("req") AttendeeRequest request);

    List<Attendee> postNewAttendee(AttendeeRequest request);
}
