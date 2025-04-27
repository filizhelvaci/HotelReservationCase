package com.example.repository;

import com.example.model.entitiy.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    boolean existsByName(String name);

}
