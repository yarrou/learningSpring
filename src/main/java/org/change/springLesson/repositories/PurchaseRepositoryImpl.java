package org.change.springLesson.repositories;

import org.change.springLesson.models.Purchase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PurchaseRepositoryImpl implements PurchaseRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List getPurchasesMoreThanPrice(int price) {
        return em.createQuery("from purchases join products on products.id = purchases.product_id where products.price > ?", Purchase.class).getResultList();
    }
}
