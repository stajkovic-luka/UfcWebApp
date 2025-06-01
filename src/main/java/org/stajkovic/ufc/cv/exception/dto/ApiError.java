package org.stajkovic.ufc.cv.exception.dto;

import java.time.LocalTime;

public record ApiError(String message,
                       int statusCode,
                       LocalTime time
) {
    public ApiError(String message, int statusCode){
        this(message,statusCode,LocalTime.now());
    }
}
