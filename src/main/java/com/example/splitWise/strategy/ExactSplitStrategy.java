package com.example.splitWise.strategy;

import com.example.splitWise.model.Split;
import com.example.splitWise.model.User;

import java.util.List;

public class ExactSplitStrategy implements SplitStrategy{
    @Override
    public double calculateAmounts(List<User> user, double amount) {
        return 0.0;
    }
}
