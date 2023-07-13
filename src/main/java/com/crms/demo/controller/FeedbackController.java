package com.crms.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crms.demo.DBUtil.FeedbackDAO;
import com.crms.demo.model.Feedback;
import com.crms.demo.model.Staff;
import com.crms.demo.model.Admin;
import com.crms.demo.model.Customer;

@Controller()
public class FeedbackController {

    @PostMapping(value="/newfeedback")
    public String feedbackPage(HttpServletRequest request, Model mod, HttpSession session) {
        Feedback fb = new Feedback();
        String fullname = null;
        fb.setFeedback(request.getParameter("feedback"));
        
        if (session.getAttribute("role") == "customer"){
            Customer cust = (Customer) session.getAttribute("cust");
            fullname = cust.getFullname();
        }
        else if(session.getAttribute("role") == "staff"){
            Staff staff = (Staff) session.getAttribute("staff");
            fullname = staff.getFullname();
        }
        else if(session.getAttribute("role") == "admin"){
            Admin admin = (Admin) session.getAttribute("admin");
            fullname = admin.getFullname();
        }
        else{
            return "invaliduser";
        }
        
        fb.setFullname(fullname);
        FeedbackDAO dao = new FeedbackDAO();
        dao.addFeedback(fb);
        
        if (session.getAttribute("role") == "customer" && session.getAttribute("status") == "success"){
            return "customer/homecustomer";
        }
        else if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "staff/homestaff";
        }
        else if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "admin/homeadmin";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/viewAllFeedback")
    public String viewFeedback(HttpSession session, Model mod) {
        FeedbackDAO feeddao = new FeedbackDAO();
        List<Feedback> fList = feeddao.viewFeedback();
        mod.addAttribute("feedback", fList);
        if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "staff/viewfeedbackstaff";
        }
        else if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
            return "admin/viewfeedbackadmin";
        }
        else{
            return "invaliduser";
        }
    }
}