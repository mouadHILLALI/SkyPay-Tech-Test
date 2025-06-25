package com.skypay.service.Impl;

import java.time.LocalDate;
import java.util.List;


import com.skypay.exception.customExceptions.InvalidDepositAmountException;
import com.skypay.exception.customExceptions.InvalidWithdrawAmountException;
import com.skypay.exception.customExceptions.InsufficientBalanceException;
import com.skypay.model.Account;
import com.skypay.model.Transaction;
import com.skypay.service.AccountService;


public class AccountServiceImpl implements AccountService {

    private Account account;
    
    public AccountServiceImpl(Account account){
        this.account = account;
    }
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

    private void validateWithdrawAmount(int amount) throws InvalidWithdrawAmountException {
        if (amount <= 0) {
            throw new InvalidWithdrawAmountException("Deposit amount must be positive. Provided: " + amount);
        }
    }
    
    public void withdraw(int amount) throws InvalidWithdrawAmountException, InsufficientBalanceException{
        validateWithdrawAmount(amount);
        if (amount>account.getBalance()) {
            throw new InsufficientBalanceException("Insufficient Balance, Current Balance: " + account.getBalance());
        }
        int newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        addTransaction(new Transaction(LocalDate.now(), -amount, newBalance));
    }

    public void printStatement() {
        StringBuilder statement = new StringBuilder();
    
        statement.append("Date || Amount || Balance\n");
    
        for (Transaction transaction : account.getTransactions()) {
            statement.append(transaction.getDate())
                    .append(" || ")
                    .append(transaction.getAmount())
                    .append(" || ")
                    .append(transaction.getNewBalance())
                    .append("\n");
        }
    
        System.out.println(statement.toString());
    }
    
    public void addTransaction(Transaction transaction){
            List<Transaction> transactions = account.getTransactions();
            transactions.add(transaction);
    }
}
