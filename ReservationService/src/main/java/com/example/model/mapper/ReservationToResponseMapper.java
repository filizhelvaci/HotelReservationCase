package com.example.model.mapper;


import com.example.model.entity.Reservation;
import com.example.model.response.ReservationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationToResponseMapper extends BaseMapper<Reservation, ReservationResponse> {

    ReservationToResponseMapper INSTANCE = Mappers.getMapper(ReservationToResponseMapper.class);

}
