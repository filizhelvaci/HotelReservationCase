package com.example.hotelservice.exception;

import java.io.Serial;

public final class HotelNotFoundException extends AbstractNotFoundException {

    @Serial
    private static final long serialVersionUID = 1458755075792352182L;

    public HotelNotFoundException(Long id) {

        super("This Hotel not found ID = " + id);
    }
}
