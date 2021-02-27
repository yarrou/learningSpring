package org.change.springLesson.form;

public class ProductForm {
    private Integer id;
    private String name;
    private int price;
    private String note;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPrice(String priceSt) {
        this.price = Integer.parseInt(priceSt);
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
