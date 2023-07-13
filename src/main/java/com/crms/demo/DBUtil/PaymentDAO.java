package com.crms.demo.DBUtil;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.crms.demo.model.PaymentDetail;


@Repository
public class PaymentDAO {
    public void addPayment(PaymentDetail payment) {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "INSERT INTO Payment (CHname, email, Cnum, ExpMonth, ExpYear, CVC) VALUES ('" + payment.getCHname() + "', '" + payment.getEmail() + "','" + payment.getCnum() + "','" + payment.getExpMonth() + "','" + payment.getExpYear() + "','" + payment.getCVC() + "')";
		jdbct.update(sql);
    }

    public List<PaymentDetail> viewPayment() {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
        String sql = "SELECT * FROM payment";
        List <PaymentDetail> pList = jdbct.query(sql, new BeanPropertyRowMapper<PaymentDetail>(PaymentDetail.class));
        return pList;
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