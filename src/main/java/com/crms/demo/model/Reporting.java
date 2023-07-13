package com.crms.demo.model;

public class Reporting {
    int reportingid;
    String Dsales;
    String NDcust;
    String ADcust;
    String Msales;
    String NMcust;
    String AMcust;
    String achievements;

public Reporting(){

}

    public Reporting(int reportingid,String Dsales,String NDcust,String ADcust,String Msales,String NMcust,String AMcust,String achievements) {
        this.reportingid = reportingid;
        this.Dsales = Dsales;
        this.NDcust = NDcust;
        this.ADcust = ADcust;
        this.Msales = Msales;
        this.NMcust = NMcust;
        this.AMcust = AMcust;
        this.achievements = achievements;
    }

    public void setreportingid(int reportingid){
		this.reportingid = reportingid;
	}
    public int getUserid() {
        return reportingid;
    }

    public String getDsales(){
        return Dsales;
    }

    public void setDsales(String Dsales){
        this.Dsales=Dsales;
    }

    public String getNDcust(){
        return NDcust;
    }

    public void setNDcust(String NDcust){
        this.NDcust=NDcust;
    }

    public String getADcust(){
        return ADcust;
    }

    public void setADcust(String ADcust){
        this.ADcust=ADcust;
    }

    public String getMsales(){
        return Msales;
    }

    public void setMsales(String Msales){
        this.Msales=Msales;
    }

    public String getNMcust(){
        return NMcust;
    }

    public void setNMcust(String NMcust){
        this.NMcust=NMcust;
    }

    public String getAMcust(){
        return AMcust;
    }

    public void setAMcust(String AMcust){
        this.AMcust=AMcust;
    }

    public String getachievements(){
        return achievements;
    }

    public void setachievements(String achievements){
        this.achievements = achievements;
    }

    public String getreportingid() {
        return null;
    }
}
