package com.peopleshores.bankSank.entities;

import com.peopleshores.bankSank.TransactionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class TransactionRecordTest {

    TransactionRecord record1;
    TransactionRecord record2;
    TransactionRecord record3;
    TransactionRecord record4;
    TransactionRecord record5;
    TransactionRecord record6;

    @BeforeEach
    void setup() {
        long id = 123L;
        double amount = 100.0;
        LocalDateTime dateTime = LocalDateTime.of(2024, 8, 26, 11, 40);
        Account account = new Account();

        record1 = new TransactionRecord(id, TransactionType.DEPOSIT, amount, dateTime, account);

        record2 = new TransactionRecord(456L, TransactionType.WITHDRAW, 50.00, dateTime, new Account());
        record3 = new TransactionRecord(999L, TransactionType.WITHDRAW, 0.00, dateTime, new Account());
        record4 = new TransactionRecord(147L, TransactionType.TRANSFER, 150.00, dateTime, new Account());
        record5 = new TransactionRecord(789L, TransactionType.DEPOSIT, 90.00, dateTime, new Account());
        record6 = new TransactionRecord(963L, TransactionType.WITHDRAW, 30.00, dateTime, new Account());
    }

    @Test
    void testTransactionRecordCreation() {
        assertNotNull(record1);
        assertNotNull(record2);
        assertNotNull(record3);
        assertNotNull(record4);
        assertNotNull(record5);
        assertNotNull(record6);
    }

    @Test
    void idGetsAssigned() {
        assertEquals(123L, record1.id());
        assertEquals(456L, record2.id());
        assertEquals(999L, record3.id());
        assertEquals(147L, record4.id());
        assertEquals(789L, record5.id());
        assertEquals(963L, record6.id());
    }

    @Test
    void type() {
        assertEquals(TransactionType.DEPOSIT, record1.type());
        assertEquals(TransactionType.WITHDRAW, record2.type());
        assertEquals(TransactionType.WITHDRAW, record3.type());
        assertEquals(TransactionType.TRANSFER, record4.type());
        assertEquals(TransactionType.DEPOSIT, record5.type());
        assertEquals(TransactionType.WITHDRAW, record6.type());
    }

    @Test
    void value() {
        assertEquals(100.0, record1.amount());
        assertEquals(50.0, record2.amount());
        assertEquals(0.0, record3.amount());
        assertEquals(150.0, record4.amount());
        assertEquals(90.0, record5.amount());
        assertEquals(30.0, record6.amount());
    }

    @Test
    void localDateTime() {
        assertEquals(LocalDateTime.of(2024, 8, 26, 11, 40), record1.localDateTime());
        assertEquals(LocalDateTime.of(2024, 8, 26, 11, 40), record2.localDateTime());
        assertEquals(LocalDateTime.of(2024, 8, 26, 11, 40), record3.localDateTime());
        assertEquals(LocalDateTime.of(2024, 8, 26, 11, 40), record4.localDateTime());
        assertEquals(LocalDateTime.of(2024, 8, 26, 11, 40), record5.localDateTime());
        assertEquals(LocalDateTime.of(2024, 8, 26, 11, 40), record6.localDateTime());
    }

    @Test
    void account() {
        assertEquals(new Account(), record1.account());
        assertEquals(new Account(), record2.account());
        assertEquals(new Account(), record3.account());
        assertEquals(new Account(), record4.account());
        assertEquals(new Account(), record5.account());
        assertEquals(new Account(), record6.account());
    }
}