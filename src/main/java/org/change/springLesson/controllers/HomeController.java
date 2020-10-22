package org.change.springLesson.controllers;

import org.change.springLesson.model.Product;
import org.change.springLesson.repositories.ProductRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    private String message = "Welcome to shop ver 1.0";
    @GetMapping("/shop")
    public String homePage(Model model) {
        model.addAttribute("message", message);
        return "home";
    }
}