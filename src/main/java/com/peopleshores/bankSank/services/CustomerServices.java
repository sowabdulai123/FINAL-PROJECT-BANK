package com.peopleshores.bankSank.services;

import com.peopleshores.bankSank.entities.Account;
import com.peopleshores.bankSank.entities.Customer;
import com.peopleshores.bankSank.repos.AccountRepository;
import com.peopleshores.bankSank.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Customer createCustomer(String fullName){
        return customerRepository.save(new Customer(fullName));
    }
    public void updateCustomerFullName(Long id, String fullName) throws Exception{
        customerRepository.getReferenceById(id).setFullName(fullName);
    }

    public Customer getCustomer(Long id){
        return customerRepository.getReferenceById(id);
    }

    // Might need in the future with the UI
    public Customer getCustomer(String fullName){
        return customerRepository.getCustomerByFullName(fullName);
    }

    public List<Account> getAccountsOfCustomer(Long custId){
        Customer customer = customerRepository.getCustomerById(custId);
        return accountRepository.getAccountsByCustomer(customer);
    }
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    // account services deletes account, takes outstanding balance and adds to the customer's cash in hand.
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

}
