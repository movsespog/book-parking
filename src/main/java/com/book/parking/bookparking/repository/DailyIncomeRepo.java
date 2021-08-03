package com.book.parking.bookparking.repository;

import java.time.LocalDate;

import com.book.parking.bookparking.entity.DailyIncome;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DailyIncomeRepo extends JpaRepository<DailyIncome, Long> {


    DailyIncome findOneByDate(LocalDate date);

}