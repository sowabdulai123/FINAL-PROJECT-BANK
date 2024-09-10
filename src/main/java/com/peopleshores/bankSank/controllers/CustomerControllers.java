package com.peopleshores.bankSank.controllers;

import com.peopleshores.bankSank.dto.*;
import com.peopleshores.bankSank.entities.Account;
import com.peopleshores.bankSank.entities.Customer;
import com.peopleshores.bankSank.services.AccountServices;
import com.peopleshores.bankSank.services.CustomerService;
import com.peopleshores.bankSank.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerControllers {

    @Autowired
    private CustomerServices customerServices;

    @Autowired
    private AccountServices accountServices;

    @GetMapping("/{id}")
    public GetCustomerResponseDto getCustomer(@PathVariable Long id) throws Exception {
//        return new GetCustomerResponseDto(1, "Richard Mackriell", List.of(0));
        Customer customer = customerServices.getCustomer(id);
        List<Long> accountsOfCustomer = accountServices.getAccountsByCustomer(id);
        if (customer == null){
            throw new Exception("Customer not found.");
        } else {
            return new GetCustomerResponseDto(id, customer.getFullName(), accountsOfCustomer);
        }
    }



//    @GetMapping()
//    public GetAllCustomerResponseDto getAllCustomers() throws Exception{
////        return new GetCustomerResponseDto(1, "Richard Mackriell", List.of(0));
//
//        List<Customer> customers = customerServices.getAllCustomers();
//        if (customers.isEmpty()){
//            throw new Exception("No Customer found.");
//        } else {
//            return new GetAllCustomerResponseDto(customers);
//        }
//    }

    @PostMapping
    public GetCustomerResponseDto creatingCustomer(@RequestBody String fullName){
        Customer customer = customerServices.createCustomer(fullName);
        return new GetCustomerResponseDto(
                customer.getId(),
                customer.getFullName(),
                accountServices.getAccountsByCustomer(customer.getId())
        );

    }


}



