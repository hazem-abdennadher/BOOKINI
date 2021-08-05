package DataBase;
import java.sql.*;
public class Delete {
	
	public static boolean deleteBook(Connection con , int BOOKID) throws SQLException {
		try {
			if(con != null) {
				return Books.DeleteBook(con, BOOKID);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return false;
	}
	//DELETE FROM `projectjava`.`userbooks` WHERE (`userName` = 'cyrus') and (`BookID` = '19');
	public static boolean deleteUserBook(Connection con ,String userName, int BookID) throws SQLException {
		
		
		String sql = "DELETE FROM `projectjava`.`userbooks` WHERE (`userName` = ?) and (`BookID` =?)";
		try {	
				
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, userName);
				stmt.setInt(2, BookID);
				stmt.execute();
				return true;
				
			}catch(Exception e){
				System.out.println(e);
				return false;
			}
	}
	//DELETE FROM `projectjava`.`usersinventory` WHERE (`UserName` = 'cyrus') and (`ISBN` = '25');
public static boolean deleteUserBookInventory(Connection con ,String userName, int BookID) throws SQLException {
		
		
		String sql = "DELETE FROM `projectjava`.`usersinventory` WHERE (`UserName` = ?) and (`ISBN` = ?)";
		try {	
				
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, userName);
				stmt.setInt(2, BookID);
				stmt.execute();
				return true;
				
			}catch(Exception e){
				System.out.println(e);
				return false;
			}
	}
}
