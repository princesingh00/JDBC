package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcMysqlConnection {
	public static void main(String[] args) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "password");
			if (con != null) {
				System.out.println("database connection established");
			} else {
				System.out.println("database connection not establised");
			}
		} catch (Exception e) {
			System.out.println("class not loaded and register");
		}
	}
}
