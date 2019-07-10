package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BatchPreparedStatement {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		try {
			System.out.println("Enter the rollno:");
			int roll = scn.nextInt();
			System.out.println("Enter the name:");
			String name = scn.next();
			System.out.println("Enter the address:");
			String addr = scn.next();
			System.out.println("Enter the Mobile No:");
			long mbno = scn.nextInt();

			String query = String.format("insert into Student1 values(%d,'%s','%s',%d)", roll, name, addr, mbno);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "password");
			PreparedStatement st = con.prepareStatement(query);
			st.execute();
			System.out.println("Tables created in database");
			con.close();
		} catch (Exception e) {
			System.out.println(e);

		}

	}
}
