package com.alore.bookhotel.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.alore.bookhotel.dao.Hotel;

@Table(name = "room")
@Entity
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int hotelId;

    private LocalDate date;
    private int occupiedRoom;

    public RoomEntity() {
    }

    public RoomEntity(int id, int hotelId, LocalDate date, int occupiedRoom) {
        this.id = id;
        this.hotelId = hotelId;
        this.date = date;
        this.occupiedRoom = occupiedRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getOccupiedRoom() {
        return occupiedRoom;
    }

    public void setOccupiedRoom(int occupiedRoom) {
        this.occupiedRoom = occupiedRoom;
    }

}
