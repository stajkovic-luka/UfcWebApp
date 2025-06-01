package org.stajkovic.ufc.cv.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.stajkovic.ufc.cv.exception.dto.ApiError;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(FighterNotFoundException.class)
    public ResponseEntity<ApiError> handleFighterNotFound(FighterNotFoundException ex){
        ApiError apiError = new ApiError(
                ex.getMessage(),
                ex.getStatusCode()

        );

        return new ResponseEntity<>(apiError,HttpStatusCode.valueOf(apiError.statusCode()));
    }
}
