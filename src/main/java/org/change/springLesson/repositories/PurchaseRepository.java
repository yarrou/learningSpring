package org.change.springLesson.repositories;

import org.change.springLesson.models.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
    Purchase findById(int id);

    @Override
    void delete(Purchase entity);

    @Override
    Purchase save(Purchase entity);

    @Override
    void deleteById(Integer id);
}
