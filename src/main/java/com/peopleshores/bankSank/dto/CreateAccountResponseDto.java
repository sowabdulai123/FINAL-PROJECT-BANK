package com.peopleshores.bankSank.dto;

import java.util.ArrayList;
import java.util.List;

public record CreateAccountResponseDto(Long number,
                                       Long sortCode,
                                       String name,
                                       double openingBalance,
                                       List<GetTransactionResponseDto> transactions,
                                       double balance,
                                       Long customerId) {
    public CreateAccountResponseDto(Long number, Long sortCode, String name, double openingBalance, List<GetTransactionResponseDto> transactions, double balance, Long customerId) {
        this.number = number;
        this.sortCode = 7265L;
        this.name = name;
        this.openingBalance = openingBalance;
        this.transactions = new ArrayList<>();
        this.balance = openingBalance;
        this.customerId = customerId;
    }
}
