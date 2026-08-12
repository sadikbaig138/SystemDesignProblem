package com.example.parkingLot.model;

import com.example.parkingLot.enumType.VehicleType;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(Integer id) {
        super(id);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.BIKE;
    }
}