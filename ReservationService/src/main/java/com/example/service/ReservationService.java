package com.example.service;

import com.example.model.entity.Reservation;
import com.example.model.request.ReservationCreateRequest;
import com.example.model.request.ReservationUpdateRequest;
import com.example.model.response.ReservationResponse;

import java.util.List;

public interface ReservationService {

    ReservationResponse findById(Long id);

    List<Reservation> findAll();

    void create(ReservationCreateRequest reservationCreateRequest);

    void update(Long id, ReservationUpdateRequest reservationUpdateRequest);

    void delete(Long id);

}
