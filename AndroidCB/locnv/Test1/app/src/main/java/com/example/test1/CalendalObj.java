package com.example.test1;

public class CalendalObj {
    private String contentT, timeT;

    public CalendalObj() {
    }

    public CalendalObj(String contentT, String timeT) {
        this.contentT = contentT;
        this.timeT = timeT;
    }

    public String getContentT() {
        return contentT;
    }

    public void setContentT(String contentT) {
        this.contentT = contentT;
    }

    public String getTimeT() {
        return timeT;
    }

    public void setTimeT(String timeT) {
        this.timeT = timeT;
    }
}
