package busBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class BookingDao {
	public static Connection getConnection() {
		Connection con=null;
		try {
			con=DBConnection.getConnection();
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static int bookedcount(int busno,Date date) {
		
		try {
			
			Connection con=getConnection();
			String query="select count(busno) from bookings where busno=? and date=?";
			PreparedStatement pst=con.prepareStatement(query);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			pst.setInt(1, busno);
			pst.setDate(2,sqlDate);
			ResultSet rs=pst.executeQuery();
			
			rs.next();
			int bookedcount=rs.getInt(1);
			con.close();
			return bookedcount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public boolean booking(String passengername,int busno,Date date,int seatno) {
		
		try {
			Connection con=getConnection();
			String query="insert into bookings (passengername,busno,date,seatno) values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			pst.setString(1, passengername);
			pst.setInt(2, busno);
			pst.setDate(3,sqlDate);
			pst.setInt(4,seatno);
			pst.executeUpdate();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public ArrayList<Integer> getbookedseats(int busno,Date date) {
		
		ArrayList<Integer> i=new ArrayList<Integer>();
		try {
			Connection con=getConnection();
			
			String query="select seatno from bookings where busno=? and date=? order by seatno desc";
			PreparedStatement pst=con.prepareStatement(query);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			pst.setInt(1, busno);
			pst.setDate(2,sqlDate);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				i.add(rs.getInt(1));
			}
			con.close();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
