package com.rishad.springdata.product;

import com.rishad.springdata.product.entities.Product;
import com.rishad.springdata.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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

}
