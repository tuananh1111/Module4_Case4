package com.casestudy.case4.service.hotel;


import com.casestudy.case4.model.Hotel;
import com.casestudy.case4.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHotelService extends GeneralService<Hotel> {
    Page<Hotel> findAllByStatusIsFalse(Pageable pageable);
    Hotel findAllById(Long id);
}
