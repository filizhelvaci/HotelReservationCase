package com.example.service.impl;

import com.example.exception.HotelAlreadyExistsException;
import com.example.exception.HotelNotFoundException;
import com.example.model.entitiy.Hotel;
import com.example.model.entitiy.Room;
import com.example.model.mapper.HotelCreateRequestToEntityMapper;
import com.example.model.mapper.HotelToHotelsResponseMapper;
import com.example.model.mapper.HotelToResponseMapper;
import com.example.model.mapper.HotelToSummaryResponseMapper;
import com.example.model.request.HotelCreateRequest;
import com.example.model.request.HotelUpdateRequest;
import com.example.model.response.HotelResponse;
import com.example.model.response.HotelsResponse;
import com.example.model.response.HotelsSummaryResponse;
import com.example.repository.HotelRepository;
import com.example.repository.RoomRepository;
import com.example.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
class HotelServiceImpl implements HotelService {

    private final HotelToResponseMapper hotelToResponseMapper = HotelToResponseMapper.INSTANCE;
    private final HotelToSummaryResponseMapper hotelToSummaryResponseMapper = HotelToSummaryResponseMapper.INSTANCE;
    private final HotelCreateRequestToEntityMapper hotelCreateRequestToEntityMapper = HotelCreateRequestToEntityMapper.INSTANCE;
    private final HotelToHotelsResponseMapper hotelToHotelsResponseMapper = HotelToHotelsResponseMapper.INSTANCE;

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    @Override
    public List<HotelsSummaryResponse> findSummaryAll() {

        List<Hotel> hotels = hotelRepository.findAll();
        return hotelToSummaryResponseMapper.map(hotels);
    }


    @Override
    public HotelResponse findById(Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));
        return hotelToResponseMapper.map(hotel);
    }


    @Override
    public List<HotelsResponse> findAll() {

        List<Hotel> hotels = hotelRepository.findAll();
        return hotelToHotelsResponseMapper.map(hotels);
    }


    @Override
    public void create(HotelCreateRequest hotelCreateRequest) {

        boolean existsByName = hotelRepository.existsByName(hotelCreateRequest.getName());
        if (existsByName) {
            throw new HotelAlreadyExistsException(hotelCreateRequest.getName());
        }
        Hotel hotel = hotelCreateRequestToEntityMapper.map(hotelCreateRequest);

        List<Room> rooms = roomRepository.findAllById(hotelCreateRequest.getRoomIds());
        hotel.setRooms(rooms);
        hotel.setCreatedAt(LocalDateTime.now());

        hotelRepository.save(hotel);
    }


    @Override
    public void update(Long id, HotelUpdateRequest hotelUpdateRequest) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));

        List<Room> rooms = roomRepository.findAllById(hotelUpdateRequest.getRoomIds());
        hotel.setRooms(rooms);
        hotel.setName(hotelUpdateRequest.getName());
        hotel.setAddress(hotelUpdateRequest.getAddress());
        hotel.setStarRating(hotelUpdateRequest.getStarRating());
        hotel.setUpdatedAt(LocalDateTime.now());

        hotelRepository.save(hotel);
    }


    @Override
    public void delete(Long id) throws HotelNotFoundException {

        boolean exists = hotelRepository.existsById(id);
        if (!exists) {
            throw new HotelNotFoundException(id);
        }
        hotelRepository.deleteById(id);
    }

}
