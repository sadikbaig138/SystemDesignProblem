package com.example.splitWise;

import com.example.splitWise.enums.ExpenseStatus;
import com.example.splitWise.enums.ExpenseType;
import com.example.splitWise.enums.SplitType;
import com.example.splitWise.model.Expense;
import com.example.splitWise.model.Split;
import com.example.splitWise.model.User;
import com.example.splitWise.service.BalanceSheet;
import com.example.splitWise.service.DisplayDashBoard;
import com.example.splitWise.service.ExpenseService;
import com.example.splitWise.service.SettlementService;
import com.example.splitWise.strategy.ExactSplitStrategy;
import com.example.splitWise.strategy.SplitStrategy;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;

import java.util.List;

public class SplitWiseApplication {
    public static void main (String[] args){
        BalanceSheet sheet=BalanceSheet.getSheet();
        DisplayDashBoard display=new DisplayDashBoard(sheet);
        ExpenseService expenseService=new ExpenseService(sheet);
        SettlementService settlement=new SettlementService(sheet);
        User user1=new User("Sadik",1,"sadikbaig@rakuten.com");
        User user2=new User("Mohit",2,"mohitmalve@rakuten.com");
        User user3=new User("Aman",3,"aman.kaushal@takuten.com");

        Expense expense=new Expense(1,"Cake cutting","Birthday cake cutting", SplitType.EQUAL, ExpenseStatus.INITIATED);
        expense.setPayBy(user1);
        expense.setExpenseType(ExpenseType.GROUP);
        expense.setAmount(2000.0);

        Expense expense2=new Expense(2,"Gift","Gift distribution", SplitType.EQUAL, ExpenseStatus.INITIATED);
        expense2.setPayBy(user1);
        expense2.setExpenseType(ExpenseType.GROUP);
        expense2.setAmount(1000.0);

        Expense expense3=new Expense(3,"Gift","Gift distribution", SplitType.EQUAL, ExpenseStatus.INITIATED);
        expense3.setPayBy(user2);
        expense3.setExpenseType(ExpenseType.GROUP);
        expense3.setAmount(1000.0);

        System.out.println("Expense creation start...");
        sheet=expenseService.addExpenses(expense,List.of(user1,user2,user3));
        sheet=expenseService.addExpenses(expense2,List.of(user1,user2,user3));
        sheet=expenseService.addExpenses(expense3,List.of(user1,user2,user3));
       // display.show();

        System.out.println("Expense Settlement start...");
        sheet=settlement.settlementAmount(expense,user2,600);
        display.show();


    }
}
