package com.alore.bookhotel.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.alore.bookhotel.dao.Facility;
import com.alore.bookhotel.dao.Rating;

import org.hibernate.annotations.Generated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Table(name = "hotel")
@Entity
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    private String name;
    @NonNull
    private String city;
    @NonNull
    private int totalRoom;
    @NonNull
    private int costOfRoom;

    @ElementCollection(targetClass = Facility.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "facility")
    @Column(name = "name")
    private List<Facility> facility;

    @Enumerated(EnumType.STRING)
    Rating overallRating;

    public Rating getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Rating overallRating) {
        this.overallRating = overallRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTotalRoom() {
        return totalRoom;
    }

    public void setTotalRoom(int totalRoom) {
        this.totalRoom = totalRoom;
    }

    public int getCostOfRoom() {
        return costOfRoom;
    }

    public void setCostOfRoom(int costOfRoom) {
        this.costOfRoom = costOfRoom;
    }

    public List<Facility> getFacility() {
        return facility;
    }

    public HotelEntity() {
    }

    public HotelEntity(int id, @NonNull String name, String city, int totalRoom, int costOfRoom,
            List<Facility> facility, Rating overallRating) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.totalRoom = totalRoom;
        this.costOfRoom = costOfRoom;
        this.facility = facility;
        this.overallRating = overallRating;
    }

    /**
     * @param facility the facility to set
     */
    public void setFacility(List<Facility> facility) {
        this.facility = facility;
    }

}
