package com.crms.demo.model;

public class VehicleCondition {
    int VehicleConditionID;
    String VehicleCondition; 
    String Action;
    String ActionDate;


    public VehicleCondition(){
    }

    public VehicleCondition(int VehicleConditionID, String VehicleCondition, String Action, String ActionDate){

        this.VehicleConditionID = VehicleConditionID;
        this.VehicleCondition = VehicleCondition;
        this.Action = Action;
        this.ActionDate = ActionDate;
    }

    //accessors and mutators methods
    public int getVehicleConditionID() {
        return VehicleConditionID;
    }
    public void setVehicleConditionID(int VehicleConditionID) {
        this.VehicleConditionID = VehicleConditionID;
    }
    public String getVehicleCondition() {
        return VehicleCondition;
    }
    public void setVehicleCondition(String VehicleCondition) {
        this.VehicleCondition = VehicleCondition;
    }
    public String getAction() {
        return Action;
    }
    public void setAction(String Action) {
        this.Action = Action;
    }
    public String getActionDate() {
        return ActionDate;
    }
    public void setActionDate(String ActionDate) {
        this.ActionDate = ActionDate;
    }
}