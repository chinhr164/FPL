package FinalTest.Classes;

import java.io.Serializable;

public class KH implements Serializable {

      private String name, gender;
      private int age;

      public KH() {
      }

      public KH(String name, String gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getGender() {
            return gender;
      }

      public void setGender(String gender) {
            this.gender = gender;
      }

      public int getAge() {
            return age;
      }

      public void setAge(int age) {
            this.age = age;
      }

      public String status() {
            if (age < 18) {
                  return "Vị thành niên";
            } else {
                  return "Thành niên";
            }
      }

}
