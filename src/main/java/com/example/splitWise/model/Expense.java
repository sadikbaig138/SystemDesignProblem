package com.example.splitWise.model;

import com.example.parkingLot.enumType.Status;
import com.example.splitWise.enums.ExpenseStatus;
import com.example.splitWise.enums.ExpenseType;
import com.example.splitWise.enums.SplitType;

import java.util.List;
import java.util.Set;

public class Expense {
    private Integer id;
    private String expenseName;
    private String description;
    private SplitType splitType;
    private ExpenseStatus status;
    private List<Split> splitUsers;
    private User payBy;
    private double amount;
    private ExpenseType expenseType;


    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }

    public List<Split> getSplitUsers() {
        return splitUsers;
    }

    public void setSplitUsers(List<Split> splitUsers) {
        this.splitUsers = splitUsers;
    }

    public User getPayBy() {
        return payBy;
    }

    public void setPayBy(User payBy) {
        this.payBy = payBy;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }


    public Double getAmount() {
        return amount;
    }

    public Expense(Integer id, String expenseName, String description, SplitType type, ExpenseStatus status) {
        this.id = id;
        this.expenseName = expenseName;
        this.description = description;
        this.splitType = type;
        this.status = status;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public ExpenseStatus getStatus() {
        return status;
    }

    public void setStatus(ExpenseStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
