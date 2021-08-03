package com.book.parking.bookparking.service;

import com.book.parking.bookparking.entity.ParkingMeter;
import com.book.parking.bookparking.entity.User;

import java.util.List;
import java.util.Map;



public interface ParkingMeterService {


    ParkingMeter save(ParkingMeter PM);


    ParkingMeter saveSetEnd(User user);


    ParkingMeter findUserParkingMeter(long id);


    List<ParkingMeter> findAll();


    Map<String, Double> checkCost(User user);


    int getCurrentHours(long id);


    double getCostIfVip(int hours);


    double getCostUnlessVip(int hours);

}
