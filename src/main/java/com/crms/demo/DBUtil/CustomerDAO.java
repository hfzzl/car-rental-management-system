package com.crms.demo.DBUtil;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.crms.demo.model.Customer;

@Repository
public class CustomerDAO {

	public static Customer authenticate(String username, String password) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "SELECT * FROM Customer WHERE username= '" + username + "' AND password= '" + password +"'";
		try{
			Customer user = jdbct.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
			return user;
		}
		catch(Exception e){
			return null;
		}
	}

	public void addCust(Customer customer){
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "INSERT INTO customer (username, password, fullname, phone_no, email, addressL1, addressL2, addressL3, postcode, city, state, birthdate) VALUES ('" + customer.getUsername() + "', '" + customer.getPassword() + "', '" + customer.getFullname() + "', '" + customer.getPhone_no() + "', '" + customer.getEmail() + "', '" + customer.getAddressL1() + "', '" + customer.getAddressL2() + "', '" + customer.getAddressL3() + "', '" + customer.getPostcode() + "', '" + customer.getCity() + "', '" + customer.getState() + "', '" + customer.getBirthdate() + "')";
		jdbct.update(sql);
	}

	public List<Customer> viewProfile(Customer cust) {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		// String sql = "SELECT * FROM Admin WHERE userid = '" + admin.getUserid() + "'";
		String sql = "SELECT DATE_FORMAT(birthdate, '%d-%m-%Y') AS birthdate, userid, username, password, fullname, phone_no, email, addressL1, addressL2, addressL3, postcode, city, state   FROM customer WHERE userid = '" + cust.getUserid() + "'";
		System.out.println(cust.getUserid());
        List <Customer> custInfo = jdbct.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
        return custInfo;
    }

    public void updateProfileCust(Customer cust) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "UPDATE customer SET fullname = '" + cust.getFullname() + "',  phone_no = '" + cust.getPhone_no() + "', email = '" + cust.getEmail() + "' WHERE userid = '" + cust.getUserid() + "'";
		jdbct.update(sql);
    }

    public void updateAddress(Customer cust) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "UPDATE customer SET addressL1 = '" + cust.getAddressL1() + "',  addressL2 = '" + cust.getAddressL2() + "', addressL3 = '" + cust.getAddressL3() + "', postcode = '" + cust.getPostcode() + "', city = '" + cust.getCity() +"', state = '" + cust.getState() +"' WHERE userid = '" + cust.getUserid() + "'";
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