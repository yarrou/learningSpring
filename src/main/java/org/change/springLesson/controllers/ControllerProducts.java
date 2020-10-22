package org.change.springLesson.controllers;

import org.change.springLesson.repositories.ProductRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/shop")
public class ControllerProducts {
    @Autowired
    private ProductRepositoryCrud repositoryCrud;
    @RequestMapping (value = "/products-list",method = RequestMethod.GET)
    public String showAllProducts(ModelMap model){
        model.put("productsList",repositoryCrud.findAll());
        return "products-list";
    }
}
