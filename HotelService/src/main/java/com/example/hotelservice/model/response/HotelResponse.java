package com.example.hotelservice.model.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class HotelResponse {

    private Long id;
    private String name;
    private String address;
    private int starRating;
    private List<Room> room;

    @Getter
    @Builder
    public static class Room {
        private String roomId;
        private String roomNumber;
    }
}
