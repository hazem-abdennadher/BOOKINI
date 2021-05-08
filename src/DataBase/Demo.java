package DataBase;
import java.sql.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class Demo {

	public static void main(String[] args) throws SQLException {
		
	      
		
		
		
		
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con=DBConnection.getConnection();
			if(con!=null) {
				//Users.addUser(con, "aziz", "chebbi", "5555");
				
				
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		finally {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(con!=null) {
				con.close();
			}
			
			
		}
		
	}

}
