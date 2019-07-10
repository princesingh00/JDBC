package jdbc;

import java.sql.*;
import java.sql.DriverManager;

public class JdbcMySqlDemo {

	public static void main(String[] args)  {
		try {		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "password");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from books");
		
		while (rs.next()) {
			System.out.println(rs.getString(1) + "\t" + rs.getInt(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
		}
	
		con.close();
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	}
}