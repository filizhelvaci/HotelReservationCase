package com.example.model.mapper;

import com.example.model.entitiy.Hotel;
import com.example.model.request.HotelCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelCreateRequestToEntityMapper extends BaseMapper<HotelCreateRequest, Hotel>{

    HotelCreateRequestToEntityMapper INSTANCE = Mappers.getMapper(HotelCreateRequestToEntityMapper.class);

}
