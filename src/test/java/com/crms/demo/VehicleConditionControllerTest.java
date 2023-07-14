package com.crms.demo;

import com.crms.demo.DBUtil.VehicleConditionDAO;
import com.crms.demo.controller.VehicleConditionController;
import com.crms.demo.model.VehicleCondition;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.ui.ConcurrentModel;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import org.springframework.ui.ConcurrentModel;

import java.util.ArrayList;
import java.util.List;

public class VehicleConditionControllerTest {
    private MockHttpSession session;
    private MockHttpServletRequest request;
    private ConcurrentModel model;
    private VehicleConditionController vehicleConditionController;

    @Before
    public void setUp() {
        session = new MockHttpSession();
        request = new MockHttpServletRequest();
        model = new ConcurrentModel();
        vehicleConditionController = new VehicleConditionController(); // Instantiate VehicleConditionController
    }

    
    @Test
    public void testViewVehicleConditionPage_StaffRole_SuccessfulRedirect() {
        // Arrange
        List<VehicleCondition> vehicleConditions = new ArrayList<>();
        vehicleConditions.add(new VehicleCondition(1, "Good", "Action1", "2023-07-14"));
        vehicleConditions.add(new VehicleCondition(2, "Excellent", "Action2", "2023-07-15"));
    
        // Set up session attributes
        session.setAttribute("role", "staff");
        session.setAttribute("status", "success");
    
        // Set up request parameters
        request.setServletPath("/vehiclecondition");
    
        // Mock the VehicleConditionDAO and define its behavior
    VehicleConditionDAO vehicleConditionDAO = mock(VehicleConditionDAO.class);
    doNothing().when(vehicleConditionDAO).addVehicleCondition(any(VehicleCondition.class));

    
        // Act
        String result = vehicleConditionController.viewVehicleConditionPage(session, model, request);
    
        // Assert
        assertEquals("staff/manageVehicleCondition", result);
    }
    


    @Test
    public void testViewVehicleConditionPage_InvalidUser_InvalidUserRedirect() {
        // Arrange
        session.setAttribute("role", "admin");
        session.setAttribute("status", "failed");
        request.setServletPath("/vehiclecondition");

        // Act
        String result = vehicleConditionController.viewVehicleConditionPage(session, model, request);

        // Assert
        assertEquals("invaliduser", result);
    }

@Test
public void testViewUpdateVehicleCondition_InvalidUser_InvalidUserRedirect() {
    // Arrange
    session.setAttribute("role", "admin");
    session.setAttribute("status", "failed");
    request.setParameter("VehicleConditionID", "1");
    
    // Act
    String result = vehicleConditionController.viewUpdateVehicleCondition(session, request, model);

    // Assert
    assertEquals("invaliduser", result);
}

}
