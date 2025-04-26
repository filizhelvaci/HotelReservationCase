package com.example.hotelservice.service;

import com.example.hotelservice.model.request.HotelCreateRequest;
import com.example.hotelservice.model.request.HotelUpdateRequest;
import com.example.hotelservice.model.response.HotelResponse;
import com.example.hotelservice.model.response.HotelsResponse;
import com.example.hotelservice.model.response.HotelsSummaryResponse;

import java.util.List;

public interface HotelService {

    List<HotelsResponse> findAll();

    List<HotelsSummaryResponse> findSummaryAll();

    HotelResponse findById(Long id);

    void create(HotelCreateRequest hotelCreateRequest);

    void update(Long id, HotelUpdateRequest hotelUpdateRequest);

    void delete(Long id);
}
