package DataBase;
import java.sql.*;

public class Select {

	
	public static String userInfo(Connection con , String userName, int Option) throws SQLException {
		Statement stmt = null;
		ResultSet rs1 = null;
		try {
			
			if(con != null) {
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rs1 = stmt.executeQuery("SELECT * FROM projectjava.users");
				switch(Option) {
				case 1: return Users.getUserEmail(rs1, userName);
				case 2: return Users.getUserName(rs1, userName);
				case 3: return Users.getUserLastName(rs1, userName);
				case 4: return Users.getUserAge(rs1, userName);
				case 5: return Users.getUserGender(rs1, userName);
				case 6: return Users.getUserPassword(rs1, userName);
				  default:
					  return "INVALID OPTION";
				}
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		finally {
			if(rs1 != null) {
				rs1.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return "SOMETHING WRONG HAPPENED";
		
	}
	
	
	
	
	
	
	public static boolean userExist(Connection con , String userName) throws SQLException {
		Statement stmt = null;
		ResultSet rs1 = null;
		try {
			
			if(con != null) {
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rs1 = stmt.executeQuery("SELECT userName FROM projectjava.users");
				return Users.userExist(rs1, userName);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		finally {
			if(rs1 != null) {
				rs1.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return false;
		
	}
	
	
	public static boolean matchPassword(Connection con , String userName,String userPassword) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			 
			if(con != null) {
				stmt = con.prepareStatement("SELECT userName FROM  projectjava.users where userName= ? && Password = ?");
				stmt.setString(1, userName);
				stmt.setString(2, userPassword);
				rs = stmt.executeQuery();
				return Users.matchPassord(rs);
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
		return false;
		
	}

}