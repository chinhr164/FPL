
package Buoi9.ui;

import java.io.Serializable;

public class Sach implements Serializable{
    private String id, name;
    private double price;

    public Sach(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Sach() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    

}