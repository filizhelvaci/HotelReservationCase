package com.example.model.mapper;


import com.example.model.entitiy.Room;
import com.example.model.response.RoomsSummaryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomToSummaryResponseMapper extends BaseMapper<Room, RoomsSummaryResponse> {

    RoomToSummaryResponseMapper INSTANCE = Mappers.getMapper(RoomToSummaryResponseMapper.class);
}
