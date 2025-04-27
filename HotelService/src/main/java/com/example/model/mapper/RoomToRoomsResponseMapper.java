package com.example.model.mapper;

import com.example.model.entitiy.Room;
import com.example.model.response.RoomsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomToRoomsResponseMapper extends BaseMapper<Room, RoomsResponse> {

    RoomToRoomsResponseMapper INSTANCE = Mappers.getMapper(RoomToRoomsResponseMapper.class);
}
