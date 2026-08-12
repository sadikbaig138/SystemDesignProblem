package com.example.parkingLot.model;

import com.example.parkingLot.enumType.VehicleType;

public class Truck extends Vehicle {
    public Truck(String vehicleNo) {
        super(vehicleNo, VehicleType.TRUCK);
    }
}