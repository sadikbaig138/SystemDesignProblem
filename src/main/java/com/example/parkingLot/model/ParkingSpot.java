package com.example.parkingLot.model;

import com.example.parkingLot.enumType.Status;

import java.util.concurrent.locks.ReentrantLock;

public abstract class ParkingSpot {
    private final Integer spotId;
    private Status status = Status.VACANT;
    private Vehicle vehicle;
    private final ReentrantLock lock = new ReentrantLock();

    protected ParkingSpot(Integer spotId) {
        this.spotId = spotId;
    }

    public Integer getSpotId() { return spotId; }
    public Status getStatus() { return status; }
    public Vehicle getVehicle() { return vehicle; }

    public boolean isAvailable() {
        return status == Status.VACANT;
    }

    /**
     * Atomically checks fit + availability and parks the vehicle.
     * Returns true if successfully parked, false if spot was taken or wrong type.
     */
    public boolean tryPark(Vehicle vehicle) {
        lock.lock();
        try {
            if (status == Status.VACANT && canFitVehicle(vehicle)) {
                this.vehicle = vehicle;
                this.status = Status.OCCUPIED;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void removeVehicle() {
        lock.lock();
        try {
            this.vehicle = null;
            this.status = Status.VACANT;
        } finally {
            lock.unlock();
        }
    }

    public abstract boolean canFitVehicle(Vehicle vehicle);
}