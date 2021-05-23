package com.alore.bookhotel.repositoryservice;

import java.time.LocalDate;
import java.util.List;

import com.alore.bookhotel.dao.Hotel;
import com.alore.bookhotel.entity.HotelEntity;

public interface HotelRepositoryService {

    public HotelEntity addHotel(Hotel hotel);

    public void deleteHotel(int hotelId);

    public HotelEntity updateHotel(Hotel Hotel, int id);

    public HotelEntity searchById(int id);

    public List<HotelEntity> getHotelByCity(String city);

    public List<HotelEntity> getAllHotel();

    public List<HotelEntity> getHotelByDate(LocalDate date, int roomRequired);

}
