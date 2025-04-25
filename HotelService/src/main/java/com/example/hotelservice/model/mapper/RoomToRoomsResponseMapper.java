package com.example.hotelservice.model.mapper;

import com.example.hotelservice.model.entitiy.Room;
import com.example.hotelservice.model.response.RoomsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomToRoomsResponseMapper extends BaseMapper<Room, RoomsResponse> {

    RoomToRoomsResponseMapper INSTANCE = Mappers.getMapper(RoomToRoomsResponseMapper.class);
}
