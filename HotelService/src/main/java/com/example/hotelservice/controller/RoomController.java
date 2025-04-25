package com.example.hotelservice.controller;


import com.example.hotelservice.model.request.RoomCreateRequest;
import com.example.hotelservice.model.request.RoomUpdateRequest;
import com.example.hotelservice.model.response.HotelRsResponse;
import com.example.hotelservice.model.response.RoomResponse;
import com.example.hotelservice.model.response.RoomsResponse;
import com.example.hotelservice.model.response.RoomsSummaryResponse;
import com.example.hotelservice.service.RoomService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class RoomController {

    private final RoomService roomService;


    @GetMapping("/rooms")
    public HotelRsResponse<List<RoomsResponse>> findAll() {

        final List<RoomsResponse> roomsResponses = roomService.findAll();
        return HotelRsResponse.successOf(roomsResponses);
    }


    @GetMapping("/rooms/summary")
    public HotelRsResponse<List<RoomsSummaryResponse>> findSummaryAll() {
        final List<RoomsSummaryResponse> roomsSummaryResponse = roomService.findSummaryAll();
        return HotelRsResponse.successOf(roomsSummaryResponse);
    }


    @GetMapping("/room/{id}")
    public HotelRsResponse<RoomResponse> findById(@PathVariable(value = "id") @Positive Long id) {
        RoomResponse roomResponse = roomService.findById(id);
        return HotelRsResponse.successOf(roomResponse);
    }


    @PostMapping("/room")
    public HotelRsResponse<Void> create(@RequestBody @Valid RoomCreateRequest createRequest) {
        roomService.create(createRequest);
        return HotelRsResponse.success();
    }


    @PutMapping("/room/{id}")
    public HotelRsResponse<Void> update(@PathVariable(value = "id") @Positive Long id, @RequestBody @Valid RoomUpdateRequest roomUpdateRequest) {
        roomService.update(id, roomUpdateRequest);
        return HotelRsResponse.success();
    }


    @DeleteMapping("/room/{id}")
    public HotelRsResponse<Void> delete(@PathVariable(value = "id") @Positive Long id) {
        roomService.delete(id);
        return HotelRsResponse.success();
    }
}
