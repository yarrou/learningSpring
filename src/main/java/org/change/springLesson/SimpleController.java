package org.change.springLesson;

import org.change.springLesson.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SimpleController {
    private ArrayList<Product> list = DataBase.getInstance().getList();

    @GetMapping("/shop/product/{id}")
    public String getProduct(@PathVariable String id) {
        return "{\"id\": " + id + ',' + list.get(Integer.parseInt(id)).toString() + '}';
    }


    @PostMapping("/shop/product/newproduct")
    public String addProduct(@RequestParam String productname, @RequestParam int cost) {
        list.add(new Product(productname, cost));
        return "product: " + productname + " added";
    }
}