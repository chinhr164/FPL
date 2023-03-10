package TestLab8.classes;

import java.io.Serializable;

public class Student implements Serializable{

      private String name, major;
      private double mark;

      public Student() {
      }

      public Student(String name, String major, double mark) {
            this.name = name;
            this.major = major;
            this.mark = mark;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getMajor() {
            return major;
      }

      public void setMajor(String major) {
            this.major = major;
      }

      public double getMark() {
            return mark;
      }

      public void setMark(double mark) {
            this.mark = mark;
      }

      public boolean isResult(){
            if(mark<5)
                  return false;
            else
                  return true;
      }
}
