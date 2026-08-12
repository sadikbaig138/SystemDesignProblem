package com.example.parkingLot.model;

import com.example.parkingLot.enumType.TicketStatus;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {
    private static final AtomicInteger counter = new AtomicInteger();

    private final int ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final String floorNo;
    private final LocalDateTime entryTime;
    private TicketStatus status;
    private double fee;

    public Ticket(Vehicle vehicle, ParkingSpot spot, String floorNo) {
        this.ticketId = counter.incrementAndGet();
        this.vehicle = vehicle;
        this.spot = spot;
        this.floorNo = floorNo;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.ASSIGNED;
        this.fee = 0.0;
    }

    public int getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getSpot() { return spot; }
    public String getFloorNo() { return floorNo; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public TicketStatus getStatus() { return status; }
    public double getFee() { return fee; }

    public void setFee(double fee) { this.fee = fee; }
    public void setStatus(TicketStatus status) { this.status = status; }
}