package com.example.model.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="room_number")
    private String roomNumber;

    @Column(name="capacity")
    private Integer capacity;

    @Column(name="price_per_night")
    private BigDecimal pricePerNight;

    @Column(name="create_at")
    private LocalDateTime createdAt;

    @Column(name="update_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public void update(String roomNumber, Integer capacity, BigDecimal pricePerNight) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.pricePerNight= pricePerNight;
    }

}
