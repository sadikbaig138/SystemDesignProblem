package com.example.splitWise.service;

import com.example.splitWise.model.Expense;
import com.example.splitWise.model.Split;
import com.example.splitWise.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class BalanceSheet {

    private static final BalanceSheet sheet = new BalanceSheet();

    private final ConcurrentHashMap<User, Map<User, Double>> balancerMap = new ConcurrentHashMap<>();

    public static BalanceSheet getSheet() {
        return sheet;
    }

    public ConcurrentHashMap<User, Map<User, Double>> getBalancerMap() {
        return balancerMap;
    }

    public BalanceSheet calculateBalanceSheet(Expense expense) {
        // Build a per-split-user amount map from this expense's splits
        Map<User, Double> splitUserAmounts = expense.getSplitUsers().stream()
                .collect(Collectors.toMap(Split::getUser, Split::getAmount));

        // Merge into the payer's existing balance map, summing amounts for repeat users
        Map<User, Double> payerMap = balancerMap.computeIfAbsent(expense.getPayBy(), u -> new ConcurrentHashMap<>());
        splitUserAmounts.forEach((user, amount) -> payerMap.merge(user, amount, Double::sum));

        return sheet;
    }
}
