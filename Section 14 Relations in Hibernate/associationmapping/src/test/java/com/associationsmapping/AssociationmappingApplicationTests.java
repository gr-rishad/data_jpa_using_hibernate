package com.associationsmapping;

import com.associationsmapping.entity.Customer;
import com.associationsmapping.entity.PhoneNumber;
import com.associationsmapping.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
class AssociationmappingApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateCustomer(){
		Customer customer=new Customer();
		customer.setName("John");
		HashSet<PhoneNumber> numbers= new HashSet<>();
		PhoneNumber phoneNumber= new PhoneNumber();
		phoneNumber.setNumber("12345555");
		phoneNumber.setType("Cell");
		numbers.add(phoneNumber);

		PhoneNumber phoneNumber2= new PhoneNumber();
		phoneNumber2.setNumber("09875678");
		phoneNumber2.setType("Home");
		numbers.add(phoneNumber2);

		customerRepository.save(customer);
	}

}
