package com.example.parkingLot;

import com.example.parkingLot.Strategy.HourlyPriceStrategy;
import com.example.parkingLot.model.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotApplication {

    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        DisplayBoard display = new DisplayBoard(parkingLot);

        List<ParkingSpot> floor1Spots = new ArrayList<>();
        List<ParkingSpot> floor2Spots = new ArrayList<>();
        int id = 0;
        for (int i = 0; i < 5; i++) {
            floor1Spots.add(new CarParkingSpot(++id));
            floor1Spots.add(new BikeParkingSpot(++id));
            floor2Spots.add(new CarParkingSpot(++id));
            floor2Spots.add(new BikeParkingSpot(++id));
        }

        parkingLot.addParkingFloor("1", new ParkingFloor(1, floor1Spots));
        parkingLot.addParkingFloor("2", new ParkingFloor(2, floor2Spots));

        EntryGate entryGate = new EntryGate(parkingLot);
        ExitGate  exitGate  = new ExitGate(new HourlyPriceStrategy());

        Vehicle car   = new Car("MP04ST8545");
        Vehicle bike  = new Bike("MP04YE7099");
        Vehicle bike2 = new Bike("MP04MY0926");

        System.out.println("Spot available for car: " + entryGate.isSpotAvailable(car));
        display.show();

        Ticket carTicket   = entryGate.enter(car);
        Ticket bikeTicket  = entryGate.enter(bike);
        Ticket bikeTicket2 = entryGate.enter(bike2);

        System.out.println("\nAfter parking 1 car + 2 bikes:");
        display.show();

        Payment p1 = exitGate.exit(bikeTicket2, parkingLot);
        Payment p2 = exitGate.exit(bikeTicket, parkingLot);
        System.out.printf("%nPayment for ticket %d: %.2f%n", p1.getTicketId(), p1.getAmount());
        System.out.printf("Payment for ticket %d: %.2f%n", p2.getTicketId(), p2.getAmount());

        System.out.println("\nAfter unparking both bikes:");
        display.show();
    }
}