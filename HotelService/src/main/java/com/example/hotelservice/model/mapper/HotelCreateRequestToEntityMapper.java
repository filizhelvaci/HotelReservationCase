package com.example.hotelservice.model.mapper;

import com.example.hotelservice.model.entitiy.Hotel;
import com.example.hotelservice.model.request.HotelCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelCreateRequestToEntityMapper extends BaseMapper<HotelCreateRequest, Hotel>{

    HotelCreateRequestToEntityMapper INSTANCE = Mappers.getMapper(HotelCreateRequestToEntityMapper.class);

}
