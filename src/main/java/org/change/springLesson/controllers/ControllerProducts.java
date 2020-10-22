package org.change.springLesson.controllers;

import org.change.springLesson.form.ProductForm;
import org.change.springLesson.model.Product;
import org.change.springLesson.repositories.ProductRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;

@Controller
//@RequestMapping("/shop")
public class ControllerProducts {
    private String errorMessage = "something wrong";
    @Autowired
    private ProductRepositoryCrud repositoryCrud;
    ArrayList<Product> list;

    @GetMapping("/products-list")
    public String productslistPage(Model model) {
        model.addAttribute("productsList", list = repositoryCrud.findAll());
        return "products-list";
    }

    @GetMapping("/addProduct")
    public String showAddProductPage(Model model) {

        ProductForm productForm = new ProductForm();
        model.addAttribute("productForm", productForm);

        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String savePerson(Model model, @ModelAttribute("productForm") ProductForm productForm) {

        String name = productForm.getName();
        int price = productForm.getPrice();
        String note = productForm.getNote();
        if (name != null && name.length() > 0 && price >= 0) {
            Product newProduct = new Product(name, price, note);
            repositoryCrud.save(newProduct);

            return "redirect:/products-list";
        }


        model.addAttribute("errorMessage", errorMessage);
        return "addProduct";
    }

}


