package com.example.controller;

import com.example.model.request.ReservationCreateRequest;
import com.example.model.request.ReservationUpdateRequest;
import com.example.model.response.HotelRsResponse;
import com.example.model.response.ReservationResponse;
import com.example.model.response.ReservationsResponse;
import com.example.service.ReservationService;
import jakarta.validation.Valid;
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
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/reservation/{id}")
    public HotelRsResponse<ReservationResponse> findById(@PathVariable Long id) {
        ReservationResponse reservation = reservationService.findById(id);
        return HotelRsResponse.successOf(reservation);
    }

    @GetMapping("/reservations")
    public HotelRsResponse<List<ReservationsResponse>> findAll() {
        List<ReservationsResponse> reservations = reservationService.findAll();
        return HotelRsResponse.successOf(reservations);
    }

    @PostMapping("/reservation")
    public HotelRsResponse<Void> create(@RequestBody @Valid ReservationCreateRequest request) {
        reservationService.create(request);
        return HotelRsResponse.success();
    }

    @PutMapping("/reservation/{id}")
    public HotelRsResponse<Void> update(@PathVariable Long id, @RequestBody @Valid ReservationUpdateRequest request) {
        reservationService.update(id, request);
        return HotelRsResponse.success();
    }

    @DeleteMapping("/reservation/{id}")
    public HotelRsResponse<Void> delete(@PathVariable Long id) {
        reservationService.delete(id);
        return HotelRsResponse.success();
    }
}
