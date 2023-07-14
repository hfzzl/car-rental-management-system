package com.crms.demo;

import com.crms.demo.controller.StaffController;
import com.crms.demo.model.Staff;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.ui.ConcurrentModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StaffControllerTest {

    private MockHttpSession session;
    private MockHttpServletRequest request;
    private ConcurrentModel model;
    private StaffController staffController;

    @Before
    public void setUp() {
        session = new MockHttpSession();
        request = new MockHttpServletRequest();
        model = new ConcurrentModel();
        staffController = new StaffController(); // Instantiate StaffController without StaffDAO parameter
    }

    @Test
    public void testUpdateAddress_ValidInput_SuccessfulRedirect() {
        // Arrange
        Staff staff = new Staff();
        int userid = 1;
        String addressL1 = "345";
        String addressL2 = "Jalan Seri Putra 1";
        String addressL3 = "Taman Seri Putra";
        int postcode = 43000;
        String city = "Kajang";
        String state = "Selangor";

        // Set up session attributes
        session.setAttribute("userid", userid);
        session.setAttribute("role", "staff");
        session.setAttribute("status", "success");

        // Set up request parameters
        request.setParameter("addressL1", addressL1);
        request.setParameter("addressL2", addressL2);
        request.setParameter("addressL3", addressL3);
        request.setParameter("postcode", Integer.toString(postcode));
        request.setParameter("city", city);
        request.setParameter("state", state);

        // Act
        String result = staffController.updateAddress(session, request, model);

        // Assert
        assertEquals("redirect:/profileStaff", result);
    }

    @Test
    public void testUpdateAddress_InvalidInput_InvalidUser() {
        // Arrange
        session.setAttribute("userid", 1); // Set the userid attribute
        session.setAttribute("role", "admin");
        session.setAttribute("status", "failed");
        request.setParameter("addressL1", "No. 234");
        request.setParameter("addressL2", "Jalan Seri Putra 1");
        request.setParameter("addressL3", "Taman Permai");
        request.setParameter("postcode", Integer.toString(14322)); 
        request.setParameter("city", "Kajang");
        request.setParameter("state", "Selangor");

        // Act
        String result = staffController.updateAddress(session, request, model);

        // Assert
        assertEquals("invaliduser", result);
    }


    @Test
    public void testUpdateAddress_InvalidInput_InvalidPostcode_ThrowsException() {
    // Arrange
    session.setAttribute("userid", 1); // Set the userid attribute
    session.setAttribute("role", "staff");
    session.setAttribute("status", "success");
    request.setParameter("addressL1", "No. 234");
    request.setParameter("addressL2", "Jalan Panglima 1");
    request.setParameter("addressL3", "Taman Panglima");
    request.setParameter("postcode", "10o"); // Set an invalid string value for postcode
    request.setParameter("city", "Skudai");
    request.setParameter("state", "Johor");

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> staffController.updateAddress(session, request, model));
}

    @Test
    public void testUpdateAddress_NullSession_ThrowsException() {
        // Act and Assert
        assertThrows(NullPointerException.class, () -> staffController.updateAddress(null, request, model));
    }
}
