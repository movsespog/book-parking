package com.book.parking.bookparking.controller;

import java.util.List;

import com.book.parking.bookparking.entity.User;
import com.book.parking.bookparking.entity.Vehicle;
import com.book.parking.bookparking.service.UserService;
import com.book.parking.bookparking.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("users/")
public class OperatorController {

    private UserService userService;
    private VehicleService vehicleService;

    public OperatorController(UserService userService, VehicleService vehicleService) {
        this.userService = userService;
        this.vehicleService = vehicleService;
    }


    @RequestMapping("")
    ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @RequestMapping("{id}")
    ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        return ResponseEntity.ok(userService.getOneById(id));
    }


    @PutMapping("{id}/vip")
    ResponseEntity<Object> setUserAsVip(@PathVariable("id") long id) {
        return ResponseEntity.ok(userService.setUserAsVip(id));

    }


    @GetMapping("vip")
    ResponseEntity<List<User>> showAllVips() {
        return ResponseEntity.ok(userService.findAllWhereVip(true));
    }


    @PostMapping("vehicle")
    ResponseEntity<?> test(@RequestBody String number) {
        List<Vehicle> vehicles = vehicleService.getVehiclesByNumber(number);
        return ResponseEntity.ok(vehicleService.isStarted(vehicles));
    }
}

