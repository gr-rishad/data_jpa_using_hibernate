package com.rishad.springdata.idgenerators;

import com.rishad.springdata.idgenerators.entity.Employee;
import com.rishad.springdata.idgenerators.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdgeneratorsApplicationTests {

    private EmployeeRepository employeeRepository;

    @Autowired
    public IdgeneratorsApplicationTests(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setName("Golam Rabbani");

        employeeRepository.save(employee);
    }

}
