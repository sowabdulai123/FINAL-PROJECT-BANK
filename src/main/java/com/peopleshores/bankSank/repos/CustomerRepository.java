package com.peopleshores.bankSank.repos;

import com.peopleshores.bankSank.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer getCustomerById(Long id);
    Customer getCustomerByFullName(String fullName);
}
