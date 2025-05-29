package com.example.repository;

import com.example.model.entity.Reservation;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT r FROM Reservation r WHERE r.roomId = :roomId AND r.checkOutDate > :checkInDate AND r.checkInDate < :checkOutDate")
    List<Reservation> findConflictingReservations(@Param("roomId") Long roomId,
                                                  @Param("checkInDate") LocalDate checkInDate,
                                                  @Param("checkOutDate") LocalDate checkOutDate);

}