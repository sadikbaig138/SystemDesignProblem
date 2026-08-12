package com.example.parkingLot.model;

import java.time.LocalDateTime;

public class Payment {
    private final int ticketId;
    private final double amount;
    private final LocalDateTime paidAt;

    public Payment(int ticketId, double amount) {
        this.ticketId = ticketId;
        this.amount = amount;
        this.paidAt = LocalDateTime.now();
    }

    public int getTicketId() { return ticketId; }
    public double getAmount() { return amount; }
    public LocalDateTime getPaidAt() { return paidAt; }
}