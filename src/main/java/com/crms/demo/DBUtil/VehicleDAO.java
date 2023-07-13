package com.crms.demo.DBUtil;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.crms.demo.model.Vehicle;

public class VehicleDAO {
    public List<Vehicle> viewVehicle() {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
        String sql = "SELECT * FROM Vehicle";
        List <Vehicle> vList = jdbct.query(sql, new BeanPropertyRowMapper<Vehicle>(Vehicle.class));
        return vList;
    }

	public void addVehicle(Vehicle vehicle) {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "INSERT INTO Vehicle (brand, model, colour, engine, registrationno, rate) VALUES ('" + vehicle.getBrand() + "', '" + vehicle.getModel() + "', '" + vehicle.getColour() + "', '" + vehicle.getEngine() + "', '" + vehicle.getRegistrationno() + "', '" + vehicle.getRate() + "')";
		jdbct.update(sql);
    }

	public List<Vehicle> viewSelectedVehicle(Vehicle vehicle) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "SELECT * FROM Vehicle WHERE vehicleid = '" + vehicle.getVehicleid() + "'";
		List <Vehicle> vList = jdbct.query(sql, new BeanPropertyRowMapper<Vehicle>(Vehicle.class));
		return vList;
	}

	public void updateVehicle(Vehicle vehicle) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "UPDATE Vehicle SET brand = '" + vehicle.getBrand() + "', model = '" + vehicle.getModel() + "', colour = '" + vehicle.getColour() + "', engine = '" + vehicle.getEngine() + "', registrationno = '" + vehicle.getRegistrationno() + "', rate = '" + vehicle.getRate() + "' WHERE vehicleid = '" + vehicle.getVehicleid() + "'";
		jdbct.update(sql);
	}

	public void deleteVehicle(Vehicle vehicle) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "DELETE FROM Vehicle WHERE vehicleid = '" + vehicle.getVehicleid() + "'";
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
