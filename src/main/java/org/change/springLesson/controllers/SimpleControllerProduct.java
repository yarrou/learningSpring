package org.change.springLesson.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.change.springLesson.model.Product;
import org.change.springLesson.repositories.ProductRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/shop")
public class SimpleControllerProduct {
    @Autowired
    private ProductRepositoryCrud repository;


    @GetMapping("/product/{id}")
    public ResponseEntity getProduct(@PathVariable String id) throws JsonProcessingException {
        Product product = repository.findById(Integer.parseInt(id));
        if (product == null) {
            return new ResponseEntity<>("{\"status\": \"Not Found\"}", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity((new ObjectMapper()).writeValueAsString(product), HttpStatus.OK);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity delProduct(@PathVariable int id) {
        Product product = repository.findById(id);
        repository.deleteById(id);
        return new ResponseEntity("product " + product.getName() + " deleted", HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity addProduct(@RequestBody Product product) {
        repository.save(product);
        return new ResponseEntity("product: " + product.getName() + " added", HttpStatus.OK);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity changeProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        repository.save(product);
        return new ResponseEntity("product " + product.getName() + " chanded", HttpStatus.OK);
    }


    @GetMapping("/products/greater/{cost}")
    public ResponseEntity getGreaterThan(@PathVariable int cost) throws JsonProcessingException {
        ArrayList<Product> list = repository.findAllByPriceGreaterThan(cost);
        return new ResponseEntity((new ObjectMapper()).writeValueAsString(list),HttpStatus.OK);
    }

    @GetMapping("/products/less/{cost}")
    public ResponseEntity getLessThan(@PathVariable int cost) throws JsonProcessingException {
        ArrayList<Product> list = repository.findAllByPriceLessThan(cost);
        return new ResponseEntity((new ObjectMapper()).writeValueAsString(list),HttpStatus.OK);
    }

}