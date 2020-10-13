package org.change.springLesson.repositories;

import org.change.springLesson.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findById(int id);

    @Override
    void delete(Product entity);

    @Override
    Product save(Product product);

    @Override
    void deleteById(Integer integer);


}
