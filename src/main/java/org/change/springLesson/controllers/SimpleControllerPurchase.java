package org.change.springLesson.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.change.springLesson.models.Purchase;
import org.change.springLesson.repositories.PurchaseRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class SimpleControllerPurchase {
    @Autowired
    private PurchaseRepositoryCrud repository;

    //get all user purchases by id
    @GetMapping("/purchases/{id}")
    public ResponseEntity getPurchases(@PathVariable String id) throws JsonProcessingException {
        ArrayList<Purchase> list = repository.findAllByCustomerId(Integer.parseInt(id));
        if (list == null || list.size()==0) {
            return new ResponseEntity<>("{\"status\": \"Not Found\"}", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity((new ObjectMapper()).writeValueAsString(list), HttpStatus.OK);
        }
    }

    //deleting a purchase by id
    @DeleteMapping("/purchase/{id}")
    public ResponseEntity delPurchase(@PathVariable int id) {
        Purchase purchase = repository.findById(id);
        repository.deleteById(id);
        return new ResponseEntity("purchase " + id + " deleted", HttpStatus.OK);
    }


    //adding a new purchase
    @PostMapping("/purchase/new")
    public ResponseEntity addPurchase(@RequestBody Purchase purchase) {
        repository.save(purchase);
        return new ResponseEntity("purchase: " + purchase.getId() + " added", HttpStatus.OK);
    }

    @GetMapping("/purchases/more/{val}")
    public ResponseEntity getBigPurchases(@PathVariable int val) throws JsonProcessingException {
        List<Purchase> list = repository.getPurchasesMoreThanPrice(val);
        return new ResponseEntity((new ObjectMapper()).writeValueAsString(list),HttpStatus.OK);
    }


}
