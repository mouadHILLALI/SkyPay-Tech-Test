package com.skypay.controller;

import java.util.Scanner;

import com.skypay.service.AccountService;
import com.skypay.exception.customExceptions.*;


public class AccountController {
    private final AccountService accountService;
    private final Scanner scanner;

    public AccountController(AccountService accountService , Scanner scanner){
        this.accountService = accountService;
        this.scanner = scanner;
    }

    public void startMenu() {
        while (true) {
            System.out.println("\n==== Account Menu ====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Print Statement");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    accountService.printStatement();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public void deposit() {
        try {
            System.out.print("Enter the amount you wish to deposit: ");
            int amount = scanner.nextInt();
            accountService.deposit(amount);
            System.out.println("The amount " + amount + " was deposited successfully.");
        } catch (InvalidDepositAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.nextLine(); 
        }
    }

    public void withdraw() {
        try {
            System.out.print("Enter the amount you wish to withdraw: ");
            int amount = scanner.nextInt();
            accountService.withdraw(amount);
            System.out.println("The amount " + amount + " was withdrawn successfully.");
        } catch (InvalidWithdrawAmountException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.nextLine();
        }
    }
}
