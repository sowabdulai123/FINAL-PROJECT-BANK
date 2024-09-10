package com.peopleshores.bankSank.services;

import com.peopleshores.bankSank.entities.Account;
import com.peopleshores.bankSank.entities.Customer;

import java.util.List;

public interface AccountService {
    public Account createAccount(String name, double balance, Customer customer);

    public void updateAccountName(Long id, String name);

    public void updateBalance(Long id, double balance);

    public Account getAccount(Long id);

    public void deleteAccount(Long id);

    public List<Long> getAccountsByCustomer(Long customerId);

    public List<Account> getAccountsWithNoTransactionsByCustomer(Long customerId);
}
