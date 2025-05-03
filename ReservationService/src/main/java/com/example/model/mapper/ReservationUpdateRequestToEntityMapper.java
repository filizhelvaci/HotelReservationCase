package com.example.model.mapper;

import com.example.model.entity.Reservation;
import com.example.model.request.ReservationUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationUpdateRequestToEntityMapper extends BaseMapper<ReservationUpdateRequest, Reservation> {

    ReservationUpdateRequestToEntityMapper INSTANCE = Mappers.getMapper(ReservationUpdateRequestToEntityMapper.class);
}
