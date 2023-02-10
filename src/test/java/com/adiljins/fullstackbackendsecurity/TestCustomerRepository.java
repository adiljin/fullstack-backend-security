package com.adiljins.fullstackbackendsecurity;

import com.adiljins.fullstackbackendsecurity.model.essential.Customer;
import com.adiljins.fullstackbackendsecurity.repository.CustomerRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import org.junit.After;
import org.junit.AfterClass;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class TestCustomerRepository {

    @Mock
    private CustomerRepository customerRepository;

    private Customer customer;


    @Before
    public void setUp() {
        customer = new Customer();
        customer.setName("John Doe");
        customer.setAddress("123 Main St");
        customer.setNumber("555-555-5555");
        customer.setE_mail("john.doe@email.com");
    }

    @Test
    public void testGetCustomerByIdSuccess() {
        when(customerRepository.findById(1L)).thenReturn(java.util.Optional.of(customer));
        Optional<Customer> result = customerRepository.findById(1L);
        assertThat(result.get()).isEqualTo(customer);
    }


    @After
    public void after() {
        System.out.println("After Test Case");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }
}
