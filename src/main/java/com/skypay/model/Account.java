package com.skypay.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Account {
    private int balance;
    private List<Transaction> transactions = new ArrayList<>();
}
