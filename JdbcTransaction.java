package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JdbcTransaction {

	private static final String INSERT_SQL = "INSERT INTO employee " + "(empid, name,DOB) VALUES (?,?,?)";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "password");
		conn.setAutoCommit(false);
		try (PreparedStatement insertStmt = conn.prepareStatement(INSERT_SQL);) {
			insertStmt.setInt(1, 1);
			insertStmt.setString(2, "Michael");
			insertStmt.setDate(3, new Date(dateFormat.parse("1995-07-01").getTime()));
			insertStmt.executeUpdate();

			insertStmt.setInt(1, 2);
			insertStmt.setString(2, "Sunil");
			insertStmt.setDate(3, new Date(dateFormat.parse("1988-03-22").getTime()));
			insertStmt.executeUpdate();

			insertStmt.setInt(1, 3);
			insertStmt.setString(2, "Mike");
			insertStmt.setDate(3, new Date(dateFormat.parse("1980-05-12").getTime()));
			insertStmt.executeUpdate();

			Savepoint savepoint = conn.setSavepoint();
			insertStmt.setInt(1, 4);
			insertStmt.setString(2, "Manish");
			insertStmt.setDate(3, new Date(dateFormat.parse("1992-01-21").getTime()));
			insertStmt.executeUpdate();

			insertStmt.setInt(1, 5);
			insertStmt.setString(2, "Albert");
			insertStmt.setDate(3, new Date(dateFormat.parse("1972-07-05").getTime()));
			insertStmt.executeUpdate();

			conn.rollback(savepoint);
			conn.commit();
			System.out.println("Transaction is commited successfully.");
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
	}
}
