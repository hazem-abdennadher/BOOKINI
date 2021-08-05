package DataBase;
import java.sql.*;
import java.util.Vector;

import javax.swing.ImageIcon;

public class Select {

	//------------------------------------------user----------------------------------
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
				case 7: return Users.getUserbio(rs1, userName);
				  default:
					  return "INVALID OPTION";
				}
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
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
		 
		return false;
		
	}
	public static boolean emailExist(Connection con ,String Email) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			 
			if(con != null) {
				stmt = con.prepareStatement("SELECT Email FROM projectjava.users where Email = ?");
				stmt.setString(1, Email);
				rs = stmt.executeQuery();
				return Users.emailExist(rs, Email);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		
		return false;
		
	}
	public static ImageIcon getUserImage(Connection con , String userName) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			 
			if(con != null) {
				stmt = con.prepareStatement("SELECT UserImage FROM  projectjava.users where userName= ? ");
				stmt.setString(1, userName);
				rs = stmt.executeQuery();
				return Users.getUserImg(rs);
					
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return null;
		
		
	}
	
	//-------------------------------------------------------books--------------------------------------------------
	public static ImageIcon getBookImage(Connection con , int isbn) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			 
			if(con != null) {
				stmt = con.prepareStatement("SELECT bookImg FROM projectjava.books where bookID = ? ");
				stmt.setInt(1, isbn);
				rs = stmt.executeQuery();
				return Books.getBookImg(rs);	
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return null;
	}
	//-----------------------------------------------Available books------------------------------------------
	public static Vector<Vector<String>> getBooksTableAvailable(Connection con) throws SQLException {
		try {
			 
			if(con != null) {
				return Books.getBooksAvailable(con);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return null;
		}
	
	
//-------------------------------------------------All-----------------------------------------------
		
	public static Vector<Vector<String>> getBooksTable(Connection con) throws SQLException {
		try {
			 
			if(con != null) {
				return Books.getBooksAll(con);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}		
		return null;
		}
//----------------------------------------Author + Title All ----------------------------------------

public static Vector<Vector<String>> getBooksTableAuthor(Connection con,String author) throws SQLException {
	try {
		 
		if(con != null) {
			
			return Books.getBooksAuthor(con, author);
		}
	}
	catch(Exception e) {
		System.out.println("Not Connected"+e);
	}
	return null;
	}	

public static Vector<Vector<String>> getBooksTableTitle(Connection con,String Title) throws SQLException {
	try {
		 
		if(con != null) {
			
			return Books.getBooksTitle(con,Title);
		}
	}
	catch(Exception e) {
		System.out.println("Not Connected"+e);
	}
	return null;
	}	
//----------------------------------------Author + Title Available ----------------------------------------
public static Vector<Vector<String>> getBooksTableAuthorAvailable(Connection con,String author) throws SQLException {
	try {
		 
		if(con != null) {
			
			return Books.getBooksAuthorAvailable(con, author);
		}
	}
	catch(Exception e) {
		System.out.println("Not Connected"+e);
	}
	return null;
	}	

	public static Vector<Vector<String>> getBooksTableTitleAvailable(Connection con,String Title) throws SQLException {
	try {
		 
		if(con != null) {
			return Books.getBooksTitleAvailable(con, Title);
		}
	}
	catch(Exception e) {
		System.out.println("Not Connected"+e);
	}
	return null;
	}
	
	
	
	
	public static boolean bookExist(Connection con , int bookID) throws SQLException {
		Statement stmt = null;
		ResultSet rs1 = null;
		try {
			
			if(con != null) {
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rs1 = stmt.executeQuery("SELECT bookID FROM projectjava.books");
				return Books.BookExist(rs1, bookID);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return false;
		
	}
	
	
	public static String[] getBookInfo(Connection con,int bookID) throws SQLException {	
		if(con != null) {
			return Books.getBookInfo(con, bookID);
		}
		return null;
	}
/////----------------------------------------------------UserBook--------------------------------------------------------------------
	
	public static boolean UserBookDoesntExist(Connection con,String username,int bookID) throws SQLException {
		if(con!=null) {
			PreparedStatement stmt = con.prepareStatement(" SELECT * FROM projectjava.userbooks where userName = ? and BookID = ? ");
			stmt.setString(1,username);
			stmt.setInt(2, bookID);
			ResultSet rs = stmt.executeQuery();
			int count = 0 ;
			while (rs.next()) {
				count++;
			}
			return count == 0;
		}
		return false;
	}
	
public static Vector<Vector<String>> getUsersBooksRequets(Connection con ) throws SQLException {
		
		PreparedStatement stmt   = con.prepareStatement(" SELECT * FROM projectjava.userbooks");
		ResultSet rs = stmt.executeQuery();
		Vector<String> userName= new Vector<>();
		Vector<String> BookID= new Vector<>();
		Vector<String> user= new Vector<>();
		Vector<String> book= new Vector<>();
		Vector<String> type= new Vector<>();
		while(rs.next()) {				
			userName.add(rs.getString("userName"));
			BookID.add(rs.getString("BookID"));
			user.add(rs.getString("user"));
			book.add(rs.getString("book"));
			if(rs.getInt("RequestType")== 0) {
				type.add("REQUEST");
			}
			else{
				type.add("RETURN");
			}
		}
		Vector<Vector<String>> v =new Vector<Vector<String>>();
		v.add(0,userName);
		v.add(BookID);
		v.add(user);
		v.add(book);
		v.add(type);
		return v;
	}

public static int UserInventoryCount(Connection con,String userName) throws SQLException {
	try {
		
		if(con != null) { 
			
			PreparedStatement stmt   = con.prepareStatement("SELECT * FROM projectjava.usersinventory where (UserName = ?)");
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			int count = 0 ;
			while(rs.next()) {
				count++;
			}
			return count;
		}
	}catch(Exception e) {
		System.out.println("Not Connected"+e);
	}
	return -1;
	
}

///-----------------------------------------------------------------------------------------


public static boolean UserBookInventoryDoesntExist(Connection con,String username,int bookID) throws SQLException {
	if(con!=null) {
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM projectjava.usersinventory where (UserName = ? ) and  (ISBN = ?) ");
		stmt.setString(1,username);
		stmt.setInt(2, bookID);
		ResultSet rs = stmt.executeQuery();
		int count = 0 ;
		while (rs.next()) {
			count++;
		}
		return count == 0;
	}
	return false;
}

//SELECT Date FROM projectjava.usersinventory where (UserName = "cyrus");
public static Vector<Date> UserInventoryDate(Connection con,String userName) throws SQLException {
	try {
		
		if(con != null) { 
			
			PreparedStatement stmt   = con.prepareStatement("SELECT Date FROM projectjava.usersinventory where (UserName = ?)");
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			Vector<Date> v = new Vector<Date>();
			while(rs.next()) {
				v.add(rs.getDate("Date"));
			}
			return v;
		}
	}catch(Exception e) {
		System.out.println("Not Connected"+e);
	}
	return null;
	
}
public static int[] UserInventorybookID(Connection con,String userName) throws SQLException {
	
	try {
		
		if(con != null) { 
			
			PreparedStatement stmt   = con.prepareStatement("SELECT ISBN FROM projectjava.usersinventory where (UserName = ?)");
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			 int[] t = {-1,-1,-1};
			 int i = 0 ;
			while(rs.next()) {
				t[i] = rs.getInt("ISBN");
				i++;
			}
			return t;
		}
	}catch(Exception e) {
		System.out.println("Not Connected"+e);
	}
	return null;
	
}

	
		 
	
/*public static ImageIcon UserInventoryBookImg(Connection con,String userName,int bookId) throws SQLException {
	try {
		
		if(con != null) { 
			
			PreparedStatement stmt = con.prepareStatement("SELECT bookImg FROM projectjava.books where bookID = ? ");
			stmt.setInt(1, );
			ResultSet rs = stmt.executeQuery();
			return Books.getBookImg(rs);	
		}
	}catch(Exception e) {
		System.out.println("Not Connected"+e);
	}
	return null;
	
}*/



	
}


