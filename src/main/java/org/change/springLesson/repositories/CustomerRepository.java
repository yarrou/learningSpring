package org.change.springLesson.repositories;

import org.change.springLesson.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findById(int id);

    @Override
    void delete(Customer entity);

    @Override
    Customer save(Customer entity);

    void deleteById(Integer id);
}
