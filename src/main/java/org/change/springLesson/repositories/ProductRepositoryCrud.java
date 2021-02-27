package org.change.springLesson.repositories;

import org.change.springLesson.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProductRepositoryCrud extends CrudRepository<Product, Integer> {
    Product findById(int id);

    @Override
    void delete(Product entity);

    @Override
    void deleteById(Integer integer);

    void deleteAllByName(String name);

    ArrayList<Product> findAllByPriceGreaterThan(int price);

    ArrayList<Product> findAllByPriceLessThan(int price);
    ArrayList<Product> findAll();

}
