package com.poly.lab3.classes;

public class Student {

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

    public String getGrade() {
        if (this.mark < 3) {
            return "Kém";
        }
        if (this.mark < 5) {
            return "Yếu";
        }
        if (this.mark < 6.5) {
            return "Trung bình";
        }
        if (this.mark < 7.5) {
            return "Khá";
        }
        if (this.mark < 9) {
            return "Giỏi";
        }
        return "Xuất sắc";
    }

    public boolean isBonus() {
        return this.mark >= 7.5;
    }
}
