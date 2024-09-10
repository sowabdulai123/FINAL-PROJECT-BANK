package com.peopleshores.bankSank.repos;

import com.peopleshores.bankSank.entities.Account;
import com.peopleshores.bankSank.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account getAccountBySortCode(int sortCode);
    Account getAccountByNumber(int number);
    List<Account> getAccountsByCustomer(Customer customer);
    Account getAccountByName(String name);
    List<Account> getAccountsByBalance(double balance);
}
