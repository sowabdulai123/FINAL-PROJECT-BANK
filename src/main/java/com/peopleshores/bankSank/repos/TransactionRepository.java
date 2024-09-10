package com.peopleshores.bankSank.repos;

import com.peopleshores.bankSank.TransactionType;
import com.peopleshores.bankSank.entities.Account;
import com.peopleshores.bankSank.entities.TransactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionRecord, Long> {
    TransactionRecord getTransactionRecordById(Long id);
    TransactionRecord getTransactionRecordByType(TransactionType type);
    //TransactionRecord getTransactionRecordAmount(double amount);
    TransactionRecord getTransactionRecordByLocalDateTime(LocalDateTime localDateTime);
    List<TransactionRecord> getTransactionRecordsByFromAccount(Account account);
}
