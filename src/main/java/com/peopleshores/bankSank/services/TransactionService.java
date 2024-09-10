package com.peopleshores.bankSank.services;

import com.peopleshores.bankSank.TransactionType;
import com.peopleshores.bankSank.entities.Account;
import com.peopleshores.bankSank.entities.TransactionRecord;
import com.peopleshores.bankSank.repos.AccountRepository;
import com.peopleshores.bankSank.repos.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public interface TransactionService {
    void debitAccount(double amount, Long id);

    void creditAccount(double amount, Long id);

    void transferMoney(double amount, Long thisId, Long otherId);

    List<TransactionRecord> getTransactionsByAccountId(Long accountId);
}
