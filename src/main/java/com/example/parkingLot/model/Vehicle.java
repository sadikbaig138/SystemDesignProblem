package com.example.parkingLot.model;

import com.example.parkingLot.enumType.VehicleType;

public abstract class Vehicle {
    private final String vehicleNo;
    private final VehicleType type;

    protected Vehicle(String vehicleNo, VehicleType type) {
        this.vehicleNo = vehicleNo;
        this.type = type;
    }

    public VehicleType getType() { return type; }
    public String getVehicleNo() { return vehicleNo; }
}