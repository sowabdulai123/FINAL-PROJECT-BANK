package com.peopleshores.bankSank.controllers;


import com.peopleshores.bankSank.TransactionType;
import com.peopleshores.bankSank.dto.GetTransactionResponseDto;
import com.peopleshores.bankSank.entities.Account;
import com.peopleshores.bankSank.entities.TransactionRecord;
import com.peopleshores.bankSank.services.AccountServices;
import com.peopleshores.bankSank.services.CustomerServices;
import com.peopleshores.bankSank.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class TransactionControllers {

    @Autowired
    private AccountServices accountServices;
    @Autowired
    private CustomerServices customerServices;
    @Autowired
    private TransactionServices transactionServices;


    @RequestMapping("/sortCode")
    @GetMapping()
    public Long getFromAccountSortCode() {
        return 7265L;
    }

    @RequestMapping("/transaction")
    @GetMapping("/")
    public List<GetTransactionResponseDto> getTransactionsByAccountNumber(@RequestParam Long accountNumber) {
        // get Mapping for transaction by Account Number which is the Account Table PK.
        List<TransactionRecord> listOfTransactions = transactionServices.getTransactionsByAccountId(accountNumber);

        List<GetTransactionResponseDto> listOfTransactionsDtos = new ArrayList<>();

        for (TransactionRecord t : listOfTransactions) {
            listOfTransactionsDtos.add(new GetTransactionResponseDto(
                    LocalDateTime.now(),
                    t.type(),
                    t.fromAccount(),
                    t.fromAccount().getSortCode(),
                    accountServices.getAccount(t.to_account_number()),
                    accountServices.getAccount(t.to_account_number()).getSortCode(),
                    t.amount())
            );
        }
        return listOfTransactionsDtos;

    }
}
