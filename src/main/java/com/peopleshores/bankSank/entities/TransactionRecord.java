package com.peopleshores.bankSank.entities;

import com.peopleshores.bankSank.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public record TransactionRecord (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

//        @Column(length = 100)
        TransactionType type,

        double amount,
        LocalDateTime localDateTime,

        @ManyToOne
        @JoinColumn(name = "number")
        Account fromAccount,

        //
//        @Transient
        Long to_account_number



) implements Serializable{}


