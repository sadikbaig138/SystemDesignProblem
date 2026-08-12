package com.example.splitWise.service;

import com.example.splitWise.model.User;

import java.util.Map;

public class DisplayDashBoard {

    private final BalanceSheet balanceSheet;

    public DisplayDashBoard(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public void show() {
        balanceSheet.getBalancerMap().forEach((payer, splitUsers) -> {
            double totalDue = splitUsers.values().stream().mapToDouble(Double::doubleValue).sum();
            System.out.println("User name=" + payer.getName() + ", total due=" + totalDue);
            splitUsers.forEach((user, amount) ->
                    System.out.println("  Due by=" + user.getName() + ", amount=" + amount));
        });
    }
}
