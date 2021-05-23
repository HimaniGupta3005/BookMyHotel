package com.alore.bookhotel.repositoryservice;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.alore.bookhotel.dao.Hotel;
import com.alore.bookhotel.dao.Room;
import com.alore.bookhotel.entity.HotelEntity;
import com.alore.bookhotel.entity.RoomEntity;
import com.alore.bookhotel.repository.HotelRepository;
import com.alore.bookhotel.repository.RoomRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class HotelRepositoryServiceImpl implements HotelRepositoryService {

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    @Qualifier("modelMapper")
    private ModelMapper modelMapper;

    @Override
    public HotelEntity addHotel(Hotel hotel) {

        HotelEntity hotelEntity = modelMapper.map(hotel, HotelEntity.class);
        hotelEntity = hotelRepo.save(hotelEntity);
        Room room = new Room(hotelEntity.getId(), LocalDate.now(), hotelEntity.getTotalRoom());
        RoomEntity roomEntity = modelMapper.map(room, RoomEntity.class);

        roomRepo.save(roomEntity);

        return hotelEntity;
    }

    @Override
    public void deleteHotel(int hotelId) {

        hotelRepo.deleteById(hotelId);
        List<RoomEntity> roomEntity = roomRepo.findByHotelId(hotelId);
        roomRepo.deleteAll(roomEntity);
    }

    @Override
    public HotelEntity updateHotel(Hotel hotel, int hotelId) {

        Optional<HotelEntity> optionalHotelEntity = hotelRepo.findById(hotelId);

        if (optionalHotelEntity.isPresent()) {
            HotelEntity hotelEntity = optionalHotelEntity.get();

            hotelEntity.setCity(hotel.getCity());
            hotelEntity.setName(hotel.getName());
            hotelEntity.setCostOfRoom(hotel.getCostOfRoom());
            hotelEntity.setFacility(hotel.getFacility());
            hotelEntity.setTotalRoom(hotel.getTotalRoom());

            hotelRepo.save(hotelEntity);
            return hotelEntity;
        }
        return null;

    }

    public HotelEntity searchById(int id) {

        Optional<HotelEntity> optionalHotel = hotelRepo.findById(id);

        if (optionalHotel.isPresent()) {
            return optionalHotel.get();
        }
        return null;
    }

    @Override
    public List<HotelEntity> getHotelByCity(String city) {

        Optional<List<HotelEntity>> optionalHotel = hotelRepo.findByCity(city);

        if (optionalHotel.isPresent()) {
            return optionalHotel.get();
        }
        return null;

    }

    public List<HotelEntity> getHotelByDate(LocalDate date, int roomRequired) {

        List<Integer> hotelIdListForGivenDate = roomRepo.findRoomByDate(date);
        List<Integer> hotelIdListForGivenRoom = roomRepo.findRoomByRoom(roomRequired);

        if (hotelIdListForGivenDate.size() > 0 && hotelIdListForGivenRoom.size() > 0) {
            hotelIdListForGivenDate.retainAll(hotelIdListForGivenRoom);
            List<HotelEntity> hotelList = hotelRepo.getHotelById(hotelIdListForGivenDate);
            return hotelList;
        }
        return null;
    }

    @Override
    public List<HotelEntity> getAllHotel() {

        if (hotelRepo.findAll().size() > 0)
            return hotelRepo.findAll();
        return null;
    }

}
