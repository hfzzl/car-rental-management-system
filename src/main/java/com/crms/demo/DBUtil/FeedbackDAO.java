package com.crms.demo.DBUtil;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.crms.demo.model.Feedback;

@Repository
public class FeedbackDAO {
    public void addFeedback(Feedback feedback) {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "INSERT INTO Feedback (fullname, feedback, date) VALUES ('" + feedback.getFullname() + "', '" + feedback.getFeedback() + "', NOW())";
		jdbct.update(sql);
    }

    public List<Feedback> viewFeedback() {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
        String sql = "SELECT fullname, feedback, DATE_FORMAT(date, '%d-%m-%Y') AS date FROM Feedback";
        List <Feedback> fList = jdbct.query(sql, new BeanPropertyRowMapper<Feedback>(Feedback.class));
        return fList;
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