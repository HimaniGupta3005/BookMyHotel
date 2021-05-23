package com.alore.bookhotel.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.alore.bookhotel.dao.Facility;
import com.alore.bookhotel.dao.Hotel;
import com.alore.bookhotel.dao.Rating;
import com.alore.bookhotel.dao.Review;
import com.alore.bookhotel.dto.hoteldto.AddHotelRequest;
import com.alore.bookhotel.dto.hoteldto.DeleteHotelRequest;
import com.alore.bookhotel.dto.hoteldto.DeleteHotelResponse;
import com.alore.bookhotel.dto.hoteldto.GetHotelResponse;
import com.alore.bookhotel.dto.hoteldto.HotelResponse;
import com.alore.bookhotel.dto.hoteldto.SearchHotelRequest;
import com.alore.bookhotel.dto.hoteldto.SearchHotelResponse;
import com.alore.bookhotel.dto.hoteldto.UpdateHotelRequest;
import com.alore.bookhotel.entity.HotelEntity;
import com.alore.bookhotel.repositoryservice.HotelRepositoryService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    @Qualifier("modelMapper")
    private ModelMapper modelMapper;

    @Autowired
    private HotelRepositoryService hotelRepositoryService;

    @Autowired
    private ReviewService reviewService;

    @Override
    public HotelResponse addHotel(AddHotelRequest addHotelRequest) {
        HotelEntity hotelEntity = hotelRepositoryService.addHotel(addHotelRequest.getHotel());
        if (hotelEntity != null) {
            HotelResponse response = new HotelResponse(hotelEntity.getId(), hotelEntity.getName(),
                    hotelEntity.getCity(), hotelEntity.getTotalRoom(), hotelEntity.getCostOfRoom(),
                    hotelEntity.getFacility(), hotelEntity.getOverallRating());

            return response;
        }
        return null;
    }

    @Override
    public DeleteHotelResponse deleteHotel(DeleteHotelRequest deleteHotelRequest) {

        hotelRepositoryService.deleteHotel(deleteHotelRequest.getHotelId());
        DeleteHotelResponse resposnse = new DeleteHotelResponse("Successfully deleted");
        return resposnse;

    }

    @Override
    public HotelResponse updateHotel(UpdateHotelRequest updateHotelRequest) {

        HotelEntity hotelEntity = hotelRepositoryService.updateHotel(updateHotelRequest.getHotel(),
                updateHotelRequest.getHotelId());

        if (hotelEntity != null) {
            HotelResponse response = new HotelResponse(hotelEntity.getId(), hotelEntity.getName(),
                    hotelEntity.getCity(), hotelEntity.getTotalRoom(), hotelEntity.getCostOfRoom(),
                    hotelEntity.getFacility(), hotelEntity.getOverallRating());

            return response;
        }
        return null;
    }

    @Override
    public GetHotelResponse searchHotel(int id) {

        HotelEntity hotelEntity = hotelRepositoryService.searchById(id);
        if (hotelEntity != null) {

            List<Review> reviews = reviewService.getReviews(id);
            GetHotelResponse response = new GetHotelResponse(hotelEntity.getId(), hotelEntity.getName(),
                    hotelEntity.getCity(), hotelEntity.getTotalRoom(), hotelEntity.getCostOfRoom(),
                    hotelEntity.getFacility(), reviews, hotelEntity.getOverallRating());

            return response;
        }
        return null;

    }

    @Override
    public SearchHotelResponse searchHotel(SearchHotelRequest searchHotelRequest) {

        String city = searchHotelRequest.getCity();
        LocalDate date = searchHotelRequest.getDate();
        int roomRequired = searchHotelRequest.getRoomRequired();
        Rating rating = searchHotelRequest.getRating();
        List<Facility> facilities = searchHotelRequest.getFacilities();

        List<HotelEntity> hotelEntities = hotelRepositoryService.getAllHotel();
        if (hotelEntities.size() > 0 && city != null && !city.equals("")) {
            hotelEntities = hotelEntities.stream().filter(x -> x.getCity().equalsIgnoreCase(city))
                    .collect(Collectors.toList());
        }

        if (hotelEntities.size() > 0 && rating != null) {
            hotelEntities = hotelEntities.stream()
                    .filter(x -> x.getOverallRating() != null && x.getOverallRating().ordinal() == rating.ordinal())
                    .collect(Collectors.toList());
        }

        if (hotelEntities.size() > 0 && facilities.size() > 0) {
            hotelEntities = hotelEntities.stream().filter(x -> x.getFacility().containsAll(facilities))
                    .collect(Collectors.toList());

        }

        if (hotelEntities.size() > 0 && (date != null || roomRequired > 0)) {
            List<HotelEntity> hotelList = hotelRepositoryService.getHotelByDate(date, roomRequired);
            hotelEntities.retainAll(hotelList);
        }

        if (hotelEntities.size() > 0 && hotelEntities.size() > 0) {

            List<Hotel> hotels = new ArrayList<>();

            for (HotelEntity h : hotelEntities) {

                Hotel tmp = modelMapper.map(h, Hotel.class);
                hotels.add(tmp);
            }

            SearchHotelResponse searchHotelResponse = new SearchHotelResponse(hotels);
            return searchHotelResponse;
        }
        return null;

    }

}
