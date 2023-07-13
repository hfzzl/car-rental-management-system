package com.crms.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crms.demo.DBUtil.PaymentDAO;
import com.crms.demo.model.PaymentDetail;

@Controller
public class PaymentController {

    @RequestMapping(value="/viewPaymentOptionPage")
    public String viewPaymentOptionPage(HttpSession session) {
        if((session.getAttribute("role") == "customer" || session.getAttribute("role") == "staff") && session.getAttribute("status") == "success"){
            return "customer/paymentOptionPage";
        }
        else if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "staff/paymentOptionPage";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/viewonlinePaymentPage")
    public String viewOnlinePayment(HttpSession session) {
        if(session.getAttribute("role") == "customer" && session.getAttribute("status") == "success"){
            return "customer/onlinePaymentPage";
        }
        else if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "staff/onlinePaymentPage";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/viewpaymentFormPage")
    public String viewpaymentFormPage(HttpSession session) {
        if(session.getAttribute("role") == "customer" && session.getAttribute("status") == "success"){
            return "customer/paymentFormPage";
        }
        else if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "staff/paymentFormPage";
        }
        else{
            return "invaliduser";
        }
    }

    @PostMapping(value="/addPayment")
    public String paymentPage(HttpServletRequest request, Model mod, HttpSession session) {
        PaymentDetail p = new PaymentDetail();
        p.setCHname(request.getParameter("CHname"));
        p.setEmail(request.getParameter("email"));
        p.setCnum(Integer.parseInt(request.getParameter("Cnum")));
        p.setExpMonth(request.getParameter("ExpMonth"));
        p.setExpYear(request.getParameter("ExpYear"));
        p.setCVC(Integer.parseInt(request.getParameter("CVC")));

        PaymentDAO paydao = new PaymentDAO();
        paydao.addPayment(p);
        if(session.getAttribute("role") == "customer" && session.getAttribute("status") == "success"){
            return "customer/homecustomer";
        }
        else if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "staff/homestaff";
        }
        else{
            return "invaliduser";
        } 
    }

    @RequestMapping(value = "/viewPayment")
    public String viewPayment(HttpSession session, Model mod, HttpServletRequest request) {
        PaymentDAO paymentDAO = new PaymentDAO();
        List<PaymentDetail> pList = paymentDAO.viewPayment();
        mod.addAttribute("payment", pList);
        if(session.getAttribute("role") == "customer" && session.getAttribute("status") == "success"){
            return "customer/viewPayment"; 
        }
        else{
            return "invaliduser";
        }
    }
}