package com.componentmapping;

import com.componentmapping.entity.Address;
import com.componentmapping.entity.Employee;
import com.componentmapping.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComponentmappingApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateEmployee(){
		Employee employee= new Employee();
		employee.setId(123);
		employee.setName("Bharath");

		Address address=new Address();
		address.setCity("Austin");
		address.setStreetaddress("CH-32,Mohakhali");
		address.setCountry("BAN");
		address.setState("Dhaka");
		address.setZipcode("1205");

		employee.setAddress(address);
		employeeRepository.save(employee);
	}

}
