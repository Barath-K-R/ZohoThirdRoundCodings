import java.sql.*;

public class Main {

	public static Connection getConnection() {
		
	Connection con=null;
	String url="jdbc:mysql://localhost:3306/banking";
	String username="root";
	String password="Barath@1974";
	
	try {
		con=DriverManager.getConnection(url,username,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	
	}
	
	public static void getallcustomers() throws SQLException {
		Connection con=Main.getConnection();
		
		String query="select * from customers";
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getLong(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDouble(5));
			
		}
		con.close();
	}
	
	public static void adcustomer() throws SQLException {
		Connection con=Main.getConnection();
		
		int id=4;
		long accid=1004;
		String name="dineh";
		int age=34;
		double balance=4500.00;
		
		String query="insert into customers values (?,?,?,?,?);";
		
		PreparedStatement pst=con.prepareStatement(query);		
		
		pst.setInt(1,id);
		pst.setLong(2,accid);
		pst.setString(3,name);
		pst.setInt(4,age);
		pst.setDouble(5,balance);
		
		pst.executeUpdate();
		
		con.close();
	}
	
	public static void deposit() throws SQLException {
		Connection con=Main.getConnection();
		
		long accid=1002;
		double balance=3500.67;
		String query="update customers set balance=? where accid=?";
		
		PreparedStatement pst=con.prepareStatement(query);	
		
		pst.setLong(2,accid);
		pst.setDouble(1, balance);
		
		pst.executeUpdate();
		
		con.close();
		
		
		
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	 Main.getallcustomers();
	 Main.deposit();

	}

}
