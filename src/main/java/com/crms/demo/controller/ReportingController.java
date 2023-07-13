package com.crms.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crms.demo.DBUtil.ReportingDAO;
import com.crms.demo.model.Reporting;


// import com.crms.demo.DBUtil.PaymentDAO;
// import com.crms.demo.model.PaymentDetail;

@Controller
public class ReportingController {

    @PostMapping(value = "/addreporting")
    public String addReporting(HttpServletRequest request, Model mod, HttpSession session) {
        Reporting rc = new Reporting();
        // rc.setreportingid((int)session.getAttribute("reportingid"));
        rc.setDsales(request.getParameter("Dsales"));
        rc.setNDcust(request.getParameter("NDcust"));
        rc.setADcust(request.getParameter("ADcust"));
        rc.setMsales(request.getParameter("Msales"));
        rc.setNMcust(request.getParameter("NMcust"));
        rc.setAMcust(request.getParameter("AMcust"));
        rc.setachievements(request.getParameter("achievements"));

        ReportingDAO reportingDAO = new ReportingDAO();
        reportingDAO.addReporting(rc);
        return "admin/adminviewreportingpage";
    }

    @RequestMapping(value="/getreport")
    public String viewAdminReportingPage(HttpSession session, Model mod, HttpServletRequest request) {
        Reporting reporting = new Reporting();
        // reporting.setreportingid((int) session.getAttribute("reportingid"));
       
        ReportingDAO reportingDAO = new ReportingDAO();
        List<Reporting> rList = reportingDAO.viewadminreportingpage(reporting);
        mod.addAttribute("reporting",rList);
        System.out.println(rList);
        if(session.getAttribute("role").equals("admin") && session.getAttribute("status").equals("success")){
            return "admin/adminformreportingpage";
        }
        else if(session.getAttribute("role").equals("staff") && session.getAttribute("status").equals("success")){
            return "staff/staffviewreportingpage";
        }
        else{
            return "invaliduser";
        } 
    }    
}