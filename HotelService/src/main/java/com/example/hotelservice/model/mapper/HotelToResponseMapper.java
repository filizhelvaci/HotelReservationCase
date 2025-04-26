package com.example.hotelservice.model.mapper;

import com.example.hotelservice.model.entitiy.Hotel;
import com.example.hotelservice.model.response.HotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelToResponseMapper extends BaseMapper<Hotel, HotelResponse>{

    HotelToResponseMapper INSTANCE = Mappers.getMapper(HotelToResponseMapper.class);

}
