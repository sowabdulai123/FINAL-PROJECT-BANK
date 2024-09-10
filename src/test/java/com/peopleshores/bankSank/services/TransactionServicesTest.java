package com.peopleshores.bankSank.services;

import com.peopleshores.bankSank.entities.Account;
import com.peopleshores.bankSank.entities.Customer;
import com.peopleshores.bankSank.repos.AccountRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransactionServicesTest {
    Account account1, account2, account3, account4, account5;

    @Mock
    private static AccountRepository accountRepository;

    @InjectMocks
    private TransactionServices transactionServices;

    @BeforeEach
    void setUp() throws Exception {

        account1 = new Account(1L, 9L, "Account 1", 500.00, new Customer("Nasiba Paroma"));
        account2 = new Account(2L,8L,"Account 2", 0.00, new Customer("Nasiba Paroma"));
        account3 = new Account(3L,7L,"Account 3", 100.00, new Customer("Nasiba Paroma"));
        account4 = new Account(4L, 6L, "Account 4", 0.00, new Customer("Nasiba Paroma"));
        account5 = new Account(5L, 5L, "Account 5", 200.00, new Customer("Nasiba Paroma"));
        when(accountRepository.getReferenceById(1L)).thenReturn(account1);
        when(accountRepository.getReferenceById(2L)).thenReturn(account2);
        when(accountRepository.getReferenceById(3L)).thenReturn(account3);
        when(accountRepository.getReferenceById(4L)).thenReturn(account4);
        when(accountRepository.getReferenceById(5L)).thenReturn(account5);

    }

    @Test
    void debit100fromAccount1_setsBalanceTo400() throws Exception {
        transactionServices.debitAccount(100, account1.getNumber());
        assertEquals(400.00, account1.getBalance());
    }
    @Test
    void debit100fromAccount2_throwsException(){
        assertThrows(Exception.class, () -> {
            transactionServices.debitAccount(100, account2.getNumber());
        });
    }
    @Test
    void debit100fromAccount3_setsBalanceTo0() throws Exception {
        transactionServices.debitAccount(100, account3.getNumber());
        assertEquals(0.00, account3.getBalance());
    }
    @Test
    void debit0fromAccount4_setsBalanceTo0() throws Exception {
        transactionServices.debitAccount(0.0, account4.getNumber());
        assertEquals(0.00, account4.getBalance());
    }
    @Test
    void debit0fromAccount5_setsBalanceTo200() throws Exception {
        transactionServices.debitAccount(0.0, account5.getNumber());
        assertEquals(200.00, account5.getBalance());
    }

    @Test
    void credit100toAccount1_setsBalanceTo600() throws Exception {
        transactionServices.creditAccount(100, account1.getNumber());
        assertEquals(600.00, account1.getBalance());
    }

    @Test
    void credit50toOverdraftedAccount2_setsBalanceTo20() throws Exception {
        transactionServices.debitAccount(30.0, account2.getNumber());
        transactionServices.creditAccount(50.0, account2.getNumber());
        assertEquals(20.00, account2.getBalance());
    }

    @Test
    void credit100afterDebit100toAccount3_setsBalanceTo100() throws Exception {
        transactionServices.debitAccount(100, account3.getNumber());
        transactionServices.creditAccount(100, account3.getNumber());
        assertEquals(100.00, account3.getBalance());
    }

    @Test
    void credit300toAccount4_setsBalanceTo300() throws Exception {
        transactionServices.creditAccount(300, account4.getNumber());
        assertEquals(300.00, account4.getBalance());
    }

    @Test
    void credit50afterDebit250toAccount5_setsBalanceTo0() throws Exception {
        transactionServices.debitAccount(250, account5.getNumber());
        transactionServices.creditAccount(50, account5.getNumber());
        assertEquals(0.00, account5.getBalance());
    }

    @Test
    void transfer200fromAccount1toAccount2_successfulTransfer() throws Exception {
        transactionServices.transferMoney(200, 1L, 2L);
        assertEquals(300.00, account1.getBalance());
        assertEquals(200.00, account2.getBalance());
    }
    @Test
    void transfer500fromAccount2toAccount3_overdraftsAccount2() throws Exception {
        transactionServices.transferMoney(50, 2L, 3L);
        assertEquals(-50.00, account2.getBalance());
        assertEquals(150.00, account3.getBalance());
    }
    @Test
    void transfer100fromAccount3toAccount4_setsAccount3balanceTo0() throws Exception {
        transactionServices.transferMoney(100, 3L, 4L);
        assertEquals(0.00, account3.getBalance());
        assertEquals(100.00, account4.getBalance());
    }
    @Test
    void transfer200fromAccount4toAccount5_declinedTransfer() {
        assertThrows(Exception.class, () -> {
           transactionServices.transferMoney(200, 4L, 5L);
        });
        assertEquals(0.00, account4.getBalance());
        assertEquals(200.00, account5.getBalance());

    }

}











