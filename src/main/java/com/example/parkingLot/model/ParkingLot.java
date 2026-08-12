package com.example.parkingLot.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static final ParkingLot INSTANCE = new ParkingLot();

    private final ConcurrentHashMap<String, ParkingFloor> floorMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, Ticket> ticketMap = new ConcurrentHashMap<>();

    private ParkingLot() {}

    public static ParkingLot getInstance() { return INSTANCE; }

    public void addParkingFloor(String floorId, ParkingFloor floor) {
        floorMap.putIfAbsent(floorId, floor);
    }

    public ConcurrentHashMap<String, ParkingFloor> getFloorMap() { return floorMap; }
    public ConcurrentHashMap<Integer, Ticket> getTicketMap() { return ticketMap; }

    /**
     * Finds the first available spot across all floors and atomically parks the vehicle.
     * tryPark() on each spot is the critical section — no separate check-then-act gap.
     */
    public Ticket parkVehicle(Vehicle vehicle) {
        for (Map.Entry<String, ParkingFloor> entry : floorMap.entrySet()) {
            ParkingSpot spot = entry.getValue().findAndPark(vehicle);
            if (spot != null) {
                Ticket ticket = new Ticket(vehicle, spot, entry.getKey());
                ticketMap.put(ticket.getTicketId(), ticket);
                return ticket;
            }
        }
        return null;
    }

    public boolean isSpotAvailable(Vehicle vehicle) {
        return floorMap.values().stream().anyMatch(f -> f.hasAvailableSpot(vehicle));
    }

    public void closeTicket(Ticket ticket) {
        ticketMap.remove(ticket.getTicketId());
    }
}