package com.peopleshores.bankSank.services;

import com.peopleshores.bankSank.entities.Account;
import com.peopleshores.bankSank.entities.Customer;
import com.peopleshores.bankSank.repos.AccountRepository;
import com.peopleshores.bankSank.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


// Mock beans rely on interfaces
@Service
public class AccountServices implements AccountService{

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TransactionServices transactionServices;

    public AccountServices() {
    }

    @Override
    public Account createAccount(String name, double balance, Customer customer){
        return accountRepository.save(new Account(name, balance, customer));
    }
    public Account createAccount(String name, double balance, Long customerId){
        Account save = accountRepository.save(new Account(name, balance, customerRepository.getCustomerById(customerId)));

        return save;
    }

    @Override
    public void updateAccountName(Long id, String name) {
        accountRepository.getReferenceById(id).setName(name);
    }

    @Override
    public void updateBalance(Long id, double balance){
        accountRepository.getReferenceById(id).setBalance(balance);
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.getReferenceById(id);
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.getReferenceById(id);
        if (account.getBalance() < 0.00) {
            throw new RuntimeException("Overdrafted Account, unable to close.");
        } else {
            Customer customer = account.getCustomer();
            accountRepository.deleteById(id);
        }

    }

    @Override
    public List<Long> getAccountsByCustomer(Long customerId) {
        Customer customer = customerRepository.getCustomerById(customerId);
        List<Account> accounts = accountRepository.getAccountsByCustomer(customer);
        return accounts.stream().map(Account::getNumber).toList();

//        return accounts
//                .stream()
//                .map(e -> GetAccountResponseDto.fromAccount(e, transactionServices.getTransactionsByAccount(e)))
//                .toList();
    }

    @Override
    public List<Account> getAccountsWithNoTransactionsByCustomer(Long customerId) {
        Customer customer = customerRepository.getCustomerById(customerId);
        List<Account> accounts = accountRepository.getAccountsByCustomer(customer);
        List<Account> accountsWithNoTransaction = new ArrayList<>();



        return List.of();
    }


}
