package com.crms.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crms.demo.DBUtil.StaffDAO;
import com.crms.demo.model.Staff;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class StaffController {
    @RequestMapping(value="/profileStaff")
    public String viewProfile(HttpSession session, HttpServletRequest request, Model mod){
        Staff staff = new Staff();
        staff.setUserid((int) session.getAttribute("userid"));
        StaffDAO staffdao= new StaffDAO();
        List<Staff> staffInfo = staffdao.viewProfile(staff);
        
        mod.addAttribute("detailS", staffInfo);
        
        return "Staff/viewProfileStaff";
    }

    @RequestMapping(value="/viewUpdateProfileStaff")
    public String viewUpdateProfileStaff(HttpSession session, HttpServletRequest request, Model mod){
        Staff staff = new Staff();
        staff.setUserid((int) session.getAttribute("userid"));
        StaffDAO staffdao= new StaffDAO();
        List<Staff> staffInfo = staffdao.viewProfile(staff);
        
        mod.addAttribute("detailS", staffInfo);
        if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "staff/updateProfileStaff";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/viewUpdateAddressStaff")
    public String viewUpdateAddressStaff(HttpSession session, HttpServletRequest request, Model mod){
        Staff staff = new Staff();
        staff.setUserid((int) session.getAttribute("userid"));
        StaffDAO staffdao= new StaffDAO();
        List<Staff> staffInfo = staffdao.viewProfile(staff);
        
        mod.addAttribute("detailS", staffInfo);
        if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "staff/updateAddressStaff";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/updateProfileStaff")
    public String updateProfileStaff(HttpSession session, HttpServletRequest request, Model mod){
        Staff staff = new Staff();
        staff.setUserid((int) session.getAttribute("userid"));
        staff.setFullname(request.getParameter("fullname"));
        staff.setBirthdate(request.getParameter("birthdate"));
        staff.setPhone_no(Integer.parseInt(request.getParameter("phoneNo")));
        staff.setEmail(request.getParameter("email"));
        StaffDAO staffdao = new StaffDAO();
        staffdao.updateProfileStaff(staff); 
        if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "redirect:/profileStaff";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/updateAddressStaff")
    public String updateAddress(HttpSession session, HttpServletRequest request, Model mod){
        Staff staff = new Staff();
        staff.setUserid((int) session.getAttribute("userid"));
        staff.setAddressL1(request.getParameter("addressL1"));
        staff.setAddressL2(request.getParameter("addressL2"));
        staff.setAddressL3(request.getParameter("addressL3"));
        staff.setPostcode(request.getParameter("postcode"));
        staff.setCity(request.getParameter("city"));
        staff.setState(request.getParameter("state"));
        StaffDAO staffdao = new StaffDAO();
        staffdao.updateAddress(staff); 
        if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "redirect:/profileStaff";
        }
        else{
            return "invaliduser";
        }
    }
    
}
