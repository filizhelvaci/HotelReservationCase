package com.example.service;

import com.example.model.request.HotelCreateRequest;
import com.example.model.request.HotelUpdateRequest;
import com.example.model.response.HotelResponse;
import com.example.model.response.HotelsResponse;
import com.example.model.response.HotelsSummaryResponse;

import java.util.List;

public interface HotelService {

    List<HotelsResponse> findAll();

    List<HotelsSummaryResponse> findSummaryAll();

    HotelResponse findById(Long id);

    void create(HotelCreateRequest hotelCreateRequest);

    void update(Long id, HotelUpdateRequest hotelUpdateRequest);

    void delete(Long id);
}
