package com.crms.demo.model;

public class Feedback {
    private String feedback;
    private String fullname;
    private String date;

    //default constructor
    public Feedback() {
    }

    //constructor
    public Feedback(String feedback, String fullname, String date) {
        this.feedback = feedback;
        this.fullname = fullname;
        this.date = date;
    }

    //accessors and mutators methods
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}