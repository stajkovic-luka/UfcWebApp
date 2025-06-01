package org.stajkovic.ufc.cv.exception;

public class FighterNotFoundException extends RuntimeException{
    int statusCode;
    String message;

    public FighterNotFoundException(String message, int statusCode) {
        super(message);
        this.statusCode=statusCode;
    }
}
