package com.skypay.controller;

import java.util.Scanner;

import com.skypay.dto.request.DepositReqDto;
import com.skypay.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountController {
 private final AccountService accountService;
 private final Scanner scanner;

 public void deposit(){
    System.out.println("Enter the amount you wish to deposit:\n");
    int amount = scanner.nextLine();
    accountService.deposit(amount);
 }
}
