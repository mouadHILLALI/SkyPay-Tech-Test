package com.skypay.model;

import java.time.LocalDate;


public class Transaction {
    private  LocalDate date;
    private  int amount;
    private  int newBalance;

    public Transaction(LocalDate date , int amount , int newBalance){
            this.date = date;
            this.amount = amount;
            this.newBalance = newBalance;
        }


        public LocalDate getDate() {
            return date;
        }

        public int getAmount() {
            return amount;
        }

        public int getNewBalance() {
            return newBalance;
        }
        public void setDate(LocalDate date) {
            this.date = date;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public void setNewBalance(int newBalance) {
            this.newBalance = newBalance;
        }

}
