package com.peopleshores.bankSank.dto;

import com.peopleshores.bankSank.TransactionType;
import com.peopleshores.bankSank.entities.Account;

import java.time.LocalDateTime;

public record GetTransactionResponseDto(
        LocalDateTime localDateTime,
        TransactionType type,
        Account fromAccount,
        Long fromAccountSortCode,
        Account toAccount,
        Long toAccountSortCode,
        double amount) {
}

/*
This is the specification of what we need when we are depositing, withdrawing,
and transfering funds using the ui.
The type which is Deposit in this case uses the datatype of Long because that
is the Structure of the image that they gave to us if we use the network console
after inspecting the page and seeing the changes. It has 3 modes which would mean
we only have 0,1,2 to work with unless we want to add more features later down the
road.
POST /transaction
{
    "type": "DEPOSIT",
    "fromAccount": null,
    "fromAccountSortCode": null,
    "toAccount": 123456789,
    "toAccountSortCode": 1234,
    "amount": 10.00
}
 */