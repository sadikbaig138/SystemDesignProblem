package com.example.parkingLot.model;

import com.example.parkingLot.enumType.VehicleType;

public class Bike extends Vehicle {
    public Bike(String vehicleNo) {
        super(vehicleNo, VehicleType.BIKE);
    }
}