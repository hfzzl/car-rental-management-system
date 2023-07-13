package com.crms.demo.model;

public class Booking {
    private int bookingid;
    private int vehicleid;
    private String custName;
    private int custPhoneNo;
    private String custEmail;
    private String pDate;
    private String pTime;
    private String rDate;
    private String rTime;
    private String pStatus;
    private String rStatus;
    private int hours;
    private String voucher;
    private int price;

    public Booking(){
    }

    public Booking(int bookingid, int vehicleid, String custName, int custPhoneNo, String custEmail, String pDate, String pTime, String rDate, String rTime, String pStatus, String rStatus, int hours, String voucher, int price){
        this.bookingid= bookingid;
        this.vehicleid= vehicleid;
        this.custName= custName;
        this.custPhoneNo= custPhoneNo;
        this.custEmail= custEmail;
        this.pDate= pDate;
        this.pTime= pTime;
        this.rDate= rDate;
        this.rTime= rTime;
        this.pStatus= pStatus;
        this.rStatus= rStatus;
        this.hours= hours;
        this.voucher= voucher;
        this.price= price;
    }

    public void setBookingid(int bookingid) {
        this.bookingid= bookingid;
    }

    public int getBookingid() {
        return bookingid;
    }
    
    public void setVehicleid(int vehicleid) {
        this.vehicleid= vehicleid;
    }

    public int getVehicleid() {
        return vehicleid;
    }

    public void setCustname(String custName) {
        this.custName= custName;
    }

    public String getCustname() {
        return custName;
    }

    public void setCustPhoneno(int custPhoneNo) {
        this.custPhoneNo= custPhoneNo;
    }

    public int getCustPhoneNo() {
        return custPhoneNo;
    }

    public void setCustemail(String custEmail) {
        this.custEmail= custEmail;
    }

    public String getCustemail() {
        return custEmail;
    }

    //pickup details
    public void setPDate(String pDate) {
        this.pDate= pDate;
    }

    public String getPDate() {
        return pDate;
    }

    public void setPTime(String pTime) {
        this.pTime= pTime;
    }

    public String getPTime() {
        return pTime;
    }

    //return details
    public void setRDate(String rDate) {
        this.rDate= rDate;
    }

    public String getRDate() {
        return rDate;
    }

    public void setRTime(String rTime) {
        this.rTime= rTime;
    }

    public String getRTime() {
        return rTime;
    }

    public void setRStatus(String rStatus) {
        this.rStatus= rStatus;
    }

    public String getRStatus() {
        return rStatus;
    }

    public void setPStatus(String pStatus) {
        this.pStatus= pStatus;
    }

    public String getPStatus() {
        return pStatus;
    }

    public void setHours(int hours) {
        this.hours= hours;
    }

    public int getHours() {
        return hours;
    }
    public void setVoucher(String voucher) {
        this.voucher= voucher;
    }
    public String getVoucher() {
        return voucher;
    }
    public void setPrice(int price) {
        this.price= price;
    }
    public int getPrice() {
        return price;
    }

    public String toString(){
        return "Booking [bookingid=" + bookingid + ", vehicleid=" + vehicleid + ", custName=" + custName + ", custPhoneNo=" + custPhoneNo + ", custEmail=" + custEmail + ", pDate=" + pDate + ", pTime=" + pTime + ", rDate=" + rDate + ", rTime=" + rTime + ", pStatus=" + pStatus + ", rStatus=" + rStatus + ", hours=" + hours + "]";
    }
}

// this.bookingid= bookingid;
// this.vehicleid= vehicleid;
// this.custName= custName;
// this.custPhoneNo= custPhoneNo;
// this.custEmail= custEmail;
// this.pDate= pDate;
// this.pTime= pTime;
// this.rDate= rDate;
// this.rTime= rTime;
// this.pStatus= pStatus;
// this.rStatus= rStatus;
// this.hours= hours;
// this.voucher= voucher;
// this.price= price;