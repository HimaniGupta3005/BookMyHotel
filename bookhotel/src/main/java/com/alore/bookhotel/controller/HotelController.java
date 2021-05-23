package com.alore.bookhotel.controller;

import java.time.LocalDate;
import java.util.List;

import com.alore.bookhotel.dao.Facility;
import com.alore.bookhotel.dao.Hotel;
import com.alore.bookhotel.dao.Rating;
import com.alore.bookhotel.dto.hoteldto.AddHotelRequest;
import com.alore.bookhotel.dto.hoteldto.DeleteHotelRequest;
import com.alore.bookhotel.dto.hoteldto.DeleteHotelResponse;
import com.alore.bookhotel.dto.hoteldto.GetHotelResponse;
import com.alore.bookhotel.dto.hoteldto.HotelResponse;
import com.alore.bookhotel.dto.hoteldto.SearchHotelRequest;
import com.alore.bookhotel.dto.hoteldto.SearchHotelResponse;
import com.alore.bookhotel.dto.hoteldto.UpdateHotelRequest;
import com.alore.bookhotel.repository.HotelRepository;
import com.alore.bookhotel.service.HotelService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/BookMyHotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping(value = "/hotel")
    public ResponseEntity<GetHotelResponse> getHotel(@RequestParam int hotel) {

        GetHotelResponse response = hotelService.searchHotel(hotel);

        if (response != null)
            return ResponseEntity.ok().body(response);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/hotelSearch")
    public ResponseEntity<SearchHotelResponse> getHotelBySearchFields(
            @RequestBody SearchHotelRequest searchHotelRequest) {

        SearchHotelResponse response = hotelService.searchHotel(searchHotelRequest);

        if (response != null)
            return ResponseEntity.ok().body(response);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/hotel")
    public ResponseEntity<HotelResponse> addHotel(@RequestBody AddHotelRequest addHotelRequest) {

        if (addHotelRequest != null) {
            HotelResponse response = hotelService.addHotel(addHotelRequest);
            if (response != null)
                return ResponseEntity.ok().body(response);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/hotel")
    public ResponseEntity<DeleteHotelResponse> deleteHotel(@RequestBody DeleteHotelRequest deleteHotelRequest) {

        if (deleteHotelRequest != null) {
            DeleteHotelResponse response = hotelService.deleteHotel(deleteHotelRequest);
            if (response != null)
                return ResponseEntity.ok().body(response);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/hotel")
    public ResponseEntity<HotelResponse> updateHotel(@RequestBody UpdateHotelRequest updateHotelRequest) {

        if (updateHotelRequest != null) {
            HotelResponse response = hotelService.updateHotel(updateHotelRequest);
            if (response != null)
                return ResponseEntity.ok().body(response);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
