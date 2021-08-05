package DataBase;

import java.io.FileInputStream;
import java.sql.*;

import javax.swing.ImageIcon;

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
	public static boolean emailExist(ResultSet rs,String Email ) throws SQLException {
		while(rs.next()) {
			if(rs.getString("Email").equalsIgnoreCase(Email)) {
				return true ;
			}
		}
		return false;
	}
	//-----------------------------------------------------getting user info---------------------------------------------------------------
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
	public static String getUserbio(ResultSet rs,String userName ) throws SQLException {
		while(rs.next()) {
			if(rs.getString("userName").equalsIgnoreCase(userName)) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(rs.getString("UserBio"));
				return buffer.toString();
			}
		}
		return "doesn't exist";
	}
	public static ImageIcon getUserImg(ResultSet rs) throws SQLException {
		if(rs.next()) {
			return  new ImageIcon(rs.getBytes("UserImage"));
		}
		return null;
	}
		
//--------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	public static boolean addUser(Connection con, String Email , String userName, String Name ,String LastName,int Age ,String Gender, String Password,FileInputStream input) {
			
		String sql = "INSERT INTO `projectjava`.`users` (`Email`, `userName`, `Name`, `LastName`, `Age`, `Gender`, `Password` , `UserImage` ) VALUES (?,?,?,?,?,?,?,?)";

		try {	
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, Email);
				stmt.setString(2, userName);
				stmt.setString(3, Name);
				stmt.setString(4, LastName);
				stmt.setInt(5, Age);
				stmt.setString(6, Gender);
				stmt.setString(7, Password);
				stmt.setBinaryStream(8, input);
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
	
public static boolean EditUser(Connection con, String userName , String name ,String lastName , int age, String Bio ,FileInputStream input) {
		
		String sql = "UPDATE `projectjava`.`users` SET  `Name` = ?, `LastName` =  ? , `Age` = ?, `UserImage` = ?, `UserBio` = ? WHERE (`userName` = ?)";

		try {	
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setString(2, lastName);
				stmt.setInt(3, age);
				stmt.setBinaryStream(4, input);
				stmt.setString(5, Bio);
				stmt.setString(6, userName);
				stmt.execute();
				return true;
				
			}catch(Exception e){
				System.out.println(e);
				return false;
			}
	}
	 
public static boolean EditUserNoImg(Connection con, String userName , String name ,String lastName , int age, String Bio ) {
	
	String sql = "UPDATE `projectjava`.`users` SET  `Name` = ?, `LastName` =  ? , `Age` = ?, `UserBio` = ? WHERE (`userName` = ?)";

	try {	
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, lastName);
			stmt.setInt(3, age);
			stmt.setString(4, Bio);
			stmt.setString(5, userName);
			stmt.execute();
			return true;
			
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
}

}