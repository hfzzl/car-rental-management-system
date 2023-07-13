package com.crms.demo.controller;

import com.crms.demo.DBUtil.BookingDAO;
import com.crms.demo.DBUtil.CustomerDAO;
import com.crms.demo.DBUtil.VehicleDAO;
import com.crms.demo.model.Booking;
import com.crms.demo.model.Customer;
import com.crms.demo.model.Vehicle;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookingController{


  @RequestMapping(value = { "/viewAllBooking", "/viewEditBooking", "/viewUpdateBooking"})
  public String viewManageBooking(HttpSession session, Model mod, HttpServletRequest request) {
    BookingDAO bookingDAO = new BookingDAO();
    List<Booking> bList = bookingDAO.getAllBookingsList();
    // System.out.println("bList");
    // System.out.println(bList);
    mod.addAttribute("bookingList", bList);
    System.out.println(mod.getAttribute("bookingList"));
    System.out.println(bList.get(0).getCustname());
    System.out.println(bList.toString());

        String url = request.getServletPath();
    if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
        switch (url) {
            case "/viewAllBooking":
                return "staff/managebooking";
            case "/viewUpdateBooking":
                return "staff/updatebooking";
            default:
                return "staff/editbooking";
        }
    }
    else{
        return "invaliduser";
    } 
}


  @RequestMapping(value={"/bookingCust", "/bookingStaff"})
  public String viewBookingStaffs(HttpSession session, Model mod, HttpServletRequest request) {
      Customer cust = new Customer();
      cust.setUserid((int) session.getAttribute("userid")); 
      VehicleDAO vechdao = new VehicleDAO();
      List<Vehicle> vList = vechdao.viewVehicle();
      CustomerDAO custdao = new CustomerDAO();
      List<Customer> cList = custdao.viewProfile(cust);
      mod.addAttribute("vehicle", vList);
      mod.addAttribute("detailC", cList);

      if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
          return "staff/bookStaff";
      }
      else if(session.getAttribute("role") == "customer" && session.getAttribute("status") == "success"){
          return "customer/bookCust";
      }
      else{
          return "invaliduser";
      }
    }

    @RequestMapping(value="/addBookingStaff")
    public String addBooking(HttpSession session, HttpServletRequest request, Model mod){
        Booking b = new Booking();
        Vehicle v = new Vehicle();
        
        v.setVehicleid(Integer.parseInt(request.getParameter("radio-overview-custom")));
        System.out.println(v.getVehicleid());
        VehicleDAO vechdao = new VehicleDAO();

        List<Vehicle> vList = vechdao.viewSelectedVehicle(v);
        int rate=vList.get(0).getRate();
        b.setCustname(request.getParameter("custName"));
        b.setCustPhoneno(Integer.parseInt(request.getParameter("custPhoneNo")));
        b.setCustemail(request.getParameter("custEmail"));
        b.setVehicleid(Integer.parseInt(request.getParameter("radio-overview-custom")));
        b.setPDate(request.getParameter("pDate"));
        b.setPTime(request.getParameter("pTime"));
        b.setPStatus(request.getParameter("pStatus"));
        b.setRDate(request.getParameter("rDate"));
        b.setRTime(request.getParameter("rTime"));
        b.setRStatus(request.getParameter("rStatus"));
        b.setHours(Integer.parseInt(request.getParameter("timeDifference")));
        b.setPrice(b.getHours()*rate);
        session.setAttribute("price", b.getPrice() );
        BookingDAO bookingdao = new BookingDAO();
        bookingdao.addBooking(b); 
        // BookingDAO bookingdao = new BookingDAO();
        // List<Booking> booking = bookingdao.addBooking(b); 

        // mod.addAttribute("bookingDet", booking);

        if(session.getAttribute("role") == "staff" && session.getAttribute("status") == "success"){
            return "staff/paymentOptionPage";
        }
        else{
            return "invaliduser";
        }
    }

  @RequestMapping(value = "/addBookingCustomer")
  public String addBookingCustomer(
    HttpSession session,
    HttpServletRequest request,
    Model mod
  ) {
    Booking b = new Booking();
        Vehicle v = new Vehicle();
        
        v.setVehicleid(Integer.parseInt(request.getParameter("radio-overview-custom")));
        System.out.println(v.getVehicleid());
        VehicleDAO vechdao = new VehicleDAO();

        List<Vehicle> vList = vechdao.viewSelectedVehicle(v);
        int rate=vList.get(0).getRate();
        b.setCustname(request.getParameter("fullname"));
        b.setCustPhoneno(Integer.parseInt(request.getParameter("phoneNo")));
        b.setCustemail(request.getParameter("email"));
        b.setVehicleid(Integer.parseInt(request.getParameter("radio-overview-custom")));
        b.setPDate(request.getParameter("pDate"));
        b.setPTime(request.getParameter("pTime"));
        b.setPStatus(request.getParameter("pStatus"));
        b.setRDate(request.getParameter("rDate"));
        b.setRTime(request.getParameter("rTime"));
        b.setRStatus(request.getParameter("rStatus"));
        b.setHours(Integer.parseInt(request.getParameter("timeDifference")));
        b.setPrice(b.getHours()*rate);
        session.setAttribute("price", b.getPrice() );
        BookingDAO bookingdao = new BookingDAO();
        bookingdao.addBooking(b); 

    // Booking booking = new Booking();
    // booking.setCustname(request.getParameter("fullname"));    
    // booking.setVehicleid(Integer.parseInt(request.getParameter("radio-overview-custom")));
    // booking.setCustPhoneno(Integer.parseInt(request.getParameter("phoneNo")));
    // booking.setCustemail(request.getParameter("email"));
    // booking.setPDate(request.getParameter("pDate"));
    // booking.setPTime(request.getParameter("pTime"));
    // booking.setPStatus(request.getParameter("pStatus"));
    // booking.setRDate(request.getParameter("rDate"));
    // booking.setRTime(request.getParameter("rTime"));
    // booking.setRStatus(request.getParameter("rStatus"));
    // booking.setVoucher(request.getParameter("bookingvoucher"));
    // booking.setHours(Integer.parseInt(request.getParameter("timeDifference")));
    // BookingDAO bookingDAO = new BookingDAO();
    // bookingDAO.addBooking(booking);
    if (session.getAttribute("role") == ("staff") && session.getAttribute("status") == ("success")) {
      return "staff/paymentOptionPage";
    } 
    else if (session.getAttribute("role") == ("customer") && session.getAttribute("status") == ("success")) {
      return "customer/paymentOptionPage";
    }
    else {
      return "invaliduser";
    }
  }

  @RequestMapping(value = "/editBooking")
  public String editBooking(
    HttpSession session,
    HttpServletRequest request,
    Model mod
  ) {
    Booking booking = new Booking();
    
    booking.setBookingid(Integer.parseInt(request.getParameter("bookingid")));
    // booking.setVehicleid(Integer.parseInt(request.getParameter("vehicleid")));
    // booking.setPDate(request.getParameter("pDate"));
    // booking.setRDate(request.getParameter("rDate"));
    // booking.setPTime(request.getParameter("pTime"));
    // booking.setRTime(request.getParameter("rTime"));
    System.out.println("masuk siniii");
    booking.setPStatus(request.getParameter("pStatus"));
    booking.setRStatus(request.getParameter("rStatus"));
    // System.out.println(booking.getPStatus());
    BookingDAO bookingDAO = new BookingDAO();
    bookingDAO.updateBooking(booking);
    if (session.getAttribute("role").equals("staff") && session.getAttribute("status").equals("success")
    ) {
      return "redirect:/viewAllBooking";
    } else {
      return "invaliduser";
    }
  }

  @RequestMapping(value = "/deleteBooking")
  public String deleteBooking(
    HttpSession session,
    HttpServletRequest request,
    Model mod
  ) {
    Booking booking = new Booking();
    booking.setBookingid(Integer.parseInt(request.getParameter("bookingId")));
    BookingDAO bookingDAO = new BookingDAO();
    bookingDAO.deleteBooking(booking);
    if (
      session.getAttribute("role").equals("staff") &&
      session.getAttribute("status").equals("success")
    ) {
      return "redirect:/viewUpdateBooking";
    }  else {
      return "invaliduser";
    }
  }

  @RequestMapping(value = "/applyVoucher")
  public String applyVoucher(
    HttpSession session,
    HttpServletRequest request,
    Model mod
  ) {
    Booking booking = new Booking();
    booking.setBookingid(Integer.parseInt(request.getParameter("bookingId")));
    booking.setVoucher(request.getParameter("bookingVoucher"));
    BookingDAO bookingDAO = new BookingDAO();
    bookingDAO.applyVoucher(booking);
    if (
      session.getAttribute("role").equals("staff") &&
      session.getAttribute("status").equals("success")
    ) {
      return "redirect:/viewUpdateBooking";
    }  else {
      return "invaliduser";
    }
  }
}

