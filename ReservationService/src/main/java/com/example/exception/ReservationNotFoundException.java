package com.example.exception;

import java.io.Serial;

public final class ReservationNotFoundException extends AbstractNotFoundException {

    @Serial
    private static final long serialVersionUID = 1458755075792352182L;

    public ReservationNotFoundException(Long id) {

        super("This Reservation not found ID = " + id);
    }
}
