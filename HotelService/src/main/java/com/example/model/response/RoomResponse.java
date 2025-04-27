package com.example.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Builder
public class RoomResponse {

    private Long id;
    private String roomNumber;
    private Integer capacity;
    private BigDecimal pricePerNight;
    private Hotel hotel;

    @Getter
    @Setter
    public static class Hotel {
        private Long id;
        private String name;
    }
}
