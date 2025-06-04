package org.stajkovic.ufc.cv.exception;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.stajkovic.ufc.cv.exception.dto.ApiError;

@Log
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(FighterNotFoundException.class)
    public ResponseEntity<ApiError> handleFighterNotFound(FighterNotFoundException ex){
        log.warning("FighterNotFoundException je bacen! \n" + ex);
        ApiError apiError = new ApiError(
                ex.getMessage(),
                ex.getStatusCode()

        );

        return new ResponseEntity<>(apiError,HttpStatusCode.valueOf(apiError.statusCode()));
    }
}
