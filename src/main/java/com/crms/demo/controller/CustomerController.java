package com.crms.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crms.demo.DBUtil.CustomerDAO;
import com.crms.demo.model.Customer;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {
    @RequestMapping(value="/addCust")
    public String addCust(HttpSession session, HttpServletRequest request, Model mod){
        Customer cust = new Customer();
        cust.setFullname(request.getParameter("fullname"));
        cust.setBirthdate(request.getParameter("birthdate"));
        cust.setPhone_no(Integer.parseInt(request.getParameter("phoneNo")));
        cust.setEmail(request.getParameter("email"));
        cust.setAddressL1(request.getParameter("addressL1"));
        cust.setAddressL2(request.getParameter("addressL2"));
        cust.setAddressL3(request.getParameter("addressL3"));
        cust.setPostcode(request.getParameter("postcode"));
        cust.setCity(request.getParameter("city"));
        cust.setState(request.getParameter("state"));
        cust.setUsername(request.getParameter("username"));
        cust.setPassword(request.getParameter("password"));
        CustomerDAO custdao= new CustomerDAO();
        custdao.addCust(cust);
        return "redirect:/login";
    }

    @RequestMapping(value="/profileCust")
    public String viewProfile(HttpSession session, HttpServletRequest request, Model mod){
        Customer cust = new Customer();
        cust.setUserid((int) session.getAttribute("userid"));
        CustomerDAO custdao= new CustomerDAO();
        List<Customer> custInfo = custdao.viewProfile(cust);
        
        mod.addAttribute("detailC", custInfo);
        
        return "Customer/viewProfileCust";
    }
    @RequestMapping(value="/viewUpdateProfileCust")
    public String viewUpdateProfileCust(HttpSession session, HttpServletRequest request, Model mod){
        Customer cust = new Customer();       
        cust.setUserid((int) session.getAttribute("userid"));
        CustomerDAO custdao= new CustomerDAO();
        List<Customer> custInfo = custdao.viewProfile(cust);
        
        mod.addAttribute("detailC", custInfo);
        if(session.getAttribute("role") == "customer" && session.getAttribute("status") == "success"){
            return "Customer/updateProfileCust";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/updateProfileCust")
    public String updateProfileCust(HttpSession session, HttpServletRequest request, Model mod){
        Customer cust = new Customer();  
        cust.setUserid((int) session.getAttribute("userid"));
        cust.setFullname(request.getParameter("fullname"));
        cust.setBirthdate(request.getParameter("birthdate"));
        cust.setPhone_no(Integer.parseInt(request.getParameter("phoneNo")));
        cust.setEmail(request.getParameter("email"));
        CustomerDAO custdao= new CustomerDAO();
        custdao.updateProfileCust(cust); 
        if(session.getAttribute("role") == "customer" && session.getAttribute("status") == "success"){
            return "redirect:/profileCust";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/viewUpdateAddressCust")
    public String viewUpdateAddressCust(HttpSession session, HttpServletRequest request, Model mod){
        Customer cust = new Customer();       
        cust.setUserid((int) session.getAttribute("userid"));
        CustomerDAO custdao= new CustomerDAO();
        List<Customer> custInfo = custdao.viewProfile(cust);
        
        mod.addAttribute("detailC", custInfo);
        if(session.getAttribute("role") == "customer" && session.getAttribute("status") == "success"){
            return "customer/updateAddressCust";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/updateAddressCust")
    public String updateAddress(HttpSession session, HttpServletRequest request, Model mod){
        Customer cust = new Customer();
        cust.setUserid((int) session.getAttribute("userid"));
        cust.setAddressL1(request.getParameter("addressL1"));
        cust.setAddressL2(request.getParameter("addressL2"));
        cust.setAddressL3(request.getParameter("addressL3"));
        cust.setPostcode(request.getParameter("postcode"));
        cust.setCity(request.getParameter("city"));
        cust.setState(request.getParameter("state"));
        CustomerDAO custdao = new CustomerDAO();
        custdao.updateAddress(cust); 
        if(session.getAttribute("role") == "customer" && session.getAttribute("status") == "success"){
            return "redirect:/profileCust";
        }
        else{
            return "invaliduser";
        }
    }
}
