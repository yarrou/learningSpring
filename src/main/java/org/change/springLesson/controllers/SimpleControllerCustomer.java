package org.change.springLesson.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.change.springLesson.model.Customer;
import org.change.springLesson.repositories.CustomerRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")

public class SimpleControllerCustomer {
    @Autowired
    private CustomerRepositoryCrud repository;


    @GetMapping("/customer/{id}")
    public ResponseEntity getCustomer(@PathVariable String id) throws JsonProcessingException {
        Customer customer = repository.findById(Integer.parseInt(id));
        if (customer == null) {
            return new ResponseEntity<>("{\"status\": \"Not Found\"}", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity((new ObjectMapper()).writeValueAsString(customer), HttpStatus.OK);
        }
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity delCustomer(@PathVariable int id) {
        Customer customer = repository.findById(id);
        repository.deleteById(id);
        return new ResponseEntity("customer " + customer.getName() + " deleted", HttpStatus.OK);
    }
    @DeleteMapping("/customers/{name}")
    public ResponseEntity delCustomers(@PathVariable String name){
        List<Customer> list = repository.findAllByName(name);
        repository.deleteAll(list);
        return new ResponseEntity("Customer(s) "+ name + " delete",HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity addCustomer(@RequestBody Customer customer) {
        repository.save(customer);
        return new ResponseEntity("customer: " + customer.getName() + " added", HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity changeCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customer.setId(id);
        repository.save(customer);
        return new ResponseEntity("customer " + customer.getName() + " chanded", HttpStatus.OK);
    }
}
