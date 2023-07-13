package com.crms.demo.DBUtil;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.crms.demo.model.VehicleCondition;

@Repository
public class VehicleConditionDAO {
    public List<VehicleCondition> viewVehicleCondition() {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
        String sql = "SELECT * FROM VehicleCondition";
        List <VehicleCondition> vList = jdbct.query(sql, new BeanPropertyRowMapper<VehicleCondition>(VehicleCondition.class));
        return vList;
    }

	public void addVehicleCondition(VehicleCondition vehicle) {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "INSERT INTO VehicleCondition (VehicleCondition, Action, ActionDate) VALUES ('" + vehicle.getVehicleCondition() + "', '" + vehicle.getAction() + "', '" + vehicle.getActionDate() + "')";
		jdbct.update(sql);
    }

	public List<VehicleCondition> viewSelectedVehicleCondition(VehicleCondition vehicle) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "SELECT * FROM VehicleCondition WHERE VehicleConditionID = '" + vehicle.getVehicleConditionID() + "'";
		List <VehicleCondition> vList = jdbct.query(sql, new BeanPropertyRowMapper<VehicleCondition>(VehicleCondition.class));
		return vList;
	}

	public void updateVehicleCondition(VehicleCondition vehicle) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "UPDATE VehicleCondition SET VehicleCondition = '" + vehicle.getVehicleCondition() + "' , Action = '" + vehicle.getAction() + "', ActionDate = '" + vehicle.getActionDate() + "' WHERE VehicleConditionID = '" + vehicle.getVehicleConditionID() + "'";
		jdbct.update(sql);
	}

	public void deleteVehicleCondition(VehicleCondition vehicle) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "DELETE FROM VehicleCondition WHERE VehicleConditionID = '" + vehicle.getVehicleConditionID() + "'";
		jdbct.update(sql);
	}



    private static DataSource getDataSource() {
		DataSource ds =null;

		String dbURL = "jdbc:mysql://localhost:3306/crms";
		String username = "root";
		String password = "";

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ds = new DriverManagerDataSource(dbURL, username, password);
		return ds;
	}
}
