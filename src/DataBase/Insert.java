package DataBase;
import java.sql.Connection;
import java.sql.SQLException;


public class Insert {

	public static boolean addUser(Connection con, String Email , String userName, String Name ,String LastName,int Age,String Gender, String Password) throws SQLException {
		try {
			
			if(con != null) { 
				
				return Users.addUser(con, Email,userName,Name,LastName,Age,Gender,Password);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return false;
		
	}
}
