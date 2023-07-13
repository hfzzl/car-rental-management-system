package com.crms.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crms.demo.DBUtil.AdminDAO;
import com.crms.demo.DBUtil.CustomerDAO;
import com.crms.demo.DBUtil.StaffDAO;
import com.crms.demo.model.Admin;
import com.crms.demo.model.Customer;
import com.crms.demo.model.Staff;

@Controller()
public class LoginController {
	
	@RequestMapping(value="/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value="/register")
	public String registerPage() {
		return "Registration";
	}


	@RequestMapping(value="/index")
	public String login(HttpServletRequest request, Model mod, HttpSession session){
		
		//read parameter value
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userType = request.getParameter("usertype");
		
		//set initial null value
		Customer cust = null;
		Staff staff = null;
		Admin admin = null;

		//call DAO based on userype
		if(userType.equals("customer")){
			cust = CustomerDAO.authenticate(username, password);
		}
		else if(userType.equals("staff")){
			staff = StaffDAO.authenticate(username, password);
		}
		else if(userType.equals("admin")){
			admin = AdminDAO.authenticate(username, password);
		}

		//Populate model and session with data
		if (cust != null){
			mod.addAttribute("cust", cust);
			session.getId();
			session.setAttribute("cust", cust);
            session.setAttribute("role", "customer");
			session.setAttribute("userid", cust.getUserid());
            session.setAttribute("username", cust.getUsername());
            session.setAttribute("status", "success");
			if(session.getAttribute("role") == "customer" && session.getAttribute("status") == "success"){
				return "customer/homecustomer";
			}
			else{
				return "invaliduser";
			}
		}
		else if(staff != null){
			mod.addAttribute("staff", staff);
			session.setAttribute("staff", staff);
			session.setAttribute("role", "staff");
			session.setAttribute("userid", staff.getUserid());
			session.setAttribute("username", staff.getUsername());
			session.setAttribute("status", "success");
			if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
				return "staff/homestaff";
			}
			else{
				return "invaliduser";
			}
		}
		else if(admin != null){
			mod.addAttribute("admin", admin);
			session.setAttribute("admin", admin);
			session.setAttribute("role", "admin");
			session.setAttribute("userid", admin.getUserid());
			session.setAttribute("username", admin.getUsername());
			session.setAttribute("status", "success");
			if(session.getAttribute("role") == "admin" && session.getAttribute("status") == "success"){
				return "admin/homeadmin";
			}
			else{
				return "invaliduser";
			}
		}
		else if (admin == null && staff == null && cust == null){
			session.setAttribute("status", "failed");
			mod.addAttribute("errorMessage", "Invalid username or password!");
		}
		return "login";
	}
}