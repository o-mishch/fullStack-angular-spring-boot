package com.linkedin.learning.convertor;

import com.linkedin.learning.entity.ReservationEntity;
import com.linkedin.learning.model.response.ReservationResponse;
import org.springframework.core.convert.converter.Converter;

import java.util.function.Function;

public class ReservationEntityToReservationResponseConverter implements
        Converter<ReservationEntity, ReservationResponse>,
        Function<ReservationEntity, ReservationResponse> {

    @Override
    public ReservationResponse convert(ReservationEntity source) {
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setCheckin(source.getCheckin());
        reservationResponse.setCheckout(source.getCheckout());

        if (null != source.getRoomEntity())
            reservationResponse.setId(source.getRoomEntity().getId());

        return reservationResponse;
    }

    @Override
    public ReservationResponse apply(ReservationEntity source) {
        return convert(source);
    }
}