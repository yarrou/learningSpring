package org.change.springLesson.models;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "purchases")
public class Purchase {
    private int id;
    private int customerId;
    private int productId;
    private Date date;

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
    @Column(name = "CUSTOMERID")
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Basic
    @Column(name = "PRODUCTID")
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
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
