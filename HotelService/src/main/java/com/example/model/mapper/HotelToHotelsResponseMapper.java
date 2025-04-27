package com.example.model.mapper;

import com.example.model.entitiy.Hotel;
import com.example.model.response.HotelsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelToHotelsResponseMapper extends BaseMapper<Hotel, HotelsResponse>{

    HotelToHotelsResponseMapper INSTANCE = Mappers.getMapper(HotelToHotelsResponseMapper.class);

}
