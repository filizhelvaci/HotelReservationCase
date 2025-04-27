package com.example.model.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ReservationUpdateRequest {

    @NotNull
    private Long roomId;

    @NotNull
    private LocalDate checkInDate;

    @NotNull
    private LocalDate checkOutDate;
}
