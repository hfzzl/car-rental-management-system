package com.crms.demo.model;

public class Promotion {
    private int promotionid;
    private String name;
    private String description;
    private int percentage;
    
    public Promotion(){
    }

    //promotion constructor
    public Promotion(int promotionid, String name, String description, int percentage){
        this.promotionid = promotionid;
        this.name = name;
        this.description = description;
        this.percentage = percentage;
    }

    //accessor and mutator methods
    public int getPromotionid(){
        return promotionid;
    }
    public void setPromotionid(int promotionid){
        this.promotionid = promotionid;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public int getPercentage(){
        return percentage;
    }
    public void setPercentage(int percentage){
        this.percentage = percentage;
    }

    //tostring
    @Override
    public String toString(){
        return "Promotion [promotionid=" + promotionid + ", name=" + name + ", description=" + description + ", percentage=" + percentage + "]";
    }
}
