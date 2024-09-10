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
public class TransactionServices implements TransactionService {
    Random random = new Random();

    // can be final
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    public void debitAccount(double amount, Long id) {
        Account account = accountRepository.getReferenceById(id);
        if ((account.getBalance() - amount) >= -50) { //>= (50.0+amount)){
            account.setBalance(account.getBalance() - amount);
            new TransactionRecord(random.nextLong(100000, 999999),
                    TransactionType.DEPOSIT,
                    amount, LocalDateTime.now(), account, null);
        } else {
            throw new RuntimeException("Insufficient Funds.");
        }
    }

    public void creditAccount(double amount, Long id) {
        Account account = accountRepository.getReferenceById(id);
        account.setBalance(account.getBalance() + amount);
        new TransactionRecord(random.nextLong(100000, 999999), TransactionType.WITHDRAW,
                amount, LocalDateTime.now(), account, null);
    }

    public void transferMoney(double amount, Long thisId, Long otherId) {

        this.debitAccount(amount, thisId);
        this.creditAccount(amount, otherId);
        new TransactionRecord(random.nextLong(100000, 999999), TransactionType.TRANSFER,
                amount, LocalDateTime.now(), accountRepository.getReferenceById(thisId),accountRepository.getReferenceById(otherId).getNumber());

    }

//    public List<TransactionRecord> getTransactionsByAccount(Account account) {
//        return transactionRepository.getTransactionRecordsByAccount(account);
//
//    }
    public List<TransactionRecord> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.getTransactionRecordsByFromAccount(accountRepository.getReferenceById(accountId));

    }
    public TransactionRecord getTransactionById(Long accountId) {
        return transactionRepository.getTransactionRecordById(accountId);

    }

}
