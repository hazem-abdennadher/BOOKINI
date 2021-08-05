package DataBase;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Insert {

	
	public static boolean addUser(Connection con, String Email , String userName, String Name ,String LastName,int Age,String Gender, String Password,FileInputStream input) throws SQLException {
		try {
			
			if(con != null) { 
				
				return Users.addUser(con, Email,userName,Name,LastName,Age,Gender,Password,input);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return false;
		
	}
	public static boolean addBook(Connection con,int bookID,String bookTitre,String author,String bookCategory,String bookDescription ,int nbrCopie,FileInputStream input) throws SQLException {
		try {
			
			if(con != null) { 
				
				return Books.addBook(con, bookID, bookTitre, author, bookCategory, bookDescription, nbrCopie,input);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return false;
		
	}
	
	
public static boolean addBooksUsers(Connection con,String userName, int BookID ,int type) throws SQLException {
		
		
		if(con!=null) {
			String bookinfo[] = Books.getBookInfo(con, BookID);
			String username = Select.userInfo(con, userName, 2);
			String title  = bookinfo[1];
			PreparedStatement stmt   = con.prepareStatement("INSERT INTO `projectjava`.`userbooks` (`userName`, `BookID`, `user`, `book`, `RequestType`) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1,userName);
			stmt.setInt(2, BookID);
			stmt.setString(3,username);
			stmt.setString(4,title);
			stmt.setInt(5,type);
			
			stmt.execute();
			return true;
		}
		return false;
	}

//----------------------------------------------User Inventory----------------------------------------


public static boolean add2UserInventory(Connection con,String userName,int bookID) throws SQLException {
	try {
		
		if(con != null) { 
			
			PreparedStatement stmt   = con.prepareStatement("INSERT INTO `projectjava`.`usersinventory` (`UserName`, `ISBN`, `Date`) VALUES (?,? ,?)");
			stmt.setString(1, userName);
			stmt.setInt(2, bookID);
			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis);  
			stmt.setDate(3, date);
			stmt.executeUpdate();
		}
	}catch(Exception e) {
		System.out.println("Not Connected"+e);
	}
	return false;
	
}




}
