package org.change.springLesson.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "purchases")
public class Purchase {
    private int id;
    private int customer_Id;
    private int product_Id;
    private Date date;

    Purchase(){}

    public Purchase(int id, int customer_Id, int product_Id, Date date) {
        this.id = id;
        this.customer_Id = customer_Id;
        this.product_Id = product_Id;
        this.date = date;
    }

    public Purchase(int id, int customer_Id, int product_Id) {
        this.id = id;
        this.customer_Id = customer_Id;
        this.product_Id = product_Id;
    }

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
    @Column(name = "CUSTOMER_ID")
    public void setCustomerId(int customerId) {
        this.customer_Id = customerId;
    }

    public int getCustomerId() {
        return customer_Id;
    }

    @Basic
    @Column(name = "PRODUCT_ID")
    public void setProductId(int productId) {
        this.product_Id = productId;
    }

    public int getProductId() {
        return product_Id;
    }

    @Basic
    @Column(name = "DATE")
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
