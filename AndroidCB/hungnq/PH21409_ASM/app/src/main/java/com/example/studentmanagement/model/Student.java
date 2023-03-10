package com.example.studentmanagement.model;

public class Student {
    private String id, name, classes, birth;

    public Student(String id, String name, String birth, String classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.birth = birth;
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
