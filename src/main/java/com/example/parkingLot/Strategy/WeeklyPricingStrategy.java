package com.example.parkingLot.Strategy;

import com.example.parkingLot.model.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class WeeklyPricingStrategy implements PricingStrategy {

    @Override
    public double calculateFee(Ticket ticket) {
        long hours = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
        hours = Math.max(hours, 1);
        switch (ticket.getVehicle().getType()) {
            case CAR:   return hours * 40.0;
            case BIKE:  return hours * 20.0;
            case TRUCK: return hours * 60.0;
            default:    return 0.0;
        }
    }
}