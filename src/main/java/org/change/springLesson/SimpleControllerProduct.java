package org.change.springLesson;

import org.change.springLesson.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/shop")
public class SimpleControllerProduct {
    private ArrayList<Product> list = DataBase.getInstance().getList();

    @GetMapping("/product/{id}")
    public ResponseEntity getProduct(@PathVariable String id) {
        if (Integer.parseInt(id) < 0 || Integer.parseInt(id) > (list.size() - 1)) {
            return new ResponseEntity<>("{\"status\": \"Not Found\"}", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity("{\"id\": " + id + ',' + list.get(Integer.parseInt(id)).toString() + '}', HttpStatus.OK);
        }
    }


    @PostMapping("/product/newproduct")
    public ResponseEntity addProduct(@RequestBody Product product) {
        list.add(product);
        return new ResponseEntity("product: " + product.getName() + " added", HttpStatus.OK);
    }
}