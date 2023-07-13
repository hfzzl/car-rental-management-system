package com.crms.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crms.demo.DBUtil.VehicleDAO;
import com.crms.demo.model.Vehicle;

@Controller()
public class VehicleController {
    @RequestMapping(value = {"/viewAllVehicle", "/viewEditVehicle", "/viewAddVehicle"})
    public String viewManageVehicle(HttpSession session, Model mod, HttpServletRequest request) {
        VehicleDAO vechdao = new VehicleDAO();
        List<Vehicle> vList = vechdao.viewVehicle();
        mod.addAttribute("vehicle", vList);
        String url = request.getServletPath();
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            switch (url) {
                case "/viewAllVehicle":
                    return "admin/manageVehicle";
                case "/viewEditVehicle":
                    return "admin/editVehicle";
                default:
                    return "admin/addVehicle";
            }
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/addVehicle")
    public String addVehicle(HttpSession session, HttpServletRequest request, Model mod){
        Vehicle vech = new Vehicle();
        vech.setBrand(request.getParameter("brand"));
        vech.setModel(request.getParameter("model"));
        vech.setColour(request.getParameter("colour"));
        vech.setEngine(request.getParameter("engine"));
        vech.setRegistrationno(request.getParameter("regno"));
        vech.setRate(Integer.parseInt(request.getParameter("rate")));
        VehicleDAO vechdao = new VehicleDAO();
        vechdao.addVehicle(vech);  
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "redirect:/viewEditVehicle";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/viewUpdateVehicle")
    public String viewUpdateVehicle(HttpSession session, HttpServletRequest request, Model mod){
        Vehicle vech = new Vehicle();
        vech.setVehicleid(Integer.parseInt(request.getParameter("vehicleid")));
        VehicleDAO vechdao = new VehicleDAO();
        List<Vehicle> vList = vechdao.viewSelectedVehicle(vech);
        mod.addAttribute("vehicle", vList);
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "admin/updateVehicle";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/updateVehicle")
    public String updateVehicle(HttpSession session, HttpServletRequest request, Model mod){
        Vehicle vech = new Vehicle();
        vech.setVehicleid(Integer.parseInt(request.getParameter("vehicleid")));
        vech.setBrand(request.getParameter("brand"));
        vech.setModel(request.getParameter("model"));
        vech.setColour(request.getParameter("colour"));
        vech.setEngine(request.getParameter("engine"));
        vech.setRegistrationno(request.getParameter("regno"));
        vech.setRate(Integer.parseInt(request.getParameter("rate")));
        VehicleDAO vechdao = new VehicleDAO();
        vechdao.updateVehicle(vech); 
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "redirect:/viewEditVehicle";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/deleteVehicle")
    public String deleteVehicle(HttpSession session, HttpServletRequest request, Model mod){
        Vehicle vech = new Vehicle();
        vech.setVehicleid(Integer.parseInt(request.getParameter("vehicleid")));
        VehicleDAO vechdao = new VehicleDAO();
        vechdao.deleteVehicle(vech);
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "redirect:/viewEditVehicle";
        }
        else{
            return "invaliduser";
        }
    }
}