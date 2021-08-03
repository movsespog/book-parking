package com.book.parking.bookparking.controller;

import com.book.parking.bookparking.entity.User;
import com.book.parking.bookparking.service.ParkingMeterService;
import com.book.parking.bookparking.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("users/")
public class UserController {

    private UserService userService;
    private ParkingMeterService parkingMeterService;

    static private String FINISH_PREVIOUS_PARKING = "Finish your previous parking first.";
    static private String START_PARKING_FIRST = "Nothing to show. Start parking first.";
    static private String NO_CURRENT_PARKING = "Nothing to show. There is no current parking.";
    static private String NOTHING_TO_FINISH = "Nothing to be finished.";

    public UserController(UserService userService, ParkingMeterService parkingMeterService) {
        this.userService = userService;
        this.parkingMeterService = parkingMeterService;
    }


    public User getUserByUsername(String username) {
        return userService.getOneByUsername(username);
    }


    @PostMapping("create")
    ResponseEntity<Object> createNewUser(@RequestBody String username) {
        return ResponseEntity.ok(userService.save(username));
    }


    @PostMapping("startParking/{username}")
    ResponseEntity<Object> startParking(@RequestBody String vehicleNumber, @PathVariable("username") String username) {

        User user = getUserByUsername(username);

        if (user.isStarted() == true) {
            return ResponseEntity.ok(FINISH_PREVIOUS_PARKING);
        } else {
            return ResponseEntity.ok(userService.startParking(vehicleNumber, user));
        }

    }


    @GetMapping("checkParking/{username}")
    ResponseEntity<Object> checkParking(@PathVariable("username") String username) {

        User user = getUserByUsername(username);

        if (user.isStarted() == false) {
            return ResponseEntity.ok(START_PARKING_FIRST);
        } else {
            return ResponseEntity.ok(parkingMeterService.findUserParkingMeter(user.getId()));
        }

    }


    @GetMapping("checkCost/{username}")
    ResponseEntity<?> checkCost(@PathVariable("username") String username) {

        User user = getUserByUsername(username);

        if (user.isStarted() == false) {
            return ResponseEntity.ok(NO_CURRENT_PARKING);
        } else {

            return ResponseEntity.ok(parkingMeterService.checkCost(user));
        }
    }


    @PostMapping("endParking/{username}")
    ResponseEntity<?> endUserParking(@PathVariable("username") String username) {

        User user = getUserByUsername(username);
        if (user.isStarted() == false) {
            return ResponseEntity.ok(NOTHING_TO_FINISH);
        } else {
            return ResponseEntity.ok(userService.finishParking(user));
        }

    }

}

