package com.example.model.mapper;


import com.example.model.entitiy.Room;
import com.example.model.response.RoomResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomToResponseMapper extends BaseMapper<Room, RoomResponse> {

    RoomToResponseMapper INSTANCE = Mappers.getMapper(RoomToResponseMapper.class);
}
