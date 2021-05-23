package com.alore.bookhotel.repository;

import java.util.List;

import com.alore.bookhotel.dao.Hotel;
import com.alore.bookhotel.dao.User;
import com.alore.bookhotel.entity.ReviewEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {

    @Query("select r from ReviewEntity r where r.hotelId = ?1")
    List<ReviewEntity> getReviewByHotelId(int hotelId);

    @Query("select count(r) from ReviewEntity r where hotelId = ?1")
    public int countReviewPerHotel(int hotelId);

}
