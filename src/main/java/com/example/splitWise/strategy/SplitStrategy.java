package com.example.splitWise.strategy;

import com.example.splitWise.model.Split;
import com.example.splitWise.model.User;

import java.util.List;

public interface SplitStrategy {
    double calculateAmounts(List<User> user, double amount);
}
