/**
 * @Author : Kyaw Zaw Htet
 * @Date : 4/13/2024
 * @Time : 5:36 PM
 * @Project_Name : spring-data-jpa
 */
package com.kyaw.springdatajpa.repository;


import com.kyaw.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 1");
        System.out.println("Product ID : " + product.getId());
        System.out.println("Product Name : " + product.getName());
        System.out.println("Product Description : " + product.getDescription());
    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(2L).get();
        System.out.println("Product ID : " + product.getId());
        System.out.println("Product Name : " + product.getName());
        System.out.println("Product Description : " + product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription("product 1", "product 1 description");
        products.forEach((product -> {
            System.out.println("Product ID : " + product.getId());
            System.out.println("Product Name : " + product.getName());
        }));
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> products = productRepository.findByNameAndDescription("product 1", "product 1 description");
        products.forEach((product -> {
            System.out.println("Product ID : " + product.getId());
            System.out.println("Product Name : " + product.getName());
        }));
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("product 2");
        System.out.println("Product ID : " + product.getId());
        System.out.println("Product Name : " + product.getName());
        System.out.println("Product Description : " + product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach((product -> {
            System.out.println("Product ID : " + product.getId());
            System.out.println("Product Name : " + product.getName());
        }));
    }

    @Test
    void findByPriceLessThanMethod() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(300));
        products.forEach((product -> {
            System.out.println("Product ID : " + product.getId());
            System.out.println("Product Name : " + product.getName());
        }));
    }

    @Test
    void findByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("product 1");
        products.forEach((product -> {
            System.out.println("Product ID : " + product.getId());
            System.out.println("Product Name : " + product.getName());
        }));
    }

    @Test
    void findByNameLikeMethod() {
        List<Product> products = productRepository.findByNameLike("product 1");
        products.forEach((product -> {
            System.out.println("Product ID : " + product.getId());
            System.out.println("Product Name : " + product.getName());
        }));
    }

    @Test
    void findByPriceBetweenMethod() {
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(100), new BigDecimal(300));
        products.forEach((product -> {
            System.out.println("Product ID : " + product.getId());
            System.out.println("Product Name : " + product.getName());
        }));
    }

    @Test
    void findByDateCreatedBetweenMethod() {
        // start date
        LocalDateTime startDate = LocalDateTime.of(2024, 04, 13, 17, 46, 16);
        // end date
        LocalDateTime endDate = LocalDateTime.of(2024, 04, 13, 17, 55, 55);
        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);
        products.forEach((product -> {
            System.out.println("Product ID : " + product.getId());
            System.out.println("Product Name : " + product.getName());
        }));
    }

    @Test
    void findByNameInMethod() {
        List<Product> products = productRepository.findByNameIn(List.of("product 1", "product 2", "product 3"));
        products.forEach((product -> {
            System.out.println("Product ID : " + product.getId());
            System.out.println("Product Name : " + product.getName());
        }));
    }

    @Test
    void findFirst2ByOrderByNameAscMethod() {
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach((product -> {
            System.out.println("Product ID : " + product.getId());
            System.out.println("Product Name : " + product.getName());
        }));
    }

    @Test
    void findTop2ByOrderByPriceDesc(){
        List<Product> products = productRepository.findTop2ByOrderByPriceDesc();
        products.forEach((product -> {
            System.out.println("Product ID : " + product.getId());
            System.out.println("Product Name : " + product.getName());
        }));
    }
}






















