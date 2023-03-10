package com.poly.lab8.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

abstract public class DAO<Entity> {

     protected ArrayList<Entity> list = new ArrayList<>();

     public void add(Entity entity) {
          list.add(entity);
     }

     public void remove(Entity entity) {
          list.remove(entity);
     }

     abstract public Product find(String id);

     public ArrayList<Entity> getList() {
          return list;
     }

     public void load(String path) {
          try {
               FileInputStream fis = new FileInputStream(path);
               ObjectInputStream ois = new ObjectInputStream(fis);
               list = (ArrayList<Entity>) ois.readObject();
               ois.close();
               fis.close();
          } catch (Exception e) {
               System.out.println("Lỗi đọc dữ liệu");
          }
     }

     ;

     public void store(String path) {
          try {
               FileOutputStream fos = new FileOutputStream(path);
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(list);
               oos.close();
               fos.close();
          } catch (Exception e) {
               System.out.println("Lỗi ghi dữ liệu");
          }
     }
}
