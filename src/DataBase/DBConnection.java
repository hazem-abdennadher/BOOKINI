package DataBase;
import java.sql.*;
public class DBConnection {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Hazem123*6";
	private static final String CONN = "jdbc:mysql://localhost:3306/projectjava";
	
	public static Connection getConnection() throws SQLException {
		return (Connection)DriverManager.getConnection(CONN,USERNAME,PASSWORD);
	}
	

}
