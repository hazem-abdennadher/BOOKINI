package DataBase;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Vector;

import javax.swing.ImageIcon;

public class Books {
	
	
	
	public static String[] getBookInfo(Connection con,int bookID) throws SQLException {
		
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM projectjava.books where (bookID=?)");
		stmt.setInt(1,bookID);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			String  info[]  = new String[6]; 
			 info[0]= rs.getString(1);
			 info[1]=rs.getString(2);
			 info[2]=rs.getString(3);
			 info[3]=rs.getString(4);
			 info[4]=rs.getString(5);
			 info[5]=rs.getString(6);
			 return info;
		}
	return null;
}
	
	
	
	
	
	public static Vector<String> getBooksID(Connection con) throws SQLException {
	
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("SELECT bookID FROM projectjava.books");
		Vector<String> v= new Vector<>();
		while(rs.next()) {				
				v.add(rs.getString("bookID"));
		}
		return v;
	}
	public static Vector<String>getBooksTitle(Connection con) throws SQLException {
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("SELECT bookTitre FROM projectjava.books");
		Vector<String> v= new Vector<>();
		
		while(rs.next()) {				
			v.add(rs.getString("bookTitre"));	
		}
		return v;
		
	}
	public static Vector<String> getBooksCategory(Connection con) throws SQLException {
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("SELECT bookCategory FROM projectjava.books");
		Vector<String> v= new Vector<>();
		while(rs.next()) {				
				v.add(rs.getString("bookCategory"));
		}
		return v;
		
	}
	public static Vector<String> getBooksCopies(Connection con) throws SQLException {
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("SELECT nbrCopie FROM projectjava.books");
		Vector<String> v= new Vector<>();
		while(rs.next()) {				
			v.add(rs.getString("nbrCopie"));
		}
		return v;
	}
	public static ImageIcon getBookImg(ResultSet rs) throws SQLException {
		if(rs.next()) {
			return  new ImageIcon(rs.getBytes("bookImg"));
		}
		return null;
	}
	
	//---------------------------------------------prepared statement---------------------------------------------------------------------------
	
	
	public static Vector<String> getPrepBooksID(Connection con,String ID ) throws SQLException {
		
		PreparedStatement stmt   = con.prepareStatement("SELECT bookID FROM projectjava.books where bookID = ?");
		stmt.setString(1, ID);
		ResultSet rs = stmt.executeQuery("");
		Vector<String> v= new Vector<>();
		while(rs.next()) {				
				v.add(rs.getString("bookID"));
		}
		return v;
	}
	
	public static Vector<String> getPrepBooksTitle(Connection con,String bookTitre) throws SQLException {
		PreparedStatement stmt   = con.prepareStatement("SELECT bookTitre FROM projectjava.books where bookTitre = ?");
		stmt.setString(1, bookTitre);
		ResultSet rs = stmt.executeQuery("");
		Vector<String> v= new Vector<>();
		while(rs.next()) {				
				v.add(rs.getString("bookTitre"));
		}
		
		return v;
		
	}
	public static Vector<String> getPrepBooksCategory(Connection con,String bookCategory) throws SQLException {
		PreparedStatement stmt   = con.prepareStatement("SELECT bookCategory FROM projectjava.books where bookCategory = ?");
		stmt.setString(1, bookCategory);
		ResultSet rs = stmt.executeQuery("");
		Vector<String> v= new Vector<>();
		while(rs.next()) {				
				v.add(rs.getString("bookCategory"));
		}
		
		return v;

	}
	public static Vector<String> getPrepBooksCopies(Connection con, String nbrCopie) throws SQLException {
		PreparedStatement stmt   = con.prepareStatement("SELECT nbrCopie FROM projectjava.books where nbrCopie = ?");
		stmt.setString(1, nbrCopie);
		ResultSet rs = stmt.executeQuery("");
		Vector<String> v= new Vector<>();
		while(rs.next()) {				
				v.add(rs.getString("nbrCopie"));
		}
		
		return v;

	}
	
	///---------------------------------------- searching options ---------------------------------
	public static Vector<Vector<String>> getBooksAvailable(Connection con) throws SQLException {
		PreparedStatement stmt   = con.prepareStatement("SELECT * FROM projectjava.books where nbrCopie > 0");
		ResultSet rs = stmt.executeQuery();
		Vector<String> IDs= new Vector<>();
		Vector<String> Titles= new Vector<>();
		Vector<String> Categories= new Vector<>();
		Vector<String> nbrCopies= new Vector<>();
		
		while(rs.next()) {				
				IDs.add(rs.getString("bookID"));
				Titles.add(rs.getString("bookTitre"));
				Categories.add(rs.getString("bookCategory"));
				nbrCopies.add(rs.getString("nbrCopie"));
		}
		Vector<Vector<String>> v =new Vector<Vector<String>>();
		v.add(0,IDs);
		v.add(Titles);
		v.add(Categories);
		v.add(nbrCopies);
		return v;

	}
	public static Vector<Vector<String>> getBooksAll(Connection con) throws SQLException {
		PreparedStatement stmt   = con.prepareStatement("SELECT * FROM projectjava.books");
		ResultSet rs = stmt.executeQuery();
		Vector<String> IDs= new Vector<>();
		Vector<String> Titles= new Vector<>();
		Vector<String> Categories= new Vector<>();
		Vector<String> nbrCopies= new Vector<>();
		
		while(rs.next()) {				
				IDs.add(rs.getString("bookID"));
				Titles.add(rs.getString("bookTitre"));
				Categories.add(rs.getString("bookCategory"));
				nbrCopies.add(rs.getString("nbrCopie"));
		}
		Vector<Vector<String>> v =new Vector<Vector<String>>();
		v.add(0,IDs);
		v.add(Titles);
		v.add(Categories);
		v.add(nbrCopies);
		return v;

	}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
