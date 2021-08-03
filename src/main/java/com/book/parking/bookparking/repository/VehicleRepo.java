package com.book.parking.bookparking.repository;

import java.util.List;

import com.book.parking.bookparking.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

    Vehicle findOneByNumber(String number);

    List<Vehicle> findAllByNumber(String number);

}
