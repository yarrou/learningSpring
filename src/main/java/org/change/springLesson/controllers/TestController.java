package org.change.springLesson.controllers;


import org.change.springLesson.model.Product;
import org.change.springLesson.repositories.ProductRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    private String message ;
    @Autowired
    private ProductRepositoryCrud repositoryCrud;
    @GetMapping("/test")
    public String testPage(Model model){
        Product testProduct = new Product();
        System.out.println(testProduct);
        testProduct.setId(null);
        testProduct.setName("iphon");
        testProduct.setPrice(100);
        testProduct.setNote("second-hand");
        System.out.println(testProduct);
        try {
            repositoryCrud.save(testProduct);
            message = "product added";
        }
        catch (Exception e){
            message = e.getMessage();
            e.printStackTrace();
        }
        model.addAttribute("message",message);
        return  "test";

    }
}
