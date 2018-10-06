package com.stackroute.movieservice.exception;

public class MovieAlreadyExistsException extends Exception {
    String message;

    public MovieAlreadyExistsException() {
    }

    public MovieAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
