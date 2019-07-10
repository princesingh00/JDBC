package jdbc;

import java.sql.*;

public class UpdateDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {

			String query = String.format("update Student set name = 'alex' where rollno = 2 ");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "password");
			Statement st = con.createStatement();
			st.executeUpdate(query);
			System.out.println("Record is Inserted in Tables");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
