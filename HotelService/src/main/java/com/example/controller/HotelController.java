package com.example.controller;

import com.example.model.request.HotelCreateRequest;
import com.example.model.request.HotelUpdateRequest;
import com.example.model.response.HotelResponse;
import com.example.model.response.HotelRsResponse;
import com.example.model.response.HotelsResponse;
import com.example.model.response.HotelsSummaryResponse;
import com.example.service.HotelService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class HotelController {

    private final HotelService hotelService;

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
