package classes;

import java.io.Serializable;

public class Device implements Serializable {

      private String name, prod;
      private double price;

      public Device() {
      }

      public Device(String name, String prod, double price) {
            this.name = name;
            this.prod = prod;
            this.price = price;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getProd() {
            return prod;
      }

      public void setProd(String prod) {
            this.prod = prod;
      }

      public double getPrice() {
            return price;
      }

      public void setPrice(double price) {
            this.price = price;
      }

      public String status() {
            if (price < 5000) {
                  return "Thấp";
            } else {
                  return "Cao";
            }
      }
}
