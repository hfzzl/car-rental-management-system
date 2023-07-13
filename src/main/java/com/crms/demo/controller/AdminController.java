package com.crms.demo.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.crms.demo.DBUtil.AdminDAO;
import com.crms.demo.DBUtil.StaffDAO;
import com.crms.demo.model.Admin;
import com.crms.demo.model.Staff;



@Controller
public class AdminController {
    @RequestMapping(value= {"/viewAllAdmin", "/viewAllStaff", "/viewEditAdmin", "/viewAddAdmin", "/viewEditStaff", "/viewAddStaff"})
    public String viewAllAdmin(HttpSession session, HttpServletRequest request, Model mod){
        AdminDAO admindao= new AdminDAO();
        List<Admin> aList = admindao.viewAdminList();
        mod.addAttribute("admin", aList);

        StaffDAO staffdao= new StaffDAO();
        List<Staff> sList = staffdao.viewStaffList();
        mod.addAttribute("staff", sList);

        String url = request.getServletPath();
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            // return "admin/viewAdmin";
            switch (url) {
                case "/viewAllAdmin":
                    return "admin/viewAdmin";
                case "/viewAllStaff":
                    return "admin/viewStaff";
                case "/viewEditAdmin":
                    return "admin/editAdmin";
                case "/viewAddAdmin":
                    return "admin/addAdmin";
                case "/viewEditStaff":
                    return "admin/editStaff";
                default:
                    return "admin/addStaff";
            }
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/viewUpdateAdmin")
    public String viewUpdateVehicle(HttpSession session, HttpServletRequest request, Model mod){
        Admin admin = new Admin();
        admin.setUserid(Integer.parseInt(request.getParameter("userid")));
        AdminDAO admindao = new AdminDAO();
        List<Admin> aList = admindao.viewSelectedAdmin(admin);
        mod.addAttribute("admin", aList);
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "admin/updateAdminData";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/viewUpdateStaff")
    public String viewUpdateStaff(HttpSession session, HttpServletRequest request, Model mod){
        Staff staff = new Staff();
        staff.setUserid(Integer.parseInt(request.getParameter("userid")));
        StaffDAO staffdao = new StaffDAO();
        List<Staff> sList = staffdao.viewSelectedStaff(staff);
        mod.addAttribute("staff", sList);
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "admin/updateStaffData";
        }
        else{
            return "invaliduser";
        }
    }
    // @RequestMapping(value="/viewAllStaff")
    // public String viewAllStaff(HttpSession session, HttpServletRequest request, Model mod){
    //     StaffDAO staffdao= new StaffDAO();
    //     List<Staff> sList = staffdao.viewStaffList();
    //     mod.addAttribute("staff", sList);
    //     if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
    //         return "admin/viewStaff";
    //     }
    //     else{
    //         return "invaliduser";
    //     }
    // }

    @RequestMapping(value="/profileAdmin")
    public String viewProfile(HttpSession session, HttpServletRequest request, Model mod){
        Admin admin = new Admin();
        admin.setUserid((int) session.getAttribute("userid"));
        AdminDAO admindao= new AdminDAO();
        List<Admin> adminInfo = admindao.viewProfile(admin);
        
        mod.addAttribute("detail", adminInfo);
        
        return "admin/viewprofileadmin";
    }


    @RequestMapping(value="/viewUpdateProfile")
    public String viewUpdateProfile(HttpSession session, HttpServletRequest request, Model mod){
        Admin admin = new Admin();
        admin.setUserid((int) session.getAttribute("userid"));
        AdminDAO admindao= new AdminDAO();
        List<Admin> adminInfo = admindao.viewProfile(admin);
        
        mod.addAttribute("detail", adminInfo);
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "admin/updateProfileAdmin";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/viewUpdateAddress")
    public String viewUpdateAdress(HttpSession session, HttpServletRequest request, Model mod){
        Admin admin = new Admin();
        admin.setUserid((int) session.getAttribute("userid"));
        AdminDAO admindao= new AdminDAO();
        List<Admin> adminInfo = admindao.viewProfile(admin);
        
        mod.addAttribute("detail", adminInfo);
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "admin/updateAddressAdmin";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/updateAdmin")
    public String updateVehicle(HttpSession session, HttpServletRequest request, Model mod){
        Admin admin = new Admin();
        admin.setUserid(Integer.parseInt(request.getParameter("userid")));
        admin.setFullname(request.getParameter("fullname"));
        admin.setPhone_no(Integer.parseInt(request.getParameter("phone_no")));
        admin.setEmail(request.getParameter("email"));
        admin.setAddressL1(request.getParameter("addressL1"));
        admin.setAddressL2(request.getParameter("addressL2"));
        admin.setAddressL3(request.getParameter("addressL3"));
        admin.setPostcode(request.getParameter("postcode"));
        admin.setCity(request.getParameter("city"));
        admin.setState(request.getParameter("state"));
        AdminDAO admindao = new AdminDAO();
        admindao.updateAdmin(admin); 
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "redirect:/viewEditAdmin";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/updateStaff")
    public String updateStaff(HttpSession session, HttpServletRequest request, Model mod){
        Staff staff = new Staff();
        staff.setUserid(Integer.parseInt(request.getParameter("userid")));
        staff.setFullname(request.getParameter("fullname"));
        staff.setPhone_no(Integer.parseInt(request.getParameter("phone_no")));
        staff.setEmail(request.getParameter("email"));
        staff.setAddressL1(request.getParameter("addressL1"));
        staff.setAddressL2(request.getParameter("addressL2"));
        staff.setAddressL3(request.getParameter("addressL3"));
        staff.setPostcode(request.getParameter("postcode"));
        staff.setCity(request.getParameter("city"));
        staff.setState(request.getParameter("state"));
        StaffDAO staffdao = new StaffDAO();
        staffdao.updateStaff(staff); 
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "redirect:/viewEditStaff";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/addAdmin")
    public String addAdmin(HttpSession session, HttpServletRequest request, Model mod){
        Admin admin = new Admin();
        admin.setUsername(request.getParameter("username"));
        admin.setPassword(request.getParameter("password"));
        admin.setFullname(request.getParameter("fullname"));
        admin.setBirthdate(request.getParameter("birthdate"));
        admin.setPhone_no(Integer.parseInt(request.getParameter("phone_no")));
        admin.setEmail(request.getParameter("email"));
        admin.setAddressL1(request.getParameter("addressL1"));
        admin.setAddressL2(request.getParameter("addressL2"));
        admin.setAddressL3(request.getParameter("addressL3"));
        admin.setPostcode(request.getParameter("postcode"));
        admin.setCity(request.getParameter("city"));
        admin.setState(request.getParameter("state"));
        AdminDAO admindao = new AdminDAO();
        admindao.addAdmin(admin); 
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "redirect:/viewEditAdmin";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/addStaff")
    public String addStaff(HttpSession session, HttpServletRequest request, Model mod){
        Staff staff = new Staff();
        staff.setUsername(request.getParameter("username"));
        staff.setPassword(request.getParameter("password"));
        staff.setFullname(request.getParameter("fullname"));
        staff.setBirthdate(request.getParameter("birthdate"));
        staff.setPhone_no(Integer.parseInt(request.getParameter("phone_no")));
        staff.setEmail(request.getParameter("email"));
        staff.setAddressL1(request.getParameter("addressL1"));
        staff.setAddressL2(request.getParameter("addressL2"));
        staff.setAddressL3(request.getParameter("addressL3"));
        staff.setPostcode(request.getParameter("postcode"));
        staff.setCity(request.getParameter("city"));
        staff.setState(request.getParameter("state"));
        StaffDAO staffdao = new StaffDAO();
        staffdao.addStaff(staff); 
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "redirect:/viewEditStaff";
        }
        else{
            return "invaliduser";
        }
    }

    

    @RequestMapping(value="/updateProfile")
    public String updateProfile(HttpSession session, HttpServletRequest request, Model mod){
        Admin admin = new Admin();
        admin.setUserid((int) session.getAttribute("userid"));
        admin.setFullname(request.getParameter("fullname"));
        admin.setBirthdate(request.getParameter("birthdate"));
        admin.setPhone_no(Integer.parseInt(request.getParameter("phoneNo")));
        admin.setEmail(request.getParameter("email"));
        AdminDAO admindao = new AdminDAO();
        admindao.updateProfile(admin); 
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "redirect:/profileAdmin";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/updateAddress")
    public String updateAddress(HttpSession session, HttpServletRequest request, Model mod){
        Admin admin = new Admin();
        admin.setUserid((int) session.getAttribute("userid"));
        admin.setAddressL1(request.getParameter("addressL1"));
        admin.setAddressL2(request.getParameter("addressL2"));
        admin.setAddressL3(request.getParameter("addressL3"));
        admin.setPostcode(request.getParameter("postcode"));
        admin.setCity(request.getParameter("city"));
        admin.setState(request.getParameter("state"));
        AdminDAO admindao = new AdminDAO();
        admindao.updateAddress(admin); 
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "redirect:/profileAdmin";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/deleteAdmin")
    public String deleteAdmin(HttpSession session, HttpServletRequest request, Model mod){
        Admin admin = new Admin();
        admin.setUserid(Integer.parseInt(request.getParameter("userid")));
        AdminDAO admindao = new AdminDAO();
        admindao.deleteAdmin(admin);
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "redirect:/viewEditAdmin";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/deleteStaff")
    public String deleteVehicle(HttpSession session, HttpServletRequest request, Model mod){
        Staff staff = new Staff();
        staff.setUserid(Integer.parseInt(request.getParameter("userid")));
        StaffDAO staffdao = new StaffDAO();
        staffdao.deleteStaff(staff);
        if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "redirect:/viewEditStaff";
        }
        else{
            return "invaliduser";
        }
    }

}
