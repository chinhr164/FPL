package com.poly.lab8.model;

public class ProductDAO extends DAO<Product> {

     @Override
     public Product find(String id) {
          for (Product p : list) {
               if (p.getName().equals(id)) {
                    return p;
               }
          }
          return null;
     }
}
