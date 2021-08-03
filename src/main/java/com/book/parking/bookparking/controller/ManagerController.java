package com.book.parking.bookparking.controller;

import java.util.List;

import com.book.parking.bookparking.entity.DailyIncome;
import com.book.parking.bookparking.service.DailyIncomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("manager/")
public class ManagerController {

    private DailyIncomeService dailyIncomeService;

    public ManagerController(DailyIncomeService dailyIncomeService) {
        this.dailyIncomeService = dailyIncomeService;
    }


    @GetMapping("dailyIncome/{date}")
    ResponseEntity<Object> dailyIncome(@PathVariable("date") String date) {
        return ResponseEntity.ok(dailyIncomeService.getOneByDate(date));
    }


    @GetMapping("all/dailyIncome")
    ResponseEntity<List<DailyIncome>> incomeListOfAllDays() {
        return ResponseEntity.ok(dailyIncomeService.getAllDailyIncome());
    }

}
