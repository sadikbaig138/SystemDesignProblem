package com.example.parkingLot.model;

import com.example.parkingLot.enumType.VehicleType;

public class Car extends Vehicle {
    public Car(String vehicleNo) {
        super(vehicleNo, VehicleType.CAR);
    }
}