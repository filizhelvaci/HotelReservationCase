package com.example.model.mapper;

import com.example.model.entity.Reservation;
import com.example.model.request.ReservationCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationCreateRequestToEntityMapper extends BaseMapper<ReservationCreateRequest, Reservation> {

    ReservationCreateRequestToEntityMapper INSTANCE = Mappers.getMapper(ReservationCreateRequestToEntityMapper.class);

}
