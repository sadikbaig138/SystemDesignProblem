package com.example.parkingLot.Strategy;

import com.example.parkingLot.model.Ticket;

public interface PricingStrategy {
    double calculateFee(Ticket ticket);
}