package com.skypay.service.Impl;

import java.time.LocalDate;
import java.util.List;

import com.skypay.model.Account;
import com.skypay.model.Transaction;
import com.skypay.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final Account account;
    
    public void deposit(int amount){
        try {
            int newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            account.setTransactions(this.addTransactions(new Transaction(LocalDate.now() , amount)));
        } catch (Exception e) {
            
        }
    }

    public void withdraw(int amount){

    }

    public void printStatement(){

    }
    
    public List<Transaction> addTransactions(Transaction transaction){
            List<Transaction> transactions = account.getTransactions().add(transaction);
            return transactions;
    }
}
