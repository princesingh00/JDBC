package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchDemo {

	public static void main(String[] args) throws Exception {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "password");
			Statement st = con.createStatement();
			st.addBatch(
					"create table Student1(rollno int(5) primary key,name varchar(20),Address varchar(20),MobileNo int(10))");
			st.addBatch(
					"create table Student2(rollno int(5) primary key,name varchar(20),Address varchar(20),MobileNo int(10))");
			st.addBatch(
					"create table Student3(rollno int(5) primary key,name varchar(20),Address varchar(20),MobileNo int(10))");
			st.executeBatch();
			System.out.println("Tables created in database");
			con.close();
		} catch (Exception e) {
			System.out.println("table is already exits");

		}

	}
}