//--------------------------------------------------Search By Author----------------------------------------------------------------
	//------------------------------------------------------------All------------------------------------------
	public static Vector<Vector<String>> getBooksAuthor(Connection con,String author ) throws SQLException {
		PreparedStatement stmt   = con.prepareStatement("SELECT * FROM projectjava.books where author like ?");
		stmt.setString(1, "%"+author+"%");
		ResultSet rs = stmt.executeQuery();
		Vector<String> IDs= new Vector<>();
		Vector<String> Titles= new Vector<>();
		Vector<String> Categories= new Vector<>();
		Vector<String> nbrCopies= new Vector<>();
		Vector<String> Authors= new Vector<>();
		while(rs.next()) {				
				IDs.add(rs.getString("bookID"));
				Titles.add(rs.getString("bookTitre"));
				Categories.add(rs.getString("bookCategory"));
				nbrCopies.add(rs.getString("nbrCopie"));
				Authors.add(rs.getString("author"));
		}
		Vector<Vector<String>> v =new Vector<Vector<String>>();
		v.add(0,IDs);
		v.add(Titles);
		v.add(Authors);
		v.add(Categories);
		v.add(nbrCopies);
		
		return v;

	}
	//-------------------------------------------------------Available--------------------------------------
	public static Vector<Vector<String>> getBooksAuthorAvailable(Connection con,String author ) throws SQLException {
		PreparedStatement stmt   = con.prepareStatement("SELECT * FROM projectjava.books where (nbrCopie > 0) and (author like ? ) ");
		stmt.setString(1, "%"+author+"%");
		ResultSet rs = stmt.executeQuery();
		Vector<String> IDs= new Vector<>();
		Vector<String> Titles= new Vector<>();
		Vector<String> Categories= new Vector<>();
		Vector<String> nbrCopies= new Vector<>();
		Vector<String> Authors= new Vector<>();
		while(rs.next()) {				
				IDs.add(rs.getString("bookID"));
				Titles.add(rs.getString("bookTitre"));
				Categories.add(rs.getString("bookCategory"));
				nbrCopies.add(rs.getString("nbrCopie"));
				Authors.add(rs.getString("author"));
		}
		Vector<Vector<String>> v =new Vector<Vector<String>>();
		v.add(0,IDs);
		v.add(Titles);
		v.add(Authors);
		v.add(Categories);
		v.add(nbrCopies);
		
		return v;

	}
//--------------------------------------------------Search By Title----------------------------------------------------------------
	//----------------------------------------------------------All-----------------------------------
	public static Vector<Vector<String>> getBooksTitle(Connection con,String Title ) throws SQLException {
		PreparedStatement stmt   = con.prepareStatement("SELECT * FROM projectjava.books where bookTitre like ?");
		stmt.setString(1, "%"+Title+"%");
		ResultSet rs = stmt.executeQuery();
		Vector<String> IDs= new Vector<>();
		Vector<String> Titles= new Vector<>();
		Vector<String> Categories= new Vector<>();
		Vector<String> nbrCopies= new Vector<>();
		Vector<String> Authors= new Vector<>();
		while(rs.next()) {				
				IDs.add(rs.getString("bookID"));
				Titles.add(rs.getString("bookTitre"));
				Categories.add(rs.getString("bookCategory"));
				nbrCopies.add(rs.getString("nbrCopie"));
				Authors.add(rs.getString("author"));
		}
		Vector<Vector<String>> v =new Vector<Vector<String>>();
		v.add(0,IDs);
		v.add(Titles);
		v.add(Authors);
		v.add(Categories);
		v.add(nbrCopies); 
		
		return v;
	}
	//----------------------------------------------------Available--------------------------------
	public static Vector<Vector<String>> getBooksTitleAvailable(Connection con,String Title ) throws SQLException {
		PreparedStatement stmt   = con.prepareStatement("SELECT * FROM projectjava.books where (nbrCopie > 0) and (bookTitre like ? ) ");
		stmt.setString(1, "%"+Title+"%");
		ResultSet rs = stmt.executeQuery();
		Vector<String> IDs= new Vector<>();
		Vector<String> Titles= new Vector<>();
		Vector<String> Categories= new Vector<>();
		Vector<String> nbrCopies= new Vector<>();
		Vector<String> Authors= new Vector<>();
		while(rs.next()) {				
				IDs.add(rs.getString("bookID"));
				Titles.add(rs.getString("bookTitre"));
				Categories.add(rs.getString("bookCategory"));
				nbrCopies.add(rs.getString("nbrCopie"));
				Authors.add(rs.getString("author"));
		}
		Vector<Vector<String>> v =new Vector<Vector<String>>();
		v.add(0,IDs);
		v.add(Titles);
		v.add(Authors);
		v.add(Categories);
		v.add(nbrCopies);
		
		return v;
	}
	//-----------------------------------------------EXIST---------------------------------------
	public static boolean BookExist(ResultSet rs,int bookID ) throws SQLException {
		while(rs.next()) {
			if(rs.getInt(1) == bookID ) {
				return true ;
			}
		}
		return false;
	}
	//-----------------------------------------------DELETE---------------------------------------
