package com.book.parking.bookparking.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.book.parking.bookparking.entity.User;
import com.book.parking.bookparking.entity.Vehicle;
import com.book.parking.bookparking.repository.VehicleRepo;
import com.book.parking.bookparking.service.VehicleService;
import org.springframework.stereotype.Service;



@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepo vehicleRepo;

    public VehicleServiceImpl(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @Override
    public Vehicle createVehicle(String number, User user) {

        Vehicle vehicle = new Vehicle(number, user);
        return vehicleRepo.save(vehicle);

    }

    @Override
    public List<Vehicle> getVehiclesByNumber(String number) {
        return vehicleRepo.findAllByNumber(number);
    }

    @Override
    public Optional<Vehicle> isStarted(List<Vehicle> list) {
        return list.stream().filter(v -> v.getOwner().isStarted()).findFirst();

    }

}
