package com.skypay.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Transaction {
    private final LocalDate date;
    private final int amount;
}
