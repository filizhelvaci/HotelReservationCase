package com.example.hotelservice.model.mapper;


import com.example.hotelservice.model.entitiy.Room;
import com.example.hotelservice.model.request.RoomCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomCreateRequestToEntityMapper extends BaseMapper<RoomCreateRequest, Room> {

    RoomCreateRequestToEntityMapper INSTANCE = Mappers.getMapper(RoomCreateRequestToEntityMapper.class);

}
