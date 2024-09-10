package com.peopleshores.bankSank.entities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerTest {

    @Test
    void testCustomercreation(){
        Customer customer = new Customer("Kim Etienne",50.00);
        assertNotNull(customer);
    }
    @Test
    void setFullName() throws Exception {
        Customer customer = new Customer("Kim Etienne");
        customer.setFullName("Kimberly Etienne");
        //assertEquals("Kimberly Etienne", customer.getFullName());
    }
    @Test
    void setFullNameIsEmpty() {
        Customer customer = new Customer();
        assertThrows(Exception.class, () -> {
            customer.setFullName("");
        });
    }
    @Test
    void setFullNameIsNull() {
        Customer customer = new Customer();
        assertThrows(Exception.class, () -> {
            customer.setFullName(null);
        });
    }
    @Test
    void setFullNameLongerThanFortyCharacters() throws Exception {
        Customer customer = new Customer();
        customer.setFullName("KimberlyAnnNasibaStevenAbdulai EtienneParomaSow");
        assertEquals("KimberlyAnnNasibaStevenAbdulai EtienneParomaSow", customer.getFullName());
    }
    @Test
    void setFullNameWithAllNumbers() {
        Customer customer = new Customer();
        assertThrows(Exception.class, () -> {
            customer.setFullName("123456");
        });
    }

    @Test
    void setFullNameWithSomeNumbers() {
        Customer customer = new Customer();
        assertThrows(Exception.class, () -> {
            customer.setFullName("Kim123");
        });
    }


    @Test
    void setFullNameWithLowerCase() throws Exception{
        Customer customer = new Customer();
        customer.setFullName("kim etienne");
        assertEquals("kim etienne", customer.getFullName());

    }
    @Test
    void setCashInHand() throws Exception {
        Customer customer = new Customer("Kim Etienne", 50.00);
        customer.setCashInHand(100.00);
        assertEquals(100.00, customer.getCashInHand());
    }
    @Test
    void CashInHandReturnsZeroIfNegative() {
        Customer customer = new Customer();
        assertThrows(Exception.class, () -> {
            customer.setCashInHand(-50.00);
        });
        assertEquals(0.00, customer.getCashInHand());
    }
}