//package com.peopleshores.bankSank.dto;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public record CreateCustomerResponseDto(
//        Long id,
//        String fullName,
//        List<GetAccountResponseDto> accounts
//) {}
//
//// Transforming into a record
////public class CreateCustomerResponseDto {
////    private Long id;
////    private String fullName;
////    private List<GetAccountResponseDto> accounts;
////
////    public CreateCustomerResponseDto(Long id, String fullName, List<GetAccountResponseDto> accounts) {
////        this.id = id;
////        this.fullName = fullName;
////        this.accounts = accounts;
////    }
////
////    public Long getId() {
////        return id;
////    }
////
////    public void setId(Long id) {
////        this.id = id;
////    }
////
////    public String getFullName() {
////        return fullName;
////    }
////
////    public void setFullName(String fullName) {
////        this.fullName = fullName;
////    }
////
////    public List<GetAccountResponseDto> getAccounts() {
////        return accounts;
////    }
////
////    public void setAccounts(List<GetAccountResponseDto> accounts) {
////        this.accounts = accounts;
////    }
////}
