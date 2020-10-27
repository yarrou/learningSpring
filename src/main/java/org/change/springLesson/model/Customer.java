package org.change.springLesson.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    private Integer id;
    private String name;
    private String email;
    private String city;
    private int age;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name =  "NAME")
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    @Basic
    @Column(name = "email")
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    @Basic
    @Column(name = "CITY")
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return city;
    }

    @Basic
    @Column(name = "AGE")
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public Customer(int id, String name, String email, String city, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.age = age;
    }

    Customer(){}

    public Customer(String name, String email, String city, int age) {
        this.id = null;
        this.name = name;
        this.email = email;
        this.city = city;
        this.age = age;
    }

    public Customer(Integer id, String name, String email, String city, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.age = age;
    }
}
