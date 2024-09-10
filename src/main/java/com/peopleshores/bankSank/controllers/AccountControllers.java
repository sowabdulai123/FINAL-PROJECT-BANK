package com.peopleshores.bankSank.controllers;

import com.peopleshores.bankSank.TransactionType;
import com.peopleshores.bankSank.dto.*;
import com.peopleshores.bankSank.entities.Account;
import com.peopleshores.bankSank.entities.Customer;
import com.peopleshores.bankSank.services.AccountServices;
import com.peopleshores.bankSank.services.CustomerServices;
import com.peopleshores.bankSank.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountControllers {

    @Autowired
    private TransactionServices transactionServices;

    @Autowired
    private CustomerServices customerServices;

    @Autowired
    private AccountServices accountServices;

    @GetMapping("/{id}")
    public GetAccountResponseDto getAccount(@PathVariable Long id) {
        //get mapping for one account by account number(is the PRIMARY KEY/ID)
        Account account = accountServices.getAccount(id);
        return new GetAccountResponseDto(
                account.getNumber(),
                account.getSortCode(),
                account.getName(),
                account.getOpeningBalance(),
                transactionServices.getTransactionsByAccountId(id),
                account.getBalance(),
                account.getCustomer().getId());
    }

    /*
    Need to start working on the account controllers now. Check the UI to see if it is working
     */
//
    @PostMapping
    public CreateAccountResponseDto createAccount(@RequestBody CreateAccountRequestDto request) {
        Account account = accountServices.createAccount(
                request.accountName(),
                request.openingBalance(),
                request.customerId());

        return new CreateAccountResponseDto(
                account.getNumber(),
                account.getSortCode(),
                request.accountName(),
                request.openingBalance(),
                List.of(),
                account.getBalance(),
                request.customerId()
        );

    }
//
//    @DeleteMapping("/{id}")
//    public DeleteAccountResponseDto deleteAccount(DeleteAccountResponseDto request) {
//        return new DeleteAccountResponseDto(
//                request.balance()
//        );
//    }

    //get mapping for one account by account name(return list of accounts)

}
