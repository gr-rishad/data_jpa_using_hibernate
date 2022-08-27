package com.associationsmapping;

import com.associationsmapping.entity.Customer;
import com.associationsmapping.entity.PhoneNumber;
import com.associationsmapping.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class AssociationmappingApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setName("Golam Rabbani");
        // HashSet<PhoneNumber> numbers = new HashSet<>();

        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber("12345555");
        phoneNumber.setType("Cell");
        //  phoneNumber.setCustomer(customer);
        //  numbers.add(phoneNumber);

        PhoneNumber phoneNumber2 = new PhoneNumber();
        phoneNumber2.setNumber("09875678");
        phoneNumber2.setType("Home");
        // phoneNumber2.setCustomer(customer);
        // numbers.add(phoneNumber2);

        //customer.setNumbers(numbers);
        customer.addPhoneNumber(phoneNumber);
        customer.addPhoneNumber(phoneNumber2);
        customerRepository.save(customer);
    }

    @Test
    @Transactional
    public void testLoadCustomer(){
        Optional<Customer> customer=customerRepository.findById(6L);
        System.out.println(customer.get().getName());

        Set<PhoneNumber> numbers= customer.get().getNumbers();
        numbers.forEach(number -> System.out.println(number.getNumber()));
    }

    @Test
    public void testUpdateCustomer(){
        Optional<Customer> customer=customerRepository.findById(6L);
        customer.get().setName("Golam Rabbani Rishad");

        Set<PhoneNumber> numbers= customer.get().getNumbers();
        numbers.forEach(number -> number.setType("cell"));

        customerRepository.save(customer.get());
    }

    @Test
    public void testDeleteCustomer(){
        customerRepository.deleteById(5l);
    }

}
