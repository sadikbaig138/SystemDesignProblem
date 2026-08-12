package com.example.parkingLot.model;

import com.example.parkingLot.enumType.VehicleType;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(Integer id) {
        super(id);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.CAR;
    }
}