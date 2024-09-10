package com.peopleshores.bankSank.services;

import com.peopleshores.bankSank.dto.GetCustomerResponseDto;

public interface CustomerService {
    public GetCustomerResponseDto getCustomerById(int id);
}
