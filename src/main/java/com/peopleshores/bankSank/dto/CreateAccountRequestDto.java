package com.peopleshores.bankSank.dto;

public record CreateAccountRequestDto(Long customerId,
                                      String accountName,
                                      double openingBalance) {

}