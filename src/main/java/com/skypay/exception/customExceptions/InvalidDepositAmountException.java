package com.skypay.exception.customExceptions;

public class InvalidDepositAmountException extends RuntimeException {
    public InvalidDepositAmountException(String message){
        super(message);
    }
}
