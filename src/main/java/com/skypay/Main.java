package com.skypay;

import java.util.Scanner;

import com.skypay.controller.AccountController;
import com.skypay.model.Account;
import com.skypay.service.AccountService;
import com.skypay.service.Impl.AccountServiceImpl;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account(); 
        AccountService accountService = new AccountServiceImpl(account); 
        new AccountController(accountService , scanner).deposit();
    }
}