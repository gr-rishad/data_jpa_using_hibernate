package com.rishad.springdata.product.repository;

import com.rishad.springdata.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {


}
