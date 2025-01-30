package com.skypay.dto.error;

import java.security.Timestamp;

public record InvalidDepositDto(Timestamp timestamp , String message) {
} 
