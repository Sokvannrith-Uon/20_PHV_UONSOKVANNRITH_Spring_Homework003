package com.example._0_uon_sokvannrith_spring003.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseApi<T>{
    private Instant timestamp;
    private String message;
    private HttpStatus status;
    private T payload;
}
