package org.change.springLesson.repositories;

import java.util.List;

public interface PurchaseRepository<T>{
    List<T> getPurchasesMoreThanPrice(int price);
    //List<T> getPurchasesLessThanPrice(int price);
}
