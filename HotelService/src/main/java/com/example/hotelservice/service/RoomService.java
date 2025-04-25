package com.example.hotelservice.service;

import com.example.hotelservice.model.request.RoomCreateRequest;
import com.example.hotelservice.model.request.RoomUpdateRequest;
import com.example.hotelservice.model.response.RoomResponse;
import com.example.hotelservice.model.response.RoomsResponse;
import com.example.hotelservice.model.response.RoomsSummaryResponse;

import java.util.List;

public interface RoomService {

    List<RoomsResponse> findAll();

    List<RoomsSummaryResponse> findSummaryAll();

    RoomResponse findById(Long id);

    void create(RoomCreateRequest roomCreateRequest);

    void update(Long id, RoomUpdateRequest roomUpdateRequest);

    void delete(Long id);
}
