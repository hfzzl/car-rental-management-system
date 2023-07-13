package com.crms.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crms.demo.DBUtil.VehicleConditionDAO;
import com.crms.demo.model.VehicleCondition;

@Controller
public class VehicleConditionController {
    @RequestMapping(value={"/vehiclecondition", "/viewEditVehicleCondition", "/viewAddVehicleCondition"})
    public String viewVehicleConditionPage(HttpSession session, Model mod, HttpServletRequest request) {
        VehicleConditionDAO vechconddao = new VehicleConditionDAO();
        List<VehicleCondition> vcList = vechconddao.viewVehicleCondition();
        mod.addAttribute("vehicleCondition", vcList);
        System.out.println(vcList);
        String url = request.getServletPath();
        if(session.getAttribute("role").equals("staff") && session.getAttribute("status").equals("success")){
            switch (url) {
                case "/vehiclecondition":
                    return "staff/manageVehicleCondition";
                case "/viewEditVehicleCondition":
                    return "staff/editVehicleCondition";
                default:
                    return "staff/addVehicleCondition";
            }
        }
        else{
            return "invaliduser";
        } 

    }    

    @PostMapping(value = "/addVehicleCondition")
    public String VehicleConditionPage(HttpServletRequest request, Model mod, HttpSession session) {
        VehicleCondition vc = new VehicleCondition();
        vc.setVehicleCondition(request.getParameter("Condition"));
        vc.setAction(request.getParameter("Action"));
        vc.setActionDate(request.getParameter("ActionDate"));

        VehicleConditionDAO vechconddao = new VehicleConditionDAO();
        vechconddao.addVehicleCondition(vc);
        if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "redirect:/viewEditVehicleCondition";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/viewUpdateVehicleCondition")
    public String viewUpdateVehicleCondition(HttpSession session, HttpServletRequest request, Model mod){
        VehicleCondition vc = new VehicleCondition();
        vc.setVehicleConditionID(Integer.parseInt(request.getParameter("VehicleConditionID")));
        VehicleConditionDAO vechconddao = new VehicleConditionDAO();
        List<VehicleCondition> vList = vechconddao.viewSelectedVehicleCondition(vc);
        mod.addAttribute("vehicle", vList);
        if(session.getAttribute("role") == "staff" && session.getAttribute("status").equals("success")){
            return "staff/updateVehicleCondition";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/updateVehicleCondition")
    public String updateVehicleCondition(HttpSession session, HttpServletRequest request, Model mod){
        VehicleCondition vc = new VehicleCondition();
        vc.setVehicleConditionID(Integer.parseInt(request.getParameter("VehicleConditionID")));
        vc.setVehicleCondition(request.getParameter("VehicleCondition"));
        vc.setAction(request.getParameter("Action"));
        vc.setActionDate(request.getParameter("ActionDate"));
        VehicleConditionDAO vechconddao = new VehicleConditionDAO();
        vechconddao.updateVehicleCondition(vc); 
        if(session.getAttribute("role") == "staff" && session.getAttribute("status").equals("success")){
            return "redirect:/viewEditVehicleCondition";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/deleteVehicleCondition")
    public String deleteVehicleCondition(HttpSession session, HttpServletRequest request, Model mod){
        VehicleCondition vech = new VehicleCondition();
        vech.setVehicleConditionID(Integer.parseInt(request.getParameter("VehicleConditionID")));
        VehicleConditionDAO vechdao = new VehicleConditionDAO();
        vechdao.deleteVehicleCondition(vech);
        if(session.getAttribute("role") == "staff" && session.getAttribute("status").equals("success")){
            return "redirect:/viewEditVehicleCondition";
        }
        else{
            return "invaliduser";
        }
    }
}