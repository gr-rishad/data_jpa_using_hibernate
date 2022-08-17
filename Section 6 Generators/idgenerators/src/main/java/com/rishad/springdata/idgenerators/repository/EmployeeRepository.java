package com.rishad.springdata.idgenerators.repository;

import com.rishad.springdata.idgenerators.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
