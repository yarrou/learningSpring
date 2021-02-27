package org.change.springLesson.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    private Integer id;
    private String name;
    private int price;
    private String note;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setId(Integer id){this.id= id;}

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


    public Product(Integer id,String name, int price,String note) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.note = note;
    }

    public Product(String name, int price, String note) {
        this.id = null;
        this.name = name;
        this.price = price;
        this.note = note;
    }

    public Product() {}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}