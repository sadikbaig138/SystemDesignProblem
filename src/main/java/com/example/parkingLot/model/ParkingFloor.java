package com.example.parkingLot.model;

import java.util.List;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> spots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.spots = spots;
    }

    public int getFloorNumber() { return floorNumber; }
    public List<ParkingSpot> getSpots() { return spots; }

    /** Returns a spot and atomically parks the vehicle, or null if none available. */
    public ParkingSpot findAndPark(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.tryPark(vehicle)) {
                return spot;
            }
        }
        return null;
    }

    public boolean hasAvailableSpot(Vehicle vehicle) {
        return spots.stream().anyMatch(s -> s.isAvailable() && s.canFitVehicle(vehicle));
    }
}