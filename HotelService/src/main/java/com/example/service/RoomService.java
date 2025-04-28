package com.example.service;

import com.example.model.request.RoomCreateRequest;
import com.example.model.request.RoomUpdateRequest;
import com.example.model.response.RoomResponse;
import com.example.model.response.RoomsResponse;
import com.example.model.response.RoomsSummaryResponse;

import java.util.List;

public interface RoomService {

    List<RoomsResponse> findAll();

    List<RoomsSummaryResponse> findSummaryAll();

    RoomResponse findById(Long id);

    void create(RoomCreateRequest roomCreateRequest);

    void update(Long id, RoomUpdateRequest roomUpdateRequest);

    void delete(Long id);
}