public static boolean DeleteBook(Connection con,int bookID) {
		
	String sql = "DELETE FROM `projectjava`.`books` WHERE (`bookID` = ?)";
		try {	
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, bookID);
				stmt.execute();
				return true;
				
			}catch(Exception e){
				System.out.println(e);
				return false;
			}
	}
	
	
	//---------------------------------------------------------------------------------------------------------------------------------------
	
	public static boolean addBook(Connection con,int bookID,String bookTitre,String author,String bookCategory,String bookDescription ,int nbrCopie, FileInputStream input) {
		
		String sql = "INSERT INTO `projectjava`.`books` (`bookID`, `bookTitre`, `author`, `bookCategory`, `bookDescription`, `nbrCopie`, `bookImg`) VALUES (?, ?, ?, ?, ?, ?,?)";

		try {	
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, bookID);
				stmt.setString(2, bookTitre);
				stmt.setString(3, author);
				stmt.setString(4, bookCategory);
				stmt.setString(5, bookDescription);
				stmt.setInt(6, nbrCopie);
				stmt.setBinaryStream(7, input);
				stmt.execute();
				return true;
				
			}catch(Exception e){
				System.out.println(e);
				return false;
			}
	}
	//sql 
public static boolean editBook(Connection con,int oldbookID,int bookID,String bookTitre,String author,String bookCategory,String bookDescription ,int nbrCopie, FileInputStream input) {
		
		String sql = "UPDATE `projectjava`.`books` SET `bookID` = ? , `bookTitre` = ?, `author` = ?, `bookCategory` = ?, `bookDescription` = ?, `nbrCopie` = ?, `bookImg` = ? WHERE (`bookID` = ?)";

		try {	
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, bookID);
				stmt.setString(2, bookTitre);
				stmt.setString(3, author);
				stmt.setString(4, bookCategory);
				stmt.setString(5, bookDescription);
				stmt.setInt(6, nbrCopie);
				stmt.setBinaryStream(7, input);
				stmt.setInt(8, oldbookID);
				stmt.execute();
				return true;
				
			}catch(Exception e){
				System.out.println(e);
				return false;
			}
	}
public static boolean editBookNoImg(Connection con,int oldbookID,int bookID,String bookTitre,String author,String bookCategory,String bookDescription ,int nbrCopie) {
	
	String sql = "UPDATE `projectjava`.`books` SET `bookID` = ? , `bookTitre` = ?, `author` = ?, `bookCategory` = ?, `bookDescription` = ?, `nbrCopie` = ? WHERE (`bookID` = ?)";

	try {	 
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, bookID);
			stmt.setString(2, bookTitre);
			stmt.setString(3, author);
			stmt.setString(4, bookCategory);
			stmt.setString(5, bookDescription);
			stmt.setInt(6, nbrCopie);
			stmt.setInt(7, oldbookID);
			stmt.execute();
			return true;
			
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
}
	
public static boolean UpdateBookNbrCopies(Connection con,int bookID,int nbrCopie) {
	
	String sql = " UPDATE `projectjava`.`books` SET `nbrCopie` = ? WHERE (`bookID` = ?)";

	try {	
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, nbrCopie-1);
			stmt.setInt(2, bookID);
			
			stmt.execute();
			return true;
			
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
}

public static boolean ReturnBookDeadLine(Connection con,String userName,int bookID,int nbrCopies) {
	
	String sql1 = " UPDATE `projectjava`.`books` SET `nbrCopie` = ? WHERE (`bookID` = ?)";
	String sql2 = "DELETE FROM `projectjava`.`usersinventory` WHERE (`UserName` = ?) and (`ISBN` = ?);";
	try {	
			PreparedStatement stmt = con.prepareStatement(sql1);
			stmt.setInt(1, nbrCopies+1);
			stmt.setInt(2, bookID);
			stmt.execute();
			stmt = con.prepareStatement(sql2);
			stmt.setString(1, userName);
			stmt.setInt(2, bookID);
			stmt.execute();
			return true;
			
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
}

}
