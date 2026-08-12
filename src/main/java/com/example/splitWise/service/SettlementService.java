package com.example.splitWise.service;

import com.example.splitWise.model.Expense;
import com.example.splitWise.model.Split;
import com.example.splitWise.model.User;

public class SettlementService {

    private final BalanceSheet balanceSheet;

    public SettlementService(BalanceSheet sheet){
        super();
        this.balanceSheet=sheet;
    }

    public BalanceSheet settlementAmount(Expense expense,User payer,double amount){
        Split split=expense.getSplitUsers().stream().filter(x->x.getUser().equals(payer)).findFirst().orElse(null);
        if(split!=null){
            split.setAmount(split.getAmount()-amount);
            return this.balanceSheet.calculateBalanceSheet(expense);
        }
        return this.balanceSheet;
    }
}
