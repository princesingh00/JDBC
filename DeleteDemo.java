package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "password");
			Statement st = con.createStatement();
			st.execute("drop table Student1");
			System.out.println("Table has been deleted");
			con.close();
		} catch (Exception e) {
			System.out.println("Table is not present in database");
		}

	}

}