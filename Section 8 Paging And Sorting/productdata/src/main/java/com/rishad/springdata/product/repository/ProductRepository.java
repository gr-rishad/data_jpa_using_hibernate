package com.rishad.springdata.product.repository;

import com.rishad.springdata.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    List<Product> findByName(String name);

    List<Product> findByNameAndDesc(String name,String desc);

    List<Product> findByPriceGreaterThan(double price);

    List<Product> findByDescContaining(String desc);

    List<Product> findByPriceBetween(double price1, Double price2);

    List<Product> findByDescLike(String desc);

    List<Product> findByIdIn(List<Integer> ids);

}
