package com.peopleshores.bankSank.dto;

import com.peopleshores.bankSank.TransactionType;

import java.time.LocalDateTime;

public record CreateTransactionDto(double amount, LocalDateTime time, Long fromAccount,
                                   Long fromAccountSortCode, Long toAccount, Long toAccountSortCode, TransactionType type) {
}
