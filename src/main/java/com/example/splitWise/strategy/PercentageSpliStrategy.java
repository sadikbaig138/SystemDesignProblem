package com.example.splitWise.strategy;

import com.example.splitWise.model.User;

import java.util.List;

public class PercentageSpliStrategy implements SplitStrategy{

    @Override
    public double calculateAmounts(List<User> user, double amount) {
        return 0;
    }
}
