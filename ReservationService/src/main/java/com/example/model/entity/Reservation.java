package com.example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "hotel_id")
        private Long hotelId;

        @Column(name = "room_id")
        private Long roomId;

        @Column(name = "guest_name")
        private String guestName;

        @Column(name = "check_in_date")
        private LocalDate checkInDate;

        @Column(name = "check_out_date")
        private LocalDate checkOutDate;

        @Column(name = "created_at")
        private LocalDateTime createdAt;

}
