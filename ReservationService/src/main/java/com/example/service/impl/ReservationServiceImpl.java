package com.example.service.impl;

import com.example.exception.ReservationAlreadyExistsException;
import com.example.exception.ReservationNotFoundException;
import com.example.model.entity.Reservation;
import com.example.model.mapper.ReservationCreateRequestToEntityMapper;
import com.example.model.mapper.ReservationToResponseMapper;
import com.example.model.mapper.ReservationToResponsesMapper;
import com.example.model.mapper.ReservationUpdateRequestToEntityMapper;
import com.example.model.request.ReservationCreateRequest;
import com.example.model.request.ReservationUpdateRequest;
import com.example.model.response.ReservationResponse;
import com.example.model.response.ReservationsResponse;
import com.example.repository.ReservationRepository;
import com.example.service.ReservationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final ReservationToResponseMapper reservationToResponseMapper = ReservationToResponseMapper.INSTANCE;
    private final ReservationCreateRequestToEntityMapper reservationCreateRequestToEntityMapper = ReservationCreateRequestToEntityMapper.INSTANCE;
    private final ReservationUpdateRequestToEntityMapper reservationUpdateRequestToEntityMapper = ReservationUpdateRequestToEntityMapper.INSTANCE;
    private final ReservationToResponsesMapper reservationToResponsesMapper = ReservationToResponsesMapper.INSTANCE;

    @Override
    public ReservationResponse findById(Long id) {

        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
        return reservationToResponseMapper.map(reservation);
    }

    @Override
    public List<ReservationsResponse> findAll() {

        List<Reservation> reservations = reservationRepository.findAll();
        return reservationToResponsesMapper.map(reservations);
    }

    @Override
    public void create(ReservationCreateRequest reservationCreateRequest) {

        List<Reservation> conflictingReservations = reservationRepository.findConflictingReservations(
                reservationCreateRequest.getRoomId(), reservationCreateRequest.getCheckInDate(), reservationCreateRequest.getCheckOutDate()
        );

        if (!conflictingReservations.isEmpty()) {
            throw new ReservationAlreadyExistsException(
                    reservationCreateRequest.getRoomId().toString(),
                    reservationCreateRequest.getCheckInDate(),
                    reservationCreateRequest.getCheckOutDate());
        }

        Reservation reservation = reservationCreateRequestToEntityMapper.map(reservationCreateRequest);

        reservationRepository.save(reservation);
    }

    @Override
    public void update(Long id, ReservationUpdateRequest reservationUpdateRequest) {

        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));

        List<Reservation> conflictingReservations = reservationRepository.findConflictingReservations(
                id, reservationUpdateRequest.getCheckInDate(), reservationUpdateRequest.getCheckOutDate());

        conflictingReservations.removeIf(reservations -> reservations.getId().equals(reservation.getId()));

        if (!conflictingReservations.isEmpty()) {
            throw new ReservationAlreadyExistsException(reservationUpdateRequest.getRoomId().toString(),
                    reservationUpdateRequest.getCheckInDate(),
                    reservationUpdateRequest.getCheckOutDate());
        }

        Reservation reservationUpdate = reservationUpdateRequestToEntityMapper.map(reservationUpdateRequest);
        reservationUpdate.setId(id);

        reservationRepository.save(reservationUpdate);
    }

    @Override
    public void delete(Long id) {

        if (!reservationRepository.existsById(id)) {
            throw new ReservationNotFoundException(id);
        }

        reservationRepository.deleteById(id);
    }

}
