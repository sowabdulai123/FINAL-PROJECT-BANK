//package com.peopleshores.bankSank.entities;
//
//import jakarta.persistence.*;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//@Entity
//public class Transaction implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(length = 100)
//    private String type;
//    @Column(name = "value2")
//    private double value;
//    private LocalDateTime localDateTime;
//    private Account account;
//
//    public Transaction() {}
//    public Transaction(Account account, double value, String type) {
//        this.account = account;
//        this.value = value;
//        this.type = type;
//    }
//
//    public Transaction(long id, String type, double value, LocalDateTime localDateTime, Account account) {
//        this.id = id;
//        this.type = type;
//        this.value = value;
//        this.localDateTime = localDateTime;
//        this.account = account;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public double getValue() {
//        return value;
//    }
//
//    public void setValue(double value) {
//        this.value = value;
//    }
//
//    public LocalDateTime getLocalDateTime() {
//        return localDateTime;
//    }
//
//    public void setLocalDateTime(LocalDateTime localDateTime) {
//        this.localDateTime = localDateTime;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    @Override
//    public String toString() {
//        return "Transaction{" +
//                "id=" + id +
//                ", type='" + type + '\'' +
//                ", value=" + value +
//                ", localDateTime=" + localDateTime +
//                ", account=" + account +
//                '}';
//    }
//}
