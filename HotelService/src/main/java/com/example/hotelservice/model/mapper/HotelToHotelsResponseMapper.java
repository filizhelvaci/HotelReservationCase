package com.example.hotelservice.model.mapper;

import com.example.hotelservice.model.entitiy.Hotel;
import com.example.hotelservice.model.response.HotelsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelToHotelsResponseMapper extends BaseMapper<Hotel, HotelsResponse>{

    HotelToHotelsResponseMapper INSTANCE = Mappers.getMapper(HotelToHotelsResponseMapper.class);

}
