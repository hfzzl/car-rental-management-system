package com.crms.demo.DBUtil;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.crms.demo.model.Admin;

import jakarta.servlet.http.HttpSession;

@Repository
public class AdminDAO {
	@Autowired
	HttpSession session;

	public static Admin authenticate(String username, String password) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "SELECT * FROM Admin WHERE username= '" + username + "' AND password= '" + password +"'";
		try{
			Admin admin = jdbct.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class));
			return admin;
		}
		catch(Exception e){
			return null;
		}
	}

	public List<Admin> viewProfile(Admin admin){
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		// String sql = "SELECT * FROM Admin WHERE userid = '" + admin.getUserid() + "'";
		String sql = "SELECT DATE_FORMAT(birthdate, '%d-%m-%Y') AS birthdate, userid, username, password, fullname, phone_no, email, addressL1, addressL2, addressL3, postcode, city, state   FROM admin WHERE userid = '" + admin.getUserid() + "'";
		System.out.println(admin.getUserid());
        List <Admin> adminInfo = jdbct.query(sql, new BeanPropertyRowMapper<Admin>(Admin.class));
        return adminInfo;
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

	public void updateProfile(Admin admin) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "UPDATE admin SET fullname = '" + admin.getFullname() + "',  phone_no = '" + admin.getPhone_no() + "', email = '" + admin.getEmail() + "' WHERE userid = '" + admin.getUserid() + "'";
		jdbct.update(sql);
	}

	public void updateAddress(Admin admin) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "UPDATE admin SET addressL1 = '" + admin.getAddressL1() + "',  addressL2 = '" + admin.getAddressL2() + "', addressL3 = '" + admin.getAddressL3() + "', postcode = '" + admin.getPostcode() + "', city = '" + admin.getCity() +"', state = '" + admin.getState() +"' WHERE userid = '" + admin.getUserid() + "'";
		jdbct.update(sql);
	}

	public List<Admin> viewAdminList() {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());		
		String sql = "SELECT DATE_FORMAT(birthdate, '%d-%m-%Y') AS birthdate, userid, username, password, fullname, phone_no, email, addressL1, addressL2, addressL3, postcode, city, state   FROM admin";
        List <Admin> aList = jdbct.query(sql, new BeanPropertyRowMapper<Admin>(Admin.class));
        return aList;
	}

	public List<Admin> viewSelectedAdmin(Admin admin) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "SELECT * FROM Admin WHERE userid = '" + admin.getUserid() + "'";
		List <Admin> aList = jdbct.query(sql, new BeanPropertyRowMapper<Admin>(Admin.class));
		return aList;
	}

    public void updateAdmin(Admin admin) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "UPDATE admin SET fullname = '" + admin.getFullname() + "',  phone_no = '" + admin.getPhone_no() + "', email = '" + admin.getEmail() + "' ,addressL1 = '" + admin.getAddressL1() + "',  addressL2 = '" + admin.getAddressL2() + "', addressL3 = '" + admin.getAddressL3() + "', postcode = '" + admin.getPostcode() + "', city = '" + admin.getCity() +"', state = '" + admin.getState() +"' WHERE userid = '" + admin.getUserid() + "'";
		jdbct.update(sql);
    }

    public void addAdmin(Admin admin) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "INSERT INTO admin (username, password, fullname, birthdate, phone_no, email, addressL1, addressL2, addressL3, postcode, city, state) VALUES ('" + admin.getUsername() + "', '"+admin.getPassword() + "','"+admin.getFullname() + "',  '"+ admin.getBirthdate()+"',  '" + admin.getPhone_no() + "','" + admin.getEmail() + "' ,'" + admin.getAddressL1() + "',  '" + admin.getAddressL2() + "', '" + admin.getAddressL3() + "', '" + admin.getPostcode() + "', '" + admin.getCity() +"', '" + admin.getState() +"')";
		jdbct.update(sql);
    }

    public void deleteAdmin(Admin admin) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "DELETE FROM admin WHERE userid = '" + admin.getUserid() + "'";
		jdbct.update(sql);
    }
}