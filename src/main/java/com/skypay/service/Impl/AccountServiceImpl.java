package com.skypay.service.Impl;

import java.time.LocalDate;
import java.util.List;

import com.skypay.exception.customExceptions.InvalidDepositAmountException;
import com.skypay.model.Account;
import com.skypay.model.Transaction;
import com.skypay.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final Account account;
    
    public void deposit(int amount) throws InvalidDepositAmountException{
        validateDepositAmount(amount);
        try {
            int newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            this.addTransaction(new Transaction(LocalDate.now() , amount, newBalance));
        } catch (Exception e) {
            throw new InvalidDepositAmountException("Failed to process deposit: " + e.getMessage());
        }
    }

    private void validateDepositAmount(int amount) throws InvalidDepositAmountException {
        if (amount <= 0) {
            throw new InvalidDepositAmountException("Deposit amount must be positive. Provided: " + amount);
        }
    }

    public void withdraw(int amount){

    }

    public void printStatement(){

    }
    
    public void addTransaction(Transaction transaction){
            List<Transaction> transactions = account.getTransactions();
            transactions.add(transaction);
    }
}
