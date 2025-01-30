package com.skypay.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Transaction {
    private int amount;
    private LocalDate date;
}
