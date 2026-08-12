package com.example.splitWise.service;

import com.example.splitWise.enums.ExpenseType;
import com.example.splitWise.model.Expense;
import com.example.splitWise.model.Split;
import com.example.splitWise.model.User;
import com.example.splitWise.strategy.SplitStrategy;
import com.example.splitWise.strategy.StrategyFactory;

import java.util.*;
public class ExpenseService {

    private final BalanceSheet balanceSheet;
    public ExpenseService(BalanceSheet sheet){
        super();
        this.balanceSheet=sheet;
    }

    public BalanceSheet addExpenses(Expense expense, List<User> userList){
            SplitStrategy splitStrategy = StrategyFactory.getInstance(expense.getSplitType());
            var splitAmount= splitStrategy.calculateAmounts(userList,expense.getAmount());
            List<Split> list=new ArrayList<>();
            for(User user:userList){
                if(!Objects.equals(user.getId(), expense.getPayBy().getId())){
                    Split split=new Split(user,splitAmount);
                    list.add(split);
                }
            }
            expense.setSplitUsers(list);
        System.out.println("Expense creation end...");

        return this.balanceSheet.calculateBalanceSheet(expense);
    }
}
