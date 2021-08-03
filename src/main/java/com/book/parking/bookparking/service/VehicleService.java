package com.book.parking.bookparking.service;

import com.book.parking.bookparking.entity.User;
import com.book.parking.bookparking.entity.Vehicle;

import java.util.List;
import java.util.Optional;



public interface VehicleService {

    Vehicle save(Vehicle vehicle);

    Vehicle createVehicle(String number, User user);

    List<Vehicle> getVehiclesByNumber(String number);

    Optional<Vehicle> isStarted(List<Vehicle> list);

}
