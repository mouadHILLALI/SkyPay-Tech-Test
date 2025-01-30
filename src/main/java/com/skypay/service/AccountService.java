package com.skypay.service;


import com.skypay.model.Transaction;

public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
    void addTransaction(Transaction transaction);
}
