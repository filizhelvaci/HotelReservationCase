package com.example.exception;

import java.io.Serial;
import java.time.LocalDate;

public class ReservationAlreadyExistsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ReservationAlreadyExistsException(String message, LocalDate checkInDate, LocalDate checkOutDate) {

        super( checkInDate+" ve "+checkOutDate+ "tarihleri arasında "+message + " --> This room is reservated already ! ");
    }
}
