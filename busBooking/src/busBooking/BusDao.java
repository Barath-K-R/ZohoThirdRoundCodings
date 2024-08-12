package busBooking;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class BusDao {

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
	
	public void displaybusinfo() {
		
		try {
			
			Connection con = getConnection();
			Statement st=con.createStatement();
			String query="select * from bus";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+". "+rs.getString(2)+"\n"
						+ "capacity:"+rs.getInt(3));
				if(rs.getInt(4)==1)
				{
					System.out.print(" acavailability: YES");
				}
				else
					System.out.print(" acavailability: NO");
				
				System.out.println();
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public int getCapacity(int busno) {
		try {
			Connection con=getConnection();
			Statement st=con.createStatement();
			String query="select capacity from bus where id="+busno;
			ResultSet rs=st.executeQuery(query);
			rs.next();
			int capacity=rs.getInt(1);
			con.close();
			return capacity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
		
		
		
}

	


