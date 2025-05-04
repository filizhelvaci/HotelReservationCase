package com.example.model.mapper;

import com.example.model.entity.Reservation;
import com.example.model.response.ReservationsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationToResponsesMapper extends BaseMapper<Reservation, ReservationsResponse> {

    ReservationToResponsesMapper INSTANCE = Mappers.getMapper(ReservationToResponsesMapper.class);

}
