package com.example.parkingLot.model;

import com.example.parkingLot.Strategy.PricingStrategy;
import com.example.parkingLot.enumType.TicketStatus;

public class ExitGate {
    private PricingStrategy pricingStrategy;

    public ExitGate(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public Payment exit(Ticket ticket, ParkingLot parkingLot) {
        double amount = pricingStrategy.calculateFee(ticket);
        ticket.setFee(amount);
        ticket.setStatus(TicketStatus.CLOSED);
        ticket.getSpot().removeVehicle();
        parkingLot.closeTicket(ticket);
        return new Payment(ticket.getTicketId(), amount);
    }
}