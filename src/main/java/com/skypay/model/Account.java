package com.skypay.model;

import java.util.ArrayList;
import java.util.List;


public class Account {
    private int balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(int balance , List<Transaction> transactions){
        this.balance = balance;
        this.transactions = transactions;
    }
    public Account(){}

    public int getBalance(){
        return this.balance;
    }

    public List<Transaction> getTransactions(){
        return this.transactions;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public void setTransactions(List<Transaction> transactions){
        this.transactions = transactions;
    }
}
