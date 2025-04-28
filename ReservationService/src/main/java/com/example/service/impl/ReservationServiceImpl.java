package com.example.service.impl;

import com.example.exception.ReservationNotFoundException;
import com.example.model.entity.Reservation;
import com.example.model.mapper.ReservationToResponseMapper;
import com.example.model.request.ReservationCreateRequest;
import com.example.model.request.ReservationUpdateRequest;
import com.example.model.response.ReservationResponse;
import com.example.repository.ReservationRepository;
import com.example.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationToResponseMapper reservationToResponseMapper;

    @Override
    public ReservationResponse findById(Long id){

        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
        return reservationToResponseMapper.map(reservation);
    }

    @Override
    public void create(ReservationCreateRequest reservationCreateRequest){


        reservationRepository.save(new Reservation(reservationCreateRequest));
    }

    @Override
    public void update(Long id, ReservationUpdateRequest reservationUpdateRequest){}

    @Override
    public void delete(Long id){}

}
