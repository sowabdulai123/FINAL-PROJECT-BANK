package com.peopleshores.bankSank.dto;

import com.peopleshores.bankSank.entities.Customer;

import java.util.List;

public class GetAllCustomerResponseDto {
    private List<Customer> allCustomers;

    public GetAllCustomerResponseDto(List<Customer> allCustomers) {
        this.allCustomers = allCustomers;
    }

    public List<Customer> getAllCustomers() {
        return allCustomers;
    }

    public void setAllCustomers(List<Customer> allCustomers) {
        this.allCustomers = allCustomers;
    }
}
