package com.peopleshores.bankSank.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GeneratedColumn;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Account implements Serializable {



//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//    @Column(insertable =false, unique = true)
//@ColumnDefault
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    @Column(insertable =false)
    private Long sortCode;
    private String name ;
    private double openingBalance;
    private double balance;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account(){}

    public Account(Long number, Long sortCode, String name, double balance, Customer customer)  {
//        this.id = id;
        this.number = number;
        this.sortCode = sortCode;
        this.name = name;
        this.balance = balance;
        this.openingBalance = balance;
        this.customer = customer;
    }
    public Account(String name, double balance, Customer customer){
        this.name = name;
        this.balance = balance;
        this.openingBalance = balance;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getNumber() {
        return this.number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Long getSortCode() {
        return this.sortCode;
    }

    public void setSortCode(long sortCode) {
        this.sortCode = sortCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        if(balance >= -50.00){
            this.balance = balance;
        } else {
            throw new RuntimeException("Invalid Balance.");
        }
    }
//    public Long getId() {
//        return id;
//    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setSortCode(Long sortCode) {
        this.sortCode = sortCode;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }
    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", sortCode=" + sortCode +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(number, account.number) && Objects.equals(sortCode, account.sortCode) && Objects.equals(name, account.name) && Objects.equals(customer, account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, sortCode, name, balance, customer);
    }
}
