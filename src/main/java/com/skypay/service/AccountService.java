package com.skypay.service;

import java.util.List;

import com.skypay.model.Transaction;

public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
    List<Transaction> addTransaction(Transaction transaction);
}
