package com.alore.bookhotel.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.alore.bookhotel.dao.Hotel;
import com.alore.bookhotel.entity.HotelEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {

    // @Query("select h from hotelentity h where h.name = ?1")
    public HotelEntity findByName(String name);

    public Optional<List<HotelEntity>> findByCity(String city);

    @Query("select h from HotelEntity h where h.id in ?1")
    public List<HotelEntity> getHotelById(List<Integer> hotelIdList);

    // @Query("select h from hotelentity h where h.name = ?1")
    // public List<HotelEntity> findHotelByName(String name);

    // @Query("select h from hotelentity h join roomentity r on h.room_id =
    // r.hotel_id where h.room >= ?1 and r.availableRoom >= ?1")
    // public List<HotelEntity> findHotelByAvailableRooms(int room);

    // @Query("select h from hotelentity h join roomentity r on h.room_id =
    // r.hotel_id where h.city = ?1 and h.date = ?2 && and r.availableRoom > 0")
    // public List<HotelEntity> findHotelByCityAndDate(String city, LocalDate data);

}
