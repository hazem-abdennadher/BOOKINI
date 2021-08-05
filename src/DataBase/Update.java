package DataBase;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;

public class Update {

	public static boolean updateBook(Connection con,int oldbookID,int bookID,String bookTitre,String author,String bookCategory,String bookDescription ,int nbrCopie, FileInputStream input) throws SQLException {
		try {
			
			if(con != null) { 
				
				return Books.editBook(con, oldbookID ,bookID, bookTitre, author, bookCategory, bookDescription, nbrCopie,input);
			} 
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return false;
		
	}
	public static boolean updateBookNoImg(Connection con,int oldbookID,int bookID,String bookTitre,String author,String bookCategory,String bookDescription ,int nbrCopie) throws SQLException {
		try {
			
			if(con != null) { 
				
				return Books.editBookNoImg(con, oldbookID ,bookID, bookTitre, author, bookCategory, bookDescription, nbrCopie);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return false;
		
	}
	public static boolean updateUser(Connection con, String username , String name ,String lastName , int age, String Bio ,FileInputStream input) throws SQLException {
		try {
			
			if(con != null) { 
				
				return Users.EditUser(con,username , name ,lastName, age, Bio,input);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return false;
		
	}

	public static boolean updateUserNoImg(Connection con, String username , String name ,String lastName , int age, String Bio ) throws SQLException {
		try {
			
			if(con != null) { 
				
				return Users.EditUserNoImg(con,username , name ,lastName, age, Bio);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return false;
		
	}
	
	public static boolean updateBookCopies(Connection con,int bookID,int nbrCopies ) throws SQLException {
		try {
			
			if(con != null) { 
				
				return Books.UpdateBookNbrCopies(con, bookID, nbrCopies);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return false;
		
	}
	
	public static boolean ReturnBookDeadLine(Connection con,String userName,int bookID,int nbrCopies ) throws SQLException {
		try {
			
			if(con != null) { 
				
				return Books.ReturnBookDeadLine(con, userName, bookID, nbrCopies);
			}
		}
		catch(Exception e) {
			System.out.println("Not Connected"+e);
		}
		return false;
		
	}
	
	
	
	
	

}
