package org.change.springLesson.controllers;

import org.change.springLesson.form.CustomerForm;
import org.change.springLesson.model.Customer;
import org.change.springLesson.repositories.CustomerRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class ControllerCustomer {

    //@RequestMapping("/shop")
    @Autowired
    private CustomerRepositoryCrud repositoryCrud;

    ArrayList<Customer> list;

    @GetMapping("/customers-list")
    public String customerListPage(Model model) {
        model.addAttribute("customersList", list = repositoryCrud.findAll());
        return "customers-list";
    }

    @GetMapping("/addCustomer")
    public String showAddCustomerPage(Model model) {

        CustomerForm customerForm = new CustomerForm();
        model.addAttribute("customerForm", customerForm);

        return "addCustomer";
    }

    @PostMapping("/addCustomer")
    public String saveCustomer(Model model, @ModelAttribute("customerForm") CustomerForm customerForm) {

        String name = customerForm.getName();
        String email = customerForm.getEmail();
        String city = customerForm.getCity();
        int age = customerForm.getAge();
        try {
            Customer newCustomer = new Customer(null, name, email, city, age);
            repositoryCrud.save(newCustomer);
            return "redirect:/customers-list";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            e.printStackTrace();
            return "infoPage";
        }
    }

}
