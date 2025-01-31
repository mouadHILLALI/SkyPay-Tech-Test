package com.skypay.exception.customExceptions;

public class InvalidWithdrawAmountException extends RuntimeException {
    public InvalidWithdrawAmountException(String message){
        super(message);
    }
}
