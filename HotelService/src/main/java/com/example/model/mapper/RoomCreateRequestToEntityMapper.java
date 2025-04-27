package com.example.model.mapper;


import com.example.model.entitiy.Room;
import com.example.model.request.RoomCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomCreateRequestToEntityMapper extends BaseMapper<RoomCreateRequest, Room> {

    RoomCreateRequestToEntityMapper INSTANCE = Mappers.getMapper(RoomCreateRequestToEntityMapper.class);

}
