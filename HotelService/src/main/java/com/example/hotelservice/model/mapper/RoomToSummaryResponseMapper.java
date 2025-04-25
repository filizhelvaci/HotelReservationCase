package com.example.hotelservice.model.mapper;


import com.example.hotelservice.model.entitiy.Room;
import com.example.hotelservice.model.response.RoomsSummaryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomToSummaryResponseMapper extends BaseMapper<Room, RoomsSummaryResponse> {

    RoomToSummaryResponseMapper INSTANCE = Mappers.getMapper(RoomToSummaryResponseMapper.class);
}
