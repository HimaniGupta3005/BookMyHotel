package com.alore.bookhotel.repository;

import java.time.LocalDate;
import java.util.List;

import com.alore.bookhotel.entity.RoomEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

    @Query("select r from RoomEntity r where r.hotelId = ?1")
    public List<RoomEntity> findByHotelId(int hotelId);

    @Query("select r.hotelId from RoomEntity r where r.date = ?1")
    public List<Integer> findRoomByDate(LocalDate date);

    @Query("select r.hotelId from RoomEntity r where r.occupiedRoom >= ?1")
    public List<Integer> findRoomByRoom(int roomRequired);

}
