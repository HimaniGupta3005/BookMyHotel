package com.alore.bookhotel.service;

import java.util.List;

import com.alore.bookhotel.dao.Hotel;
import com.alore.bookhotel.dto.hoteldto.AddHotelRequest;
import com.alore.bookhotel.dto.hoteldto.DeleteHotelRequest;
import com.alore.bookhotel.dto.hoteldto.DeleteHotelResponse;
import com.alore.bookhotel.dto.hoteldto.GetHotelResponse;
import com.alore.bookhotel.dto.hoteldto.HotelResponse;
import com.alore.bookhotel.dto.hoteldto.SearchHotelRequest;
import com.alore.bookhotel.dto.hoteldto.SearchHotelResponse;
import com.alore.bookhotel.dto.hoteldto.UpdateHotelRequest;

public interface HotelService {

    public HotelResponse addHotel(AddHotelRequest addhotelRequest);

    public DeleteHotelResponse deleteHotel(DeleteHotelRequest deleteHotelRequest);

    public HotelResponse updateHotel(UpdateHotelRequest updateHotelRequest);

    public GetHotelResponse searchHotel(int id);

    public SearchHotelResponse searchHotel(SearchHotelRequest searchHotelRequest);

}
