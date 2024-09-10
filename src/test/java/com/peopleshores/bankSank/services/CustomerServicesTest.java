package com.peopleshores.bankSank.services;

import static org.junit.jupiter.api.Assertions.*;

import com.peopleshores.bankSank.entities.Customer;
import com.peopleshores.bankSank.repos.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerServicesTest {

    Customer customer1, customer2, customer3;

    @Mock
    private static CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServices customerServices;

    @BeforeEach
    void setup(){
        customer1 = new Customer(1L, "Nasiba Paroma", 0.00);
        customer2 = new Customer(2L, "Kim Etienne", 50.00);
        customer3 = new Customer(3L, "Kim Paroma", 0.00);

        when(customerRepository.getReferenceById(customer1.getId())).thenReturn(customer1);
        when(customerRepository.getReferenceById(customer2.getId())).thenReturn(customer2);
        when(customerRepository.getReferenceById(customer3.getId())).thenReturn(customer3);

    }
    @Test
    void testCreateCustomer() {
        customerServices.createCustomer("Steven Sow");
        assertNotNull(customerRepository.getReferenceById(1L));
    }
    @Test
    void testUpdateCustomerFullName() throws Exception {
        customerServices.updateCustomerFullName(2L, "Abdulai Etienne");
        assertEquals("Abdulai Etienne", customerRepository.getReferenceById(2L).getFullName());
    }
    @Test
    void testUpdateCustomerCashInHand() throws Exception {
        customerServices.updateCustomerCashInHand(3L, 75.00);
        assertEquals(75.00, customerRepository.getReferenceById(3L).getCashInHand());
    }
    @Test
    void testGetCustomer() {
        Customer customer = customerServices.getCustomer(1L);
        assertEquals("Nasiba Paroma", customer.getFullName());
    }
    @Test
    void testDeleteCustomer() {
        customerServices.deleteCustomer(2L);
        assertFalse(customerRepository.existsById(2L));
    }
}