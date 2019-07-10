package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDemo {

	public static void main(String[] args) throws Exception {
		try {
			String sqlQuery = "create table employee (empid int(5) primary key,name varchar(20),DOB varchar(20))";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "password");
			Statement st = con.createStatement();
			st.executeUpdate(sqlQuery);
			System.out.println("Table created in database");
			con.close();
		} catch (Exception e) {
			System.out.println("table is already exits");

		}

	}

}