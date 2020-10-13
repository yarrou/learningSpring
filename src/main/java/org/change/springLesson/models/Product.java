package org.change.springLesson.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    private int id;
    private String name;
    private int price;
    private String note;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name =  "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PRICE")
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "NOTE")
    public String getNote(){
        return note;
    }
    public void setNote(String note){
        this.note = note;
    }


    public Product(int id,String name, int price,String note) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.note = note;
    }

    Product() {}
}