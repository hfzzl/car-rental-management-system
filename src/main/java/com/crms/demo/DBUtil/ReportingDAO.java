package com.crms.demo.DBUtil;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.crms.demo.model.Reporting;

@Repository
public class ReportingDAO {
    public List<Reporting> viewadminreportingpage(Reporting reporting) {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
        String sql = "SELECT * FROM reporting WHERE reportingid = '" + reporting.getreportingid() + "'";
        List <Reporting> rList = jdbct.query(sql, new BeanPropertyRowMapper<Reporting>(Reporting.class));
        return rList;
    }

    public List<Reporting> viewstaffreportingpage(Reporting reporting) {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
        String sql = "SELECT * FROM reporting WHERE reportingid = '" + reporting.getreportingid() + "'";
        List <Reporting> rList = jdbct.query(sql, new BeanPropertyRowMapper<Reporting>(Reporting.class));
        return rList;
    }

	public void addReporting(Reporting reporting) {
        JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
		String sql = "INSERT INTO reporting (Dsales, NDcust, ADcust, Msales, NMcust, AMcust, achievements) VALUES ('" + reporting.getDsales() + "', '" + reporting.getNDcust() + "', '" + reporting.getADcust() + "', '" + reporting.getMsales() + "', '" + reporting.getNMcust() + "', '" + reporting.getAMcust() + "', '" + reporting.getachievements() + "')";
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
