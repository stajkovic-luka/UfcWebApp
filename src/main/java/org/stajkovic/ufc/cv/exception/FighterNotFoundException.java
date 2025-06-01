package org.stajkovic.ufc.cv.exception;

import lombok.Getter;

@Getter
public class FighterNotFoundException extends RuntimeException{
    int statusCode;

    public FighterNotFoundException(String message, int statusCode) {
        super(message);
        this.statusCode=statusCode;
    }
}
