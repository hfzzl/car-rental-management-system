package com.crms.demo.DBUtil;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.crms.demo.model.Staff;

@Repository
public class StaffDAO {

	public static Staff authenticate(String username, String password) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "SELECT * FROM Staff WHERE username= '" + username + "' AND password= '" + password +"'";
		try{
			Staff staff = jdbct.queryForObject(sql, new BeanPropertyRowMapper<Staff>(Staff.class));
			return staff;
		}
		catch(Exception e){
			return null;
		}
	}

    public List<Staff> viewStaffList() {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());		
		String sql = "SELECT DATE_FORMAT(birthdate, '%d-%m-%Y') AS birthdate, userid, username, password, fullname, phone_no, email, addressL1, addressL2, addressL3, postcode, city, state   FROM staff";
        List <Staff> aList = jdbct.query(sql, new BeanPropertyRowMapper<Staff>(Staff.class));
        return aList;
    }

    public List<Staff> viewSelectedStaff(Staff staff) {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "SELECT * FROM staff WHERE userid = '" + staff.getUserid() + "'";
		List <Staff> aList = jdbct.query(sql, new BeanPropertyRowMapper<Staff>(Staff.class));
		return aList;
    }

    public void updateStaff(Staff staff) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "UPDATE staff SET fullname = '" + staff.getFullname() + "',  phone_no = '" + staff.getPhone_no() + "', email = '" + staff.getEmail() + "' ,addressL1 = '" + staff.getAddressL1() + "',  addressL2 = '" + staff.getAddressL2() + "', addressL3 = '" + staff.getAddressL3() + "', postcode = '" + staff.getPostcode() + "', city = '" + staff.getCity() +"', state = '" + staff.getState() +"' WHERE userid = '" + staff.getUserid() + "'";
		System.out.println(sql);
		jdbct.update(sql);
    }

    public void addStaff(Staff staff) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "INSERT INTO staff (username, password, fullname, birthdate, phone_no, email, addressL1, addressL2, addressL3, postcode, city, state) VALUES ('" + staff.getUsername() + "', '"+staff.getPassword() + "','"+staff.getFullname() + "',  '"+ staff.getBirthdate()+"','" + staff.getPhone_no() + "','" + staff.getEmail() + "' ,'" + staff.getAddressL1() + "',  '" + staff.getAddressL2() + "', '" + staff.getAddressL3() + "', '" + staff.getPostcode() + "', '" + staff.getCity() +"', '" + staff.getState() +"')";
		jdbct.update(sql);
    }

	public void deleteStaff(Staff staff) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "DELETE FROM staff WHERE userid = '" + staff.getUserid() + "'";
		jdbct.update(sql);
	}

    public List<Staff> viewProfile(Staff staff) {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		// String sql = "SELECT * FROM Admin WHERE userid = '" + admin.getUserid() + "'";
		String sql = "SELECT DATE_FORMAT(birthdate, '%d-%m-%Y') AS birthdate, userid, username, password, fullname, phone_no, email, addressL1, addressL2, addressL3, postcode, city, state   FROM staff WHERE userid = '" + staff.getUserid() + "'";
		System.out.println(staff.getUserid());
        List <Staff> staffInfo = jdbct.query(sql, new BeanPropertyRowMapper<Staff>(Staff.class));
        return staffInfo;
    }

	public void updateProfileStaff(Staff staff) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "UPDATE staff SET fullname = '" + staff.getFullname() + "',  phone_no = '" + staff.getPhone_no() + "', email = '" + staff.getEmail() + "' WHERE userid = '" + staff.getUserid() + "'";
		jdbct.update(sql);
	}

    public void updateAddress(Staff staff) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "UPDATE staff SET addressL1 = '" + staff.getAddressL1() + "',  addressL2 = '" + staff.getAddressL2() + "', addressL3 = '" + staff.getAddressL3() + "', postcode = '" + staff.getPostcode() + "', city = '" + staff.getCity() +"', state = '" + staff.getState() +"' WHERE userid = '" + staff.getUserid() + "'";
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