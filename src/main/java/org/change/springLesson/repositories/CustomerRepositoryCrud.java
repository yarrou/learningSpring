package org.change.springLesson.repositories;

import org.change.springLesson.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface CustomerRepositoryCrud extends CrudRepository<Customer, Integer> {
    Customer findById(int id);

    @Override
    void delete(Customer entity);

    @Override
    Customer save(Customer entity);

    void deleteById(Integer id);

    List<Customer> findAllByName(String s);
    ArrayList<Customer> findAll();
}
