package com.peopleshores.bankSank.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 40)
    private String fullName;

    public Customer() {
    }

    public Customer(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;

    }

    public Customer(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws Exception {
        if (fullName == null || fullName.isEmpty()) {
            throw new Exception("Invalid name.");
        } else if (Customer.containsNumbers(fullName)) {
            throw new Exception("Invalid name format. Must only contain letters.");
        } else {
            this.fullName = fullName;
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    private static boolean containsNumbers(String fullName) {
        for (char c : fullName.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

}
