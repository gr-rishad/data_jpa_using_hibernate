package com.rishad.springdata.product;

import com.rishad.springdata.product.entities.Product;
import com.rishad.springdata.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
class ProductdataApplicationTests {

    private ProductRepository productRepository;

    @Autowired
    public ProductdataApplicationTests(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreate() {
        Product product = new Product();
        product.setId(1);
        product.setName("Iphone");
        product.setDesc("Awesome");
        product.setPrice(1000d);

        productRepository.save(product);
    }

    @Test
    public void testRead() {
        Product product = productRepository.findById(1).get();
        System.out.println(product);
    }

    @Test
    public void testUpdate() {
        Product product = productRepository.findById(1).get();
        product.setPrice(1200d);
        productRepository.save(product);
    }

    @Test
    public void delete() {
        if (productRepository.existsById(1)) {
            productRepository.deleteById(1);
        }
    }

    @Test
    public void testCount() {
        System.out.println("Total Records: " + productRepository.count());
    }

    @Test
    public void testFindByName() {
        List<Product> products = productRepository.findByName("IWatch");
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    @Test
    public void testFindByNameAndDesc() {
        List<Product> products = productRepository.findByNameAndDesc("Washer", "From LG Inc");
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    @Test
    public void testFindByPriceGreaterThan() {
        List<Product> products = productRepository.findByPriceGreaterThan(1000d);
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    @Test
    public void testFindByDesContaining() {
        List<Product> products = productRepository.findByDescContaining("Apple");
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    @Test
    public void testFindByPriceBetween() {
        List<Product> products = productRepository.findByPriceBetween(1000d, 2000d);
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    @Test
    public void testFindByDescLike() {
        List<Product> products = productRepository.findByDescLike("%LG%");
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    @Test
    public void testFindByIdIn() {
        List<Product> products = productRepository.findByIdIn(Arrays.asList(1, 2, 3));
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    @Test
    public void testPageable() {
        Pageable pageable = PageRequest.of(0, 1);
        Page<Product> results = productRepository.findAll(pageable);
        results.forEach(p -> System.out.println(p.getName()));
    }

}
