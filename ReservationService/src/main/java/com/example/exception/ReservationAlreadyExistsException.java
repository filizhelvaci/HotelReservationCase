package com.example.exception;

import java.io.Serial;

public class ReservationAlreadyExistsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ReservationAlreadyExistsException(String message) {

        super(message + " --> This room is reservated already ! ");
    }
}
