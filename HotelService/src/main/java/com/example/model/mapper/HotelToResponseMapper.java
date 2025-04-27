package com.example.model.mapper;

import com.example.model.entitiy.Hotel;
import com.example.model.response.HotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelToResponseMapper extends BaseMapper<Hotel, HotelResponse>{

    HotelToResponseMapper INSTANCE = Mappers.getMapper(HotelToResponseMapper.class);

}
