package com.alore.bookhotel.dao;

import java.time.LocalDate;

public class Room {

    private int hotelId;
    private LocalDate date;
    private int occupiedRoom;

    public Room() {
    }

    public Room(int hotelId, LocalDate date, int occupiedRoom) {
        this.hotelId = hotelId;
        this.date = date;
        this.occupiedRoom = occupiedRoom;
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
