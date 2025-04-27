package com.example.model.mapper;

import com.example.model.entitiy.Hotel;
import com.example.model.response.HotelsSummaryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelToSummaryResponseMapper extends BaseMapper<Hotel, HotelsSummaryResponse> {

    HotelToSummaryResponseMapper INSTANCE = Mappers.getMapper(HotelToSummaryResponseMapper.class);

}
