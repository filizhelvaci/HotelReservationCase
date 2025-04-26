package com.example.hotelservice.service.impl;

import com.example.hotelservice.exception.HotelNotFoundException;
import com.example.hotelservice.exception.RoomAlreadyExistsException;
import com.example.hotelservice.exception.RoomNotFoundException;
import com.example.hotelservice.model.entitiy.Hotel;
import com.example.hotelservice.model.entitiy.Room;
import com.example.hotelservice.model.mapper.RoomCreateRequestToEntityMapper;
import com.example.hotelservice.model.mapper.RoomToResponseMapper;
import com.example.hotelservice.model.mapper.RoomToRoomsResponseMapper;
import com.example.hotelservice.model.mapper.RoomToSummaryResponseMapper;
import com.example.hotelservice.model.request.RoomCreateRequest;
import com.example.hotelservice.model.request.RoomUpdateRequest;
import com.example.hotelservice.model.response.RoomResponse;
import com.example.hotelservice.model.response.RoomsResponse;
import com.example.hotelservice.model.response.RoomsSummaryResponse;
import com.example.hotelservice.repository.HotelRepository;
import com.example.hotelservice.repository.RoomRepository;
import com.example.hotelservice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class RoomServiceImpl implements RoomService {

    private final RoomToResponseMapper roomEntityToResponseMapper = RoomToResponseMapper.INSTANCE;
    private final RoomToSummaryResponseMapper roomToSummaryResponseMapper = RoomToSummaryResponseMapper.INSTANCE;
    private final RoomCreateRequestToEntityMapper roomCreateRequestToEntityMapper = RoomCreateRequestToEntityMapper.INSTANCE;
    private final RoomToRoomsResponseMapper roomToRoomsResponseMapper = RoomToRoomsResponseMapper.INSTANCE;

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Override
    public List<RoomsSummaryResponse> findSummaryAll() {

        List<Room> rooms = roomRepository.findAll();
        return roomToSummaryResponseMapper.map(rooms);
    }


    @Override
    public RoomResponse findById(Long id) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
        return roomEntityToResponseMapper.map(room);
    }


    @Override
    public List<RoomsResponse> findAll() {

        List<Room> rooms = roomRepository.findAll();
        return roomToRoomsResponseMapper.map(rooms);
    }


    @Override
    public void create(RoomCreateRequest roomCreateRequest) {

        boolean existsByNumber = roomRepository.existsByRoomNumber(roomCreateRequest.getRoomNumber());
        if (existsByNumber) {
            throw new RoomAlreadyExistsException(roomCreateRequest.getRoomNumber());
        }
        Room room = roomCreateRequestToEntityMapper.map(roomCreateRequest);

        Long hotelId = roomCreateRequest.getHotelId();
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException(hotelId));
        room.setHotel(hotel);
        roomRepository.save(room);
    }


    @Override
    public void update(Long id, RoomUpdateRequest roomUpdateRequest) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));

        Long hotelId = roomUpdateRequest.getHotelId();
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException(hotelId));
        room.setHotel(hotel);

        room.update(
                roomUpdateRequest.getRoomNumber(),
                roomUpdateRequest.getCapacity(),
                roomUpdateRequest.getPricePerNight()
        );

        roomRepository.save(room);
    }


    @Override
    public void delete(Long id) throws RoomNotFoundException {

        boolean exists = roomRepository.existsById(id);
        if (!exists) {
            throw new RoomNotFoundException(id);
        }
        roomRepository.deleteById(id);
    }
}
