package com.crms.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crms.demo.DBUtil.PromotionDAO;
import com.crms.demo.model.Promotion;

@Controller()
public class PromotionController {
    @RequestMapping(value = {"/viewAllPromotion", "/viewEditPromotion", "/viewAddPromotion"})
    public String viewManagePromotion(HttpSession session, Model mod, HttpServletRequest request) {
        PromotionDAO promdao = new PromotionDAO();
        List<Promotion> pList = promdao.viewPromotion();
        mod.addAttribute("promotion", pList);
        String url = request.getServletPath();
        if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            switch (url) {
                case "/viewAllPromotion":
                    return "staff/managePromotion";
                case "/viewEditPromotion":
                    return "staff/editPromotion";
                default:
                    return "staff/addPromotion";
            }
        }
        else{
            return "invaliduser";
        } 
    }

    @RequestMapping(value="/addPromotion")
    public String addPromotion(HttpSession session, HttpServletRequest request, Model mod){
        Promotion prom = new Promotion();
        prom.setName(request.getParameter("name"));
        prom.setDescription(request.getParameter("description"));
        prom.setPercentage(Integer.parseInt(request.getParameter("percentage")));
        PromotionDAO promdao = new PromotionDAO();
        promdao.addPromotion(prom);  
        if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "redirect:/viewEditPromotion";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/viewUpdatePromotion")
    public String viewUpdatePromotion(HttpSession session, HttpServletRequest request, Model mod){
        Promotion prom = new Promotion();
        prom.setPromotionid(Integer.parseInt(request.getParameter("promotionid")));
        PromotionDAO promdao = new PromotionDAO();
        List<Promotion> pList = promdao.viewSelectedPromotion(prom);
        mod.addAttribute("promotion", pList);
        if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "staff/updatePromotion";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/updatePromotion")
    public String updatePromotion(HttpSession session, HttpServletRequest request, Model mod){
        Promotion prom = new Promotion();
        prom.setPromotionid(Integer.parseInt(request.getParameter("promotionid")));
        prom.setName(request.getParameter("name"));
        prom.setDescription(request.getParameter("description"));
        prom.setPercentage(Integer.parseInt(request.getParameter("percentage")));
        PromotionDAO promdao = new PromotionDAO();
        promdao.updatePromotion(prom); 
        if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "redirect:/viewEditPromotion";
        }
        else{
            return "invaliduser";
        }
    }

    @RequestMapping(value="/deletePromotion")
    public String deletePromotion(HttpSession session, HttpServletRequest request, Model mod){
        Promotion prom = new Promotion();
        prom.setPromotionid(Integer.parseInt(request.getParameter("promotionid")));
        PromotionDAO promdao = new PromotionDAO();
        promdao.deletePromotion(prom);
        if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "redirect:/viewEditPromotion";
        }
        else{
            return "invaliduser";
        }
    }
}