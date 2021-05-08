package DataBase;

import java.sql.*;

public class Users {

	public static void getUsers(ResultSet rs) throws SQLException {
		while(rs.next()) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(rs.getString("Name")+" ");
			buffer.append(rs.getString("LastName")+" ");
			buffer.append(rs.getString("Password"));
			System.out.println(buffer.toString());
		}
	}
	
	public static boolean userExist(ResultSet rs,String userName ) throws SQLException {
		while(rs.next()) {
			if(rs.getString("userName").equalsIgnoreCase(userName)) {
				return true ;
			}
		}
		return false;
	}
	//-------------------------------------getting user info----------------------------------------------------------
	public static String getUserEmail(ResultSet rs,String userName ) throws SQLException {
		while(rs.next()) {
			if(rs.getString("userName").equalsIgnoreCase(userName)) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(rs.getString("Email"));
				return buffer.toString();
			}
		}
		return "doesn't exist";
	}
	public static String getUserName(ResultSet rs,String userName ) throws SQLException {
		while(rs.next()) {
			if(rs.getString("userName").equalsIgnoreCase(userName)) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(rs.getString("Name"));
				return buffer.toString();
			}
		}
		return "doesn't exist";
	}
	public static String getUserGender(ResultSet rs,String userName ) throws SQLException {
		while(rs.next()) {
			if(rs.getString("userName").equalsIgnoreCase(userName)) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(rs.getString("Gender"));
				return buffer.toString();
			}
		}
		return "doesn't exist";
	}
	
	public static String getUserLastName(ResultSet rs,String userName ) throws SQLException {
		while(rs.next()) {
			if(rs.getString("userName").equalsIgnoreCase(userName)) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(rs.getString("LastName"));
				return buffer.toString();
			}
		}
		return "doesn't exist"; 
	}
	
	public static String getUserAge(ResultSet rs,String userName ) throws SQLException {
		while(rs.next()) {
			if(rs.getString("userName").equalsIgnoreCase(userName)) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(rs.getInt("Age"));
				return buffer.toString();
			}
		}
		return "doesn't exist"; 
	}
	
	public static String getUserPassword(ResultSet rs,String userName ) throws SQLException {
		while(rs.next()) {
			if(rs.getString("userName").equalsIgnoreCase(userName)) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(rs.getString("Password"));
				return buffer.toString();
			}
		}
		return "doesn't exist";
	}
	
	
	
	
	
	public static boolean addUser(Connection con, String Email , String userName, String Name ,String LastName,int Age ,String Gender, String Password) {
			
		String sql = "INSERT INTO `projectjava`.`users` (`Email`, `userName`, `Name`, `LastName`, `Age`, `Gender`, `Password`) VALUES (?,?,?,?,?,?,?)";

		try {	
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, Email);
				stmt.setString(2, userName);
				stmt.setString(3, Name);
				stmt.setString(4, LastName);
				stmt.setInt(5, Age);
				stmt.setString(6, Gender);
				stmt.setString(7, Password);
				stmt.execute();
				return true;
				
			}catch(Exception e){
				System.out.println(e);
				return false;
			}
	}
	
	
	public static boolean matchPassord(ResultSet rs) throws SQLException {
		int count = 0 ;
		while(rs.next()) {
			count++;
		}
		if(count == 0 ) {
			return false; 
		}
		else if(count == 1 )  {
			return true;
		}
		else {
			return false;
		}
		
	}	
		

}