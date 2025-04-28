package com.example.repository;

import com.example.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByRoomIdAndCheckInDateBeforeAndCheckOutDateAfter(Long roomId, LocalDate end, LocalDate start);
}