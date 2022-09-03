package com.composite_key;

import com.composite_key.entities.Customer;
import com.composite_key.entities.CustomerId;
import com.composite_key.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompositeKeyApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        //customer.setId(1234);
        //customer.setEmail("test@test.com");
        customer.setCustomerName("Golam Rabbani Rishad");

        customerRepository.save(customer);

    }

    @Test
    public void testCreateCustomerEmbeddable() {
        Customer customer = new Customer();
        CustomerId id =new CustomerId();
        id.setId(1234);
        id.setEmail("test@test.com");
        customer.setId(id);
        customer.setCustomerName("Golam Rabbani Rishad");

        customerRepository.save(customer);

    }

}
