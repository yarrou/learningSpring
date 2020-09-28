package org.change.springLesson;

import org.change.springLesson.models.Product;

import java.util.ArrayList;

public class DataBase {
    private static DataBase instance;
    private static ArrayList<Product> list;

    private DataBase() {
        list = new ArrayList();
        list.add(new Product("iphon", 1000));
        list.add(new Product("milk", 2));
        list.add(new Product("laptop", 2000));
        list.add(new Product("TV", 600));
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public static ArrayList<Product> getList() {
        return list;
    }
}