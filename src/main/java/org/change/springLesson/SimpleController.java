package org.change.springLesson;

import org.change.springLesson.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SimpleController {
    private ArrayList<Product> list = DataBase.getInstance().getList();

    @GetMapping("/shop/product/id")
    public String getProduct(@RequestParam(required = false) String id) {
        return "Product : " + list.get(Integer.parseInt(id)).toString();
    }

    @GetMapping("/shop/product/name")
    public String getIdProduct(@RequestParam (required = false) String name) {
        int idProd = -1;
        boolean verefi=false;
        for(Product product :list){
            idProd++;
            if(name.equals(product.getName())){
                verefi=true;
                break;
            }
        }
        if(verefi){
            return "Product id: " + idProd;
        }
        else {
            return "Not found";
        }
    }

    @PostMapping("/shop/product/newproduct")
    public String addProduct(@RequestParam String productname,@RequestParam int cost) {
        list.add(new Product(productname,cost));
        return "product: " + productname + " added";
    }
}