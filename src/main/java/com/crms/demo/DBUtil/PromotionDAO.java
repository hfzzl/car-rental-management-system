package com.crms.demo.DBUtil;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.crms.demo.model.Promotion;

public class PromotionDAO {
    public List<Promotion> viewPromotion() {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
        String sql = "SELECT * FROM Promotion";
        List <Promotion> pList = jdbct.query(sql, new BeanPropertyRowMapper<Promotion>(Promotion.class));
        return pList;
    }

	public void addPromotion(Promotion promotion) {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "INSERT INTO Promotion (name, description, percentage) VALUES ('" + promotion.getName() + "', '" + promotion.getDescription() + "', '" + promotion.getPercentage() + "')";
		jdbct.update(sql);
    }

	public List<Promotion> viewSelectedPromotion(Promotion promotion) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "SELECT * FROM Promotion WHERE promotionid = '" + promotion.getPromotionid() + "'";
		List <Promotion> pList = jdbct.query(sql, new BeanPropertyRowMapper<Promotion>(Promotion.class));
		return pList;
	}

	public void updatePromotion(Promotion promotion) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "UPDATE Promotion SET name = '" + promotion.getName() + "', description = '" + promotion.getDescription() + "', percentage = '" + promotion.getPercentage() + "' WHERE promotionid = '" + promotion.getPromotionid() + "'";
		jdbct.update(sql);
	}

	public void deletePromotion(Promotion promotion) {
		JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "DELETE FROM Promotion WHERE promotionid = '" + promotion.getPromotionid() + "'";
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
