package com.skypay.controller;

import java.util.Scanner;

import com.skypay.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountController {
 private final AccountService accountService;
 private final Scanner scanner;

 public void deposit(){
    System.out.println("Enter the amount you wish to deposit:\n");
    int amount = scanner.nextInt();
    accountService.deposit(amount);
    System.out.println("the amount was deposited "+amount+ " successfully:\n");
 }
}
