package com.peopleshores.bankSank.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Customer client;
    Account account;

    @BeforeEach
    void setUp() throws Exception {
        client = new Customer("John");//creating a customer object
        account = new Account("Checking", 50, client);
    }

    @Test
    void testAccountCreation() {
        assertNotNull(account);
    }

    @Test
    void setAccountName() {
        account.setName("Savings");
        assertEquals("Savings", account.getName());
    }
    @Test
    void setNumber() {
        account.setNumber(001);
        assertEquals( 001, account.getNumber());
    }
    @Test
    void setSortCode() {
        account.setSortCode(000);
        assertEquals(000, account.getSortCode());
    }
    @Test
    void setBalance() throws Exception {
        account.setBalance(100);
        assertEquals(100, account.getBalance());
    }
    //???
    @Test
    void setBalanceToOverNegative50() throws Exception {
        assertThrows(Exception.class, () -> {
            account.setBalance(-51);
        });


//        assertEquals(50, account.getBalance());
    }


}