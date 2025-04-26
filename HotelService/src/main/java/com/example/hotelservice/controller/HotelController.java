package com.example.hotelservice.controller;

import com.example.hotelservice.model.request.HotelCreateRequest;
import com.example.hotelservice.model.request.HotelUpdateRequest;
import com.example.hotelservice.model.response.HotelResponse;
import com.example.hotelservice.model.response.HotelRsResponse;
import com.example.hotelservice.model.response.HotelsResponse;
import com.example.hotelservice.model.response.HotelsSummaryResponse;
import com.example.hotelservice.service.HotelService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class HotelController {

    private HotelService hotelService;

    @GetMapping("/hotels")
    public HotelRsResponse<List<HotelsResponse>> findAll() {

        final List<HotelsResponse> hotelsResponses = hotelService.findAll();
        return HotelRsResponse.successOf(hotelsResponses);
    }


    @GetMapping("/hotels/summary")
    public HotelRsResponse<List<HotelsSummaryResponse>> findSummaryAll() {
        final List<HotelsSummaryResponse> hotelsSummaryResponse = hotelService.findSummaryAll();
        return HotelRsResponse.successOf(hotelsSummaryResponse);
    }


    @GetMapping("/hotel/{id}")
    public HotelRsResponse<HotelResponse> findById(@PathVariable(value = "id") @Positive Long id) {
        HotelResponse hotelResponse = hotelService.findById(id);
        return HotelRsResponse.successOf(hotelResponse);
    }


    @PostMapping("/hotel")
    public HotelRsResponse<Void> create(@RequestBody @Valid HotelCreateRequest createRequest) {
        hotelService.create(createRequest);
        return HotelRsResponse.success();
    }


    @PutMapping("/hotel/{id}")
    public HotelRsResponse<Void> update(@PathVariable(value = "id") @Positive Long id, @RequestBody @Valid HotelUpdateRequest hotelUpdateRequest) {
        hotelService.update(id, hotelUpdateRequest);
        return HotelRsResponse.success();
    }


    @DeleteMapping("/hotel/{id}")
    public HotelRsResponse<Void> delete(@PathVariable(value = "id") @Positive Long id) {
        hotelService.delete(id);
        return HotelRsResponse.success();
    }
}
