package com.composite_key.repositories;

import com.composite_key.entities.Customer;
import com.composite_key.entities.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {
}
