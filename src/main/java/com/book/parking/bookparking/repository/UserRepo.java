package com.book.parking.bookparking.repository;

import java.util.List;
import java.util.Optional;

import com.book.parking.bookparking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepo extends JpaRepository<User, Long> {


    List<User> findAllByVip(boolean vip);


    User findOneByUsername(String username);

    Optional<User> findById(Long id);
}
