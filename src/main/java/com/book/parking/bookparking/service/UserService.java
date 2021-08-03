package com.book.parking.bookparking.service;

import com.book.parking.bookparking.entity.User;

import java.util.List;
import java.util.Map;



public interface UserService {


    List<User> getAllUsers();


    User getOneById(long id);


    User getOneByUsername(String username);


    Object save(String username);


    Object setUserAsVip(long id);


    List<User> findAllWhereVip(boolean vip);


    User startParking(String number, User user);


    Map<String, Double> finishParking(User user);

}

