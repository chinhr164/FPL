package com.example.studentmanagement;

public class Student {
    private String name, classes, birth;

    public Student(String name, String classes, String birth) {
        this.name = name;
        this.classes = classes;
        this.birth = birth;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
