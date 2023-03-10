package Test2.Classes;

import java.io.Serializable;

public class Book implements Serializable {

      private String name, type;
      private double price;

      public Book() {
      }

      public Book(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getType() {
            return type;
      }

      public void setType(String type) {
            this.type = type;
      }

      public double getPrice() {
            return price;
      }

      public void setPrice(double price) {
            this.price = price;
      }

      public String status() {
            if (price < 200000) {
                  return "Thấp";
            } else {
                  return "Cao";
            }
      }
}
