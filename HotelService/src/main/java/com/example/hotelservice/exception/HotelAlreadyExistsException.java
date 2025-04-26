package com.example.hotelservice.exception;

import java.io.Serial;

public class HotelAlreadyExistsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public HotelAlreadyExistsException(String message) {

        super(message + " --> this Hotel already exists ! ");
    }
}
