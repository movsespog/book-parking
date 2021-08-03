package com.book.parking.bookparking.repository;

import com.book.parking.bookparking.entity.ParkingMeter;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ParkingMeterRepo extends JpaRepository<ParkingMeter, Long> {


    ParkingMeter getFirstByUserIdOrderByStart(long id);

}

