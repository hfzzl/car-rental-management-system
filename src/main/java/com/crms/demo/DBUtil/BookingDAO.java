package com.crms.demo.DBUtil;

import com.crms.demo.model.Booking;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class BookingDAO {
  public Booking getBookingById(int bookingId) {
    JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
    String sql = "SELECT * FROM Booking WHERE bookingId= '" + bookingId + "'";
    try {
      Booking booking = jdbct.queryForObject(
        sql,
        new BeanPropertyRowMapper<Booking>(Booking.class)
      );
      return booking;
    } catch (Exception e) {
      return null;
    }
  }

  public List<Booking> getAllBookingsList() {
    JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
    // String sql = "SELECT custName FROM booking";
    String sql = "SELECT bookingid, vehicleid, custName, custPhoneNo, custEmail, DATE_FORMAT(pDate, '%d-%m-%Y') AS pDate, DATE_FORMAT(rDate, '%d-%m-%Y') AS rDate, pTime, rTime, pStatus, rStatus, duration, totalPrice, dateBook FROM Booking";
    List<Booking> booking = jdbct.query(sql, new BeanPropertyRowMapper<Booking>(Booking.class));
    return booking;
    // try {
    //   List<Booking> booking = jdbct.query(
    //     sql,
    //     new BeanPropertyRowMapper<Booking>(Booking.class)
    //   );
    //   return booking;
    // } catch (Exception e) {
    //   return null;
    // }
  }

  // public List<Booking> addBooking(Booking b) {
    public void addBooking(Booking b) {
    JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
    String sql = "INSERT INTO booking (vehicleid, custName, custPhoneNo, custEmail, pDate, pTime, rDate, rTime, pStatus, rStatus, duration, totalPrice) VALUES ('" + b.getVehicleid() + "', '"+b.getCustname() + "','"+b.getCustPhoneNo() + "',  '"+ b.getCustemail() + "',  '" + b.getPDate() + "','" + b.getPTime() + "' ,'" + b.getRDate() + "',  '" + b.getRTime() + "', '" + b.getPStatus() + "', '" + b.getRStatus() + "', '" + b.getHours() + "', '" + b.getPrice()+"')";
    jdbct.update(sql);
  //   String sql2 = "SELECT * FROM Booking ORDER BY dateBook DESC limit 1";
  //   List<Booking> booking = jdbct.query(sql2, new BeanPropertyRowMapper<Booking>(Booking.class));
  //   System.out.println(booking);
  //   return booking;
  }

  // betulkan ni please
  public void updateBooking(Booking booking) {
    JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
    String sql ="UPDATE Booking SET pStatus='"+booking.getPStatus()+"', rStatus='"+booking.getRStatus()+"'  WHERE bookingid = '"+booking.getBookingid()+"'";
    jdbct.update(sql);
  }

  public void deleteBooking(Booking booking) {
    JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
    String sql = "DELETE FROM Booking WHERE bookingId = ?";
    jdbct.update(sql, booking.getBookingid());
  }

  public void applyVoucher(Booking booking) {
    JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
    String sql = "UPDATE Booking SET bookingPrice = ? WHERE bookingId = ?";
    jdbct.update(
      sql,
      // booking.updateBookingPriceWithDiscount(20),
      booking.getBookingid()
    );
  }

  private static DataSource getDataSource() {
    DataSource ds = null;

    String dbURL = "jdbc:mysql://localhost:3306/crms";
    String username = "root";
    String password = "";

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (Exception e) {
      e.printStackTrace();
    }
    ds = new DriverManagerDataSource(dbURL, username, password);
    return ds;
  }
}
