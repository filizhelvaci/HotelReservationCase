package com.example.hotelservice.service.impl;

import com.example.hotelservice.exception.HotelAlreadyExistsException;
import com.example.hotelservice.exception.HotelNotFoundException;
import com.example.hotelservice.model.entitiy.Hotel;
import com.example.hotelservice.model.entitiy.Room;
import com.example.hotelservice.model.mapper.HotelCreateRequestToEntityMapper;
import com.example.hotelservice.model.mapper.HotelToHotelsResponseMapper;
import com.example.hotelservice.model.mapper.HotelToResponseMapper;
import com.example.hotelservice.model.mapper.HotelToSummaryResponseMapper;
import com.example.hotelservice.model.request.HotelCreateRequest;
import com.example.hotelservice.model.request.HotelUpdateRequest;
import com.example.hotelservice.model.response.HotelResponse;
import com.example.hotelservice.model.response.HotelsResponse;
import com.example.hotelservice.model.response.HotelsSummaryResponse;
import com.example.hotelservice.repository.HotelRepository;
import com.example.hotelservice.repository.RoomRepository;
import com.example.hotelservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
