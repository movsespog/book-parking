package com.book.parking.bookparking.service;

import com.book.parking.bookparking.entity.DailyIncome;

import java.util.List;
import java.util.Map;



public interface DailyIncomeService {


    List<DailyIncome> getAllDailyIncome();


    DailyIncome save(DailyIncome dailyInc);


    Object getOneByDate(String date);


    DailyIncome addIncome(Map<String, Double> map);

}
