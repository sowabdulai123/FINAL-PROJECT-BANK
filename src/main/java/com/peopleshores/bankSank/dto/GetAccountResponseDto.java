package com.peopleshores.bankSank.dto;

import com.peopleshores.bankSank.entities.Account;
import com.peopleshores.bankSank.entities.Customer;
import com.peopleshores.bankSank.entities.TransactionRecord;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;


public record GetAccountResponseDto(
        Long number,
        Long sortCode,
        String name,
        double openingBalance,
        List<TransactionRecord> allTransactions,
        double balance,
        Long customerId

) {
    public static GetAccountResponseDto fromAccount(Account account, List<TransactionRecord> transactions) {
        return new GetAccountResponseDto(account.getNumber(), account.getSortCode(), account.getName(),
                account.getOpeningBalance(), transactions,
                account.getBalance(), account.getCustomer().getId());
    }

}
