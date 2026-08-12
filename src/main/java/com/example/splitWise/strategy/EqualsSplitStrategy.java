package com.example.splitWise.strategy;

import com.example.splitWise.model.User;

import java.util.List;

public class EqualsSplitStrategy implements SplitStrategy{
    @Override
    public double calculateAmounts(List<User> user, double amount) {
        var splitAmount=0.0;
        if(!user.isEmpty()){
            splitAmount=amount/user.size();
        }
        return splitAmount;
    }
}
