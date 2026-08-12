package com.example.parkingLot.model;

public class EntryGate {
    private final ParkingLot parkingLot;

    public EntryGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket enter(Vehicle vehicle) {
        return parkingLot.parkVehicle(vehicle);
    }

    public boolean isSpotAvailable(Vehicle vehicle) {
        return parkingLot.isSpotAvailable(vehicle);
    }
}