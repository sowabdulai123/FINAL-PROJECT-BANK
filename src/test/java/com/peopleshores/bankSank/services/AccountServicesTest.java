

package com.peopleshores.bankSank.services;

import com.peopleshores.bankSank.entities.Account;
import com.peopleshores.bankSank.entities.Customer;
import com.peopleshores.bankSank.repos.AccountRepository;
import com.peopleshores.bankSank.repos.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest
class AccountServicesTest {

    Customer client;
    Account account, account1, account2;

    @Mock
    private static AccountRepository accountRepository;

    @InjectMocks
    private AccountServices accountServices;

    @BeforeEach
    void setUp() throws Exception {
        client = new Customer(1L, "John", 0.00);
        account = new Account("Retirement", -20, client);
        account1 = new Account("Checking", 20, client);
        account2 = new Account("Savings", 0, client);

        when(accountRepository.getReferenceById(0L)).thenReturn(account);
        when(accountRepository.getReferenceById(1L)).thenReturn(account1);
        when(accountRepository.getReferenceById(2L)).thenReturn(account2);
    }

    @Test
    void testCreateAccount() throws Exception {
        accountServices.createAccount("Retirement", -20, client);
        assertNotNull(accountRepository.getReferenceById(1L));
    }

    @Test
    void testUpdateAccountName() {
        accountServices.updateAccountName(1L, "Checking");
        assertEquals("Checking", accountRepository.getReferenceById(1L).getName());
    }

    @Test
    void testUpdateBalance() throws Exception {
        accountServices.updateBalance(1L, 50.00);
        assertEquals(50.00, accountRepository.getReferenceById(1L).getBalance());
    }

    @Test
    void testGetAccount() throws Exception {
        Account account = new Account("Checking", 20.00, client);
        assertEquals("Checking", account.getName());
    }

    @Test
    void testDeleteAccount() throws Exception {
        accountServices.deleteAccount(1L);
        assertFalse(accountRepository.existsById(1L));
    }

    @Test
    void testDeleteOverdraftAccount() throws Exception {
        assertThrows(Exception.class, () -> {
            accountServices.deleteAccount(0L);
        });
    }

    @Test
    void testDeletePositiveAccount() throws Exception {
        Customer customer = account1.getCustomer();
        accountServices.deleteAccount(1L);
        double newCashInHand = customer.getCashInHand();
        assertEquals(20.0, newCashInHand);
    }

    @Test
    void testDeleteZeroBalanceAccount() throws Exception {
        Customer customer = account2.getCustomer();
        accountServices.deleteAccount(2L);
        double newCashInHand = customer.getCashInHand();
        assertEquals(0.0, newCashInHand);
    }
}


