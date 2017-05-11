package com.apress.springrecipes.court.service;

import java.util.List;

import com.apress.springrecipes.court.domain.Reservation;

public interface ReservationService {

    public List<Reservation> query(String courtName);


}
