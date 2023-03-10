package com.example.studentmanagement;

public class Classes {
    private String id, name,stt;

    public Classes() {
    }

    public Classes(String stt, String id, String name) {
        this.stt = stt;
        this.id = id;
        this.name = name;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
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
}
