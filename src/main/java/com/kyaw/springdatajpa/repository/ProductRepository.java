/**
 * @Author : Kyaw Zaw Htet
 * @Date : 4/10/2024
 * @Time : 5:25 AM
 * @Project_Name : spring-data-jpa
 */
package com.kyaw.springdatajpa.repository;

import com.kyaw.springdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {


    /**
     * Returns the found product entry by using its name as search criteria.
     * If no product entry is found, this method returns null.
     */
    public Product findByName(String name);

    /**
     * Returns an Optional which contains the found product entry by using its id as search criteria.
     * If no product entry is found, this method returns an empty Optional.
     */
    Optional<Product> findById(Long id);

    /**
     * Returns the found list of product entries whose name or description is given as a method parameters.
     * If no product entries is found, this method returns as empty list.
     */
    List<Product> findByNameOrDescription(String name, String description);


    /**
     * Returns the found list of product entries whose name and description is given as a method parameters.
     * If no product entries is found, this method returns as empty list.
     */
    List<Product> findByNameAndDescription(String name, String description);

    /**
     * Returns the distinct product entry whose name is given as a method parameter.
     * If no product entry is found, this method returns null.
     */
    Product findDistinctByName(String name);

    /**
     * Returns the products whose price is greater than given price as method parameter.
     * @param price
     * @return
     */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    /**
     * Returns the products whose price is less than given price as method parameter.
     * @param price
     * @return
     */
    List<Product> findByPriceLessThan(BigDecimal price);

    /**
     * Return the filtered the product records that match the given text.
     * @param name
     * @return
     */
    List<Product> findByNameContaining(String name);

    /**
     * Return products base on SQL like condition.
     * @param name
     * @return
     */
    List<Product> findByNameLike(String name);
}
















