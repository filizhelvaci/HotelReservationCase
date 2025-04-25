package com.example.hotelservice.repository;

import com.example.hotelservice.model.entitiy.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    boolean existsByNumber(String roomNumber);
}
