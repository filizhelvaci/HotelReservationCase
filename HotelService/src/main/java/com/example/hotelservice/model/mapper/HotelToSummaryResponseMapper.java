package com.example.hotelservice.model.mapper;

import com.example.hotelservice.model.entitiy.Hotel;
import com.example.hotelservice.model.response.HotelsSummaryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelToSummaryResponseMapper extends BaseMapper<Hotel, HotelsSummaryResponse> {

    HotelToSummaryResponseMapper INSTANCE = Mappers.getMapper(HotelToSummaryResponseMapper.class);

}
