package org.change.springLesson.repositories;

import org.change.springLesson.model.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PurchaseRepositoryCrud extends CrudRepository<Purchase, Integer> {

    @Override
    void delete(Purchase entity);

    Purchase findById(int id);

    @Override
    Purchase save(Purchase entity);

    @Override
    void deleteById(Integer id);

    ArrayList<Purchase> findAllByCustomerId(int customerId);

}
