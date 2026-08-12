package com.example.parkingLot.model;

import com.example.parkingLot.enumType.VehicleType;

public class TruckParkingSpot extends ParkingSpot {
    public TruckParkingSpot(Integer id) {
        super(id);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.TRUCK;
    }
}