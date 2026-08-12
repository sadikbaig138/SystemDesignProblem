package com.example.parkingLot.model;

import com.example.parkingLot.enumType.Status;

import java.util.Map;

public class DisplayBoard {
    private final ParkingLot parkingLot;

    public DisplayBoard(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void show() {
        System.out.println("========== Parking Lot Status ==========");
        for (Map.Entry<String, ParkingFloor> entry : parkingLot.getFloorMap().entrySet()) {
            String floorId = entry.getKey();
            ParkingFloor floor = entry.getValue();
            long vacant   = floor.getSpots().stream().filter(s -> s.getStatus() == Status.VACANT).count();
            long occupied = floor.getSpots().stream().filter(s -> s.getStatus() == Status.OCCUPIED).count();
            System.out.printf("Floor %s — Vacant: %d | Occupied: %d%n", floorId, vacant, occupied);
        }

        double totalRevenue = parkingLot.getTicketMap().values().stream()
                .mapToDouble(Ticket::getFee)
                .sum();
        System.out.printf("Total revenue collected: %.2f%n", totalRevenue);
        System.out.println("========================================");
    }
}