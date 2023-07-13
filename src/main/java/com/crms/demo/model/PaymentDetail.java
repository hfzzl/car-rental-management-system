package com.crms.demo.model;

public class PaymentDetail {
    private String CHname;
    private String email;
    private int Cnum;
    private String ExpMonth;
    private String ExpYear;
    private int CVC;


    public PaymentDetail(){

    }

    public PaymentDetail(String CHname, String email, int Cnum, String ExpMonth, String ExpYear, int CVC) {
        this.CHname = CHname;
        this.email = email;
        this.Cnum = Cnum;
        this.ExpMonth = ExpMonth;
        this.ExpYear = ExpYear;
        this.CVC = CVC;
    }

    public String getCHname(){
        return CHname;
    }

    public void setCHname(String CHname){
        this.CHname=CHname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }
    public int getCnum(){
        return Cnum;
    }

    public void setCnum(int Cnum){
        this.Cnum=Cnum;
    }
    public String getExpMonth(){
        return ExpMonth;
    }

    public void setExpMonth(String ExpMonth){
        this.ExpMonth=ExpMonth;
    }
    public String getExpYear(){
        return ExpYear;
    }

    public void setExpYear(String ExpYear){
        this.ExpYear=ExpYear;
    }
    public int getCVC(){
        return CVC;
    }

    public void setCVC(int CVC){
        this.CVC=CVC;
    }

    @Override
    public String toString(){
        return email;
    }

}