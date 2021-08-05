package Screens;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import DataBase.DBConnection;
import DataBase.Insert;
import DataBase.RegexTest;
import DataBase.Select;
import DataBase.Update;

import java.awt.Color;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;

public class UserScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	static UserScreen frame;
	////---------------
	JPanel readMore ;
	JLabel Requests ; 
	//--------------------
	int isbn = 0;
	int nbrOfCopies =0;
	java.sql.Connection con = DBConnection.getConnection();
	JPanel MainPanel = null;
	JPanel Main;
	int isbn1 =0;
	int isbn2 =0;
	int isbn3 =0;
	
	String user= null;
	private JTextField NameField;
	private JTextField LastNameField;
	private JTextField AgeField;

	File f = new File(AdminScreen.class.getResource("/Images/bookCover.png").getFile());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new UserScreen("cyrus");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** 
	 * Create the frame.
	 * @throws SQLException 
	 */
	public UserScreen(String userName) throws SQLException {
		user =  userName; 
		setResizable(false);
		setTitle("BOOKINI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel SideBar = new JPanel();
		SideBar.setLayout(null);
		SideBar.setBounds(0, 0, 304, 731);
		contentPane.add(SideBar);
		
		JLabel BOOKINI = new JLabel("BOOKINI");
		BOOKINI.setFont(new Font("MV Boli", BOOKINI.getFont().getStyle(), BOOKINI.getFont().getSize() + 50));
		BOOKINI.setHorizontalTextPosition(SwingConstants.CENTER);
		BOOKINI.setHorizontalAlignment(SwingConstants.CENTER);
		BOOKINI.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		BOOKINI.setBounds(0, 0, 304, 80);
		
		SideBar.add(BOOKINI);
		
		JPanel Profile = new JPanel();
		
		Profile.setLayout(null);
		Profile.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		Profile.setBackground(SystemColor.menu);
		Profile.setBounds(0, 83, 304, 81);
		SideBar.add(Profile);
		
		JLabel ProfileLabel = new JLabel("PROFILE");
		ProfileLabel.setForeground(Color.BLACK);
		ProfileLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		ProfileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ProfileLabel.setFont(new Font("Verdana", Font.PLAIN, 29));
		ProfileLabel.setBounds(0, 0, 304, 80);
		Profile.add(ProfileLabel);
		
		JPanel Library = new JPanel();
		
		Library.setLayout(null);
		Library.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		Library.setBackground(SystemColor.menu);
		Library.setBounds(0, 163, 304, 80);
		SideBar.add(Library);
		
		JLabel LibraryLabel = new JLabel("LIBRARY");
		LibraryLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		LibraryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LibraryLabel.setFont(new Font("Verdana", Font.PLAIN, 29));
		LibraryLabel.setBounds(0, 0, 304, 80);
		Library.add(LibraryLabel);
		
		JPanel Search = new JPanel();
		
		Search.setLayout(null);
		Search.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		Search.setBackground(SystemColor.menu);
		Search.setBounds(0, 243, 304, 80);
		SideBar.add(Search);
		
		JLabel SearchLabel = new JLabel("SEARCH");
		SearchLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		SearchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SearchLabel.setFont(new Font("Verdana", Font.PLAIN, 29));
		SearchLabel.setBounds(0, 0, 304, 80);
		Search.add(SearchLabel);
		
		readMore = new JPanel();
		readMore.setBackground(new Color(240,240,240));
		readMore.setLayout(null);
		readMore.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		readMore.setBounds(0, 323, 304, 80);
		SideBar.add(readMore);
		
		Requests = new JLabel("READ MORE");
		Requests.setForeground(Color.BLACK);
		Requests.setHorizontalTextPosition(SwingConstants.CENTER);
		Requests.setHorizontalAlignment(SwingConstants.CENTER);
		Requests.setFont(new Font("Verdana", Font.PLAIN, 29));
		Requests.setBounds(0, 0, 304, 80);
		readMore.add(Requests);
		
		Main = new JPanel();
		Main.setLayout(null);
		Main.setBounds(308, 0, 1044, 731);
		contentPane.add(Main);
		
		
		
		Profile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.removeAll();
				try {
					ProfileTab();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Main.revalidate();
				Main.repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Profile.setBackground(new Color(112, 159, 176));
				ProfileLabel.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Profile.setBackground(SystemColor.menu);
				ProfileLabel.setForeground(Color.BLACK);
			}
		});
		//117, 183, 158
		Library.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.removeAll();
				try {
					LibraryTab();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				Main.revalidate();
				Main.repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Library.setBackground(new Color(117, 183, 158));
				LibraryLabel.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Library.setBackground(SystemColor.menu);
				LibraryLabel.setForeground(Color.BLACK);
			}
		});
		//93, 91, 106
		Search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.removeAll();
				SearchTab();
				Main.revalidate();
				Main.repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Search.setBackground(new Color(93, 91, 106));
				SearchLabel.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Search.setBackground(SystemColor.menu);
				SearchLabel.setForeground(Color.BLACK);
			}
		});
     //-----------------------------------------
		ProfileTab();
}
	
	public void ReadMoreTab(int isbn ) {
		JPanel ReadMoreTab = new JPanel();
		ReadMoreTab.setLayout(null);
		ReadMoreTab.setFont(new Font("Verdana", Font.PLAIN, 18));
		ReadMoreTab.setBorder(new MatteBorder(3, 3, 3, 3, new Color(131, 131, 131)));
		ReadMoreTab.setBounds(0, 0, 1044, 731);
		Main.add(ReadMoreTab);
		
		JLabel Title = new JLabel("READ MORE");
		Title.setOpaque(true);
		Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setForeground(Color.WHITE);
		Title.setFont(new Font("Verdana", Font.PLAIN, 69));
		Title.setBackground(new Color(131, 131, 131));
		Title.setBounds(0, 0, 1044, 76);
		ReadMoreTab.add(Title);
		
		JLabel BOOK1 = new JLabel("");
		BOOK1.setOpaque(true);
		BOOK1.setHorizontalTextPosition(SwingConstants.CENTER);
		BOOK1.setHorizontalAlignment(SwingConstants.CENTER);
		BOOK1.setFont(new Font("Verdana", Font.PLAIN, 30));
		BOOK1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		BOOK1.setBackground(new Color(255, 201, 150));
		BOOK1.setBounds(750, 117, 200, 200);
		ReadMoreTab.add(BOOK1);
		
		JTextPane Description = new JTextPane();
		Description.setEditable(false);
		Description.setFont(new Font("Verdana", Font.PLAIN, 18));
		Description.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		Description.setBounds(31, 412, 491, 292);
		ReadMoreTab.add(Description);
		
		JLabel BookDescription = new JLabel("DESCRIPTION :");
		BookDescription.setHorizontalTextPosition(SwingConstants.CENTER);
		BookDescription.setHorizontalAlignment(SwingConstants.LEFT);
		BookDescription.setFont(new Font("Verdana", Font.PLAIN, 18));
		BookDescription.setBounds(31, 377, 154, 25);
		ReadMoreTab.add(BookDescription);
		
		JLabel CATEGORY = new JLabel("CATEGORY :");
		CATEGORY.setHorizontalTextPosition(SwingConstants.CENTER);
		CATEGORY.setHorizontalAlignment(SwingConstants.RIGHT);
		CATEGORY.setFont(new Font("Verdana", Font.PLAIN, 18));
		CATEGORY.setBounds(327, 125, 121, 25);
		ReadMoreTab.add(CATEGORY);
		
		JLabel ISBN = new JLabel("ISBN :");
		ISBN.setHorizontalTextPosition(SwingConstants.CENTER);
		ISBN.setHorizontalAlignment(SwingConstants.LEFT);
		ISBN.setFont(new Font("Verdana", Font.PLAIN, 18));
		ISBN.setBounds(10, 125, 62, 25);
		ReadMoreTab.add(ISBN);
		
		JTextField isbnField = new JTextField();
		isbnField.setEditable(false);
		isbnField.setOpaque(false);
		isbnField.setFont(new Font("Verdana", Font.PLAIN, 18));
		isbnField.setColumns(10);
		isbnField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		isbnField.setBounds(82, 126, 125, 25);
		ReadMoreTab.add(isbnField);
		
		JLabel BookTitle = new JLabel("TITLE :");
		BookTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		BookTitle.setHorizontalAlignment(SwingConstants.LEFT);
		BookTitle.setFont(new Font("Verdana", Font.PLAIN, 18));
		BookTitle.setBounds(10, 175, 74, 25);
		ReadMoreTab.add(BookTitle);
		
		JTextField titleField = new JTextField();
		titleField.setEditable(false);
		titleField.setOpaque(false);
		titleField.setFont(new Font("Verdana", Font.PLAIN, 18));
		titleField.setColumns(10);
		titleField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		titleField.setBounds(75, 175, 229, 25);
		ReadMoreTab.add(titleField);
		
		JTextField AuthorField = new JTextField();
		AuthorField.setEditable(false);
		AuthorField.setOpaque(false);
		AuthorField.setFont(new Font("Verdana", Font.PLAIN, 18));
		AuthorField.setColumns(10);
		AuthorField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		AuthorField.setBounds(104, 225, 175, 25);
		ReadMoreTab.add(AuthorField);
		
		JTextField CategoryField = new JTextField();
		CategoryField.setEditable(false);
		CategoryField.setText("12");
		CategoryField.setOpaque(false);
		CategoryField.setFont(new Font("Verdana", Font.PLAIN, 18));
		CategoryField.setColumns(10);
		CategoryField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		CategoryField.setBounds(458, 126, 125, 25);
		ReadMoreTab.add(CategoryField);
		JLabel Author = new JLabel("AUTHOR :");
		Author.setHorizontalTextPosition(SwingConstants.CENTER);
		Author.setHorizontalAlignment(SwingConstants.LEFT);
		Author.setFont(new Font("Verdana", Font.PLAIN, 18));
		Author.setBounds(10, 224, 98, 25);
		ReadMoreTab.add(Author);
		
		JSeparator separator = new JSeparator();
		separator.setOpaque(true);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(327, 117, 2, 200);
		ReadMoreTab.add(separator);
		
		JLabel BookCover = new JLabel("BOOK COVER");
		BookCover.setHorizontalTextPosition(SwingConstants.CENTER);
		BookCover.setHorizontalAlignment(SwingConstants.CENTER);
		BookCover.setFont(new Font("Verdana", Font.PLAIN, 18));
		BookCover.setBounds(750, 327, 200, 25);
		ReadMoreTab.add(BookCover);
		
		JSeparator separator_1 = new JSeparator();
	    separator_1.setOrientation(SwingConstants.VERTICAL);
	    separator_1.setOpaque(true);
	    separator_1.setBounds(649, 117, 2, 200);
	    ReadMoreTab.add(separator_1);
	    
	    JButton btnReturnBook = new JButton("RETURN BOOK");
	  
	    btnReturnBook.setForeground(Color.WHITE);
	    btnReturnBook.setFont(new Font("Verdana", Font.PLAIN, 18));
	    btnReturnBook.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    btnReturnBook.setBackground(new Color(131, 131, 131));
	    btnReturnBook.setBounds(710, 522, 180, 47);
	    ReadMoreTab.add(btnReturnBook);
		
		String[] Info;
		try {
			Info = Select.getBookInfo(con, isbn);
			isbnField.setText(Info[0]);
			titleField.setText(Info[1]);
			AuthorField.setText(Info[2]);
			CategoryField.setText(Info[3]);
			Description.setText(Info[4]);
			
			Image im = Select.getBookImage(con, isbn).getImage(); 
		    Image myImg = im.getScaledInstance(BOOK1.getWidth(), BOOK1.getHeight(),Image.SCALE_SMOOTH);
		    ImageIcon newImage = new ImageIcon(myImg);
		    BOOK1.setIcon(newImage);
		    
		    JScrollPane scrollPane = new JScrollPane(Description);
		    scrollPane.setBounds(41, 412, 491, 292);
		    ReadMoreTab.add(scrollPane);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} 
		btnReturnBook.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		try {
		    			// TODO check before requesting 
		    			if(Select.UserBookDoesntExist(con, user, isbn)) {
		    				if(Insert.addBooksUsers(con, user, isbn,1)) {
								JOptionPane.showConfirmDialog(null, "REQUEST TO RETURN BOOK IS SENT ", "REQUEST SENT",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE );
							}
		    			}
		    			else {
		    				JOptionPane.showMessageDialog(null, "REQUEST ALREADY SENT","ERROR",JOptionPane.ERROR_MESSAGE);
		    				return;
		    			}
					} catch (HeadlessException | SQLException e1) {
						
						e1.printStackTrace();
					}
		    	}
		    });
		
		
	}
	
	@SuppressWarnings("deprecation")
	public void LibraryTab() throws SQLException {
		readMore.setBackground(new Color(240,240,240));
		Requests.setForeground(Color.BLACK);
		JPanel LibraryTab = new JPanel();
		LibraryTab.setLayout(null);
		LibraryTab.setFont(new Font("Verdana", Font.PLAIN, 18));
		LibraryTab.setBorder(new MatteBorder(3, 3, 3, 3, new Color(117, 183, 158)));
		LibraryTab.setBounds(0, 0, 1044, 731);
		Main.add(LibraryTab);
		
		JLabel Title = new JLabel("LIBRARY");
		Title.setOpaque(true);
		Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setForeground(Color.WHITE);
		Title.setFont(new Font("Verdana", Font.PLAIN, 69));
		Title.setBackground(new Color(117, 183, 158));
		Title.setBounds(0, 0, 1044, 76);
		LibraryTab.add(Title);
		
		JLabel BOOK1 = new JLabel("");
		BOOK1.setIcon(new ImageIcon(UserScreen.class.getResource("/Images/bookCover.png")));
		BOOK1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		BOOK1.setOpaque(true);
		BOOK1.setBackground(new Color(255, 201, 150));
		BOOK1.setFont(new Font("Verdana", Font.PLAIN, 30));
		BOOK1.setHorizontalTextPosition(SwingConstants.CENTER);
		BOOK1.setHorizontalAlignment(SwingConstants.CENTER);
		BOOK1.setBounds(122, 150, 200, 200);
		LibraryTab.add(BOOK1);
		
		JLabel BOOK2 = new JLabel("");
		BOOK2.setIcon(new ImageIcon(UserScreen.class.getResource("/Images/bookCover.png")));
		BOOK2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		BOOK2.setOpaque(true);
		BOOK2.setHorizontalTextPosition(SwingConstants.CENTER);
		BOOK2.setHorizontalAlignment(SwingConstants.CENTER);
		BOOK2.setFont(new Font("Verdana", Font.PLAIN, 30));
		BOOK2.setBackground(new Color(167, 233, 175));
		BOOK2.setBounds(422, 150, 200, 200);
		LibraryTab.add(BOOK2);
		
		JLabel BOOK3 = new JLabel("");
		BOOK3.setIcon(new ImageIcon(UserScreen.class.getResource("/Images/bookCover.png")));
		BOOK3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		BOOK3.setOpaque(true);
		BOOK3.setHorizontalTextPosition(SwingConstants.CENTER);
		BOOK3.setHorizontalAlignment(SwingConstants.CENTER);
		BOOK3.setFont(new Font("Verdana", Font.PLAIN, 30));
		BOOK3.setBackground(new Color(106, 140, 175));
		BOOK3.setBounds(722, 150, 200, 200);
		LibraryTab.add(BOOK3);
		
		JButton ReadMoreButton1 = new JButton("READ MORE");
		
		ReadMoreButton1.setForeground(Color.WHITE);
		ReadMoreButton1.setFont(new Font("Verdana", Font.PLAIN, 18));
		ReadMoreButton1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ReadMoreButton1.setBackground(new Color(255, 201, 150));
		ReadMoreButton1.setBounds(132, 360, 180, 47);
		LibraryTab.add(ReadMoreButton1);
		
		JButton ReadMoreButton2 = new JButton("READ MORE");
		
		ReadMoreButton2.setForeground(Color.WHITE);
		ReadMoreButton2.setFont(new Font("Verdana", Font.PLAIN, 18));
		ReadMoreButton2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ReadMoreButton2.setBackground(new Color(167, 233, 175));
		ReadMoreButton2.setBounds(432, 360, 180, 47);
		LibraryTab.add(ReadMoreButton2);
		JButton ReadMoreButton3 = new JButton("READ MORE");
		ReadMoreButton3.setForeground(Color.WHITE);
		ReadMoreButton3.setFont(new Font("Verdana", Font.PLAIN, 18));
		ReadMoreButton3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ReadMoreButton3.setBackground(new Color(106, 140, 175));
		ReadMoreButton3.setBounds(732, 360, 180, 47);
		LibraryTab.add(ReadMoreButton3);
		JTable  table = new JTable();
		table.setSelectionBackground(new Color(246, 209, 134));
		table.setFont(new Font("Verdana", Font.PLAIN, 18));
		table.setBorder(new MatteBorder(3, 0, 3,3, (Color) new Color(117, 183, 158)));
		table.setBounds(47, 521, 950, 200);
		LibraryTab.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(117, 183, 158)));
		scrollPane.setBounds(47, 521, 950, 200);
		LibraryTab.add(scrollPane);
		
		JButton LoadHistorybtn = new JButton("LOAD HISTORY");
		LoadHistorybtn.setForeground(Color.WHITE);
		LoadHistorybtn.setFont(new Font("Verdana", Font.PLAIN, 18));
		LoadHistorybtn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		LoadHistorybtn.setBackground(new Color(255, 113, 113));
		LoadHistorybtn.setBounds(432, 464, 180, 47);
		LibraryTab.add(LoadHistorybtn);
		int[] UserBooksIDs = Select.UserInventorybookID(con,user);	
		
		if(UserBooksIDs[2] != -1) {
			isbn1 = UserBooksIDs[0];
			isbn2 = UserBooksIDs[1];
			isbn3 = UserBooksIDs[2];

			 ImageIcon ic = Select.getBookImage(con, isbn1); 
				if(ic != null) {
					Image im = ic.getImage(); 
				    Image myImg = im.getScaledInstance(BOOK1.getWidth(), BOOK1.getHeight(),Image.SCALE_SMOOTH);
				    ImageIcon newImage = new ImageIcon(myImg);
				    BOOK1.setIcon(newImage);
				}
			ic = Select.getBookImage(con, isbn2); 
			if(ic != null) {
				Image im = ic.getImage(); 
				Image myImg = im.getScaledInstance(BOOK2.getWidth(), BOOK2.getHeight(),Image.SCALE_SMOOTH);
			    ImageIcon newImage = new ImageIcon(myImg);
			    BOOK2.setIcon(newImage);
			}
			ic = Select.getBookImage(con, isbn3); 
			if(ic != null) {
				Image  im = ic.getImage(); 
				Image myImg = im.getScaledInstance(BOOK3.getWidth(), BOOK3.getHeight(),Image.SCALE_SMOOTH);
				ImageIcon newImage = new ImageIcon(myImg);
			    BOOK3.setIcon(newImage);
			}
		   
		}
		else if(UserBooksIDs[1] != -1)  {
			 isbn1 = UserBooksIDs[0];
			 isbn2 = UserBooksIDs[1];
			 ImageIcon ic = Select.getBookImage(con, isbn1); 
				if(ic != null) {
					Image im = ic.getImage(); 
				    Image myImg = im.getScaledInstance(BOOK1.getWidth(), BOOK1.getHeight(),Image.SCALE_SMOOTH);
				    ImageIcon newImage = new ImageIcon(myImg);
				    BOOK1.setIcon(newImage);
				}
			ic = Select.getBookImage(con, isbn2); 
			if(ic != null) {
				Image im = ic.getImage(); 
				Image myImg = im.getScaledInstance(BOOK2.getWidth(), BOOK2.getHeight(),Image.SCALE_SMOOTH);
			    ImageIcon newImage = new ImageIcon(myImg);
			    BOOK2.setIcon(newImage);
			}
			
		    ReadMoreButton3.hide();
		}
		else if(UserBooksIDs[0] != -1) {
			isbn1 = UserBooksIDs[0];
			ImageIcon ic = Select.getBookImage(con, isbn1); 
			if(ic != null) {
				Image im = ic.getImage(); 
			    Image myImg = im.getScaledInstance(BOOK1.getWidth(), BOOK1.getHeight(),Image.SCALE_SMOOTH);
			    ImageIcon newImage = new ImageIcon(myImg);
			    BOOK1.setIcon(newImage);
			}
			
		    ReadMoreButton2.hide();
			ReadMoreButton3.hide();
		}
		
		else{
			ReadMoreButton1.hide();
			ReadMoreButton2.hide();
			ReadMoreButton3.hide();
		}
		
		
		
		ReadMoreButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.removeAll();
				ReadMoreTab(isbn1);
				readMore.setBackground(new Color(131, 131, 131));
				Requests.setForeground(Color.WHITE);
				Main.revalidate();
				Main.repaint();
				
			}
		});
		ReadMoreButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.removeAll();
				ReadMoreTab(isbn2);
				readMore.setBackground(new Color(131, 131, 131));
				Requests.setForeground(Color.WHITE);
				Main.revalidate();
				Main.repaint();
				
			}
		});
		ReadMoreButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.removeAll();
				
				ReadMoreTab(isbn3);
				readMore.setBackground(new Color(131, 131, 131));
				Requests.setForeground(Color.WHITE);
				Main.revalidate();
				Main.repaint();
				
			}
		});
		
	}
	
	public void SearchTab() {
		readMore.setBackground(new Color(240,240,240));
		Requests.setForeground(Color.BLACK);
		JPanel SearchBookTab = new JPanel();
		SearchBookTab.setLayout(null);
		SearchBookTab.setFont(new Font("Verdana", Font.PLAIN, 18));
		SearchBookTab.setBorder(new MatteBorder(3, 3, 3, 3, new Color(93, 91, 106)));
		SearchBookTab.setBounds(0, 0, 1044, 731);
		Main.add(SearchBookTab);
		
		JLabel SearchBookLabel = new JLabel("SEARCH BOOK");
		SearchBookLabel.setOpaque(true);
		SearchBookLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		SearchBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SearchBookLabel.setForeground(Color.WHITE);
		SearchBookLabel.setFont(new Font("Verdana", Font.PLAIN, 69));
		SearchBookLabel.setBackground(new Color(93, 91, 106));
		SearchBookLabel.setBounds(0, 0, 1044, 76);
		SearchBookTab.add(SearchBookLabel);
		
		JTextField SearchField = new JTextField();
		SearchField.setOpaque(false);
		SearchField.setFont(new Font("Verdana", Font.PLAIN, 32));
		SearchField.setColumns(10);
		SearchField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		SearchField.setBounds(149, 190, 556, 35);
		SearchBookTab.add(SearchField);
		
		JTable table = new JTable();
		table.setSelectionBackground(new Color(165, 143, 170));
		table.setFont(new Font("Verdana", Font.PLAIN, 18));
		table.setBorder(new MatteBorder(3, 0, 0, 3, (Color) new Color(93, 91, 106)));
		table.setBounds(47, 265, 950, 381);
		SearchBookTab.add(table);
		
		JRadioButton TitleOption = new JRadioButton("TITLE");
		buttonGroup.add(TitleOption);
		TitleOption.setSelected(true);
		TitleOption.setOpaque(false);
		TitleOption.setFont(new Font("Verdana", Font.PLAIN, 13));
		TitleOption.setActionCommand("TITLE");
		TitleOption.setBounds(287, 230, 63, 25);
		SearchBookTab.add(TitleOption);
		
		JRadioButton AuthorOption = new JRadioButton("AUTHOR");
		buttonGroup.add(AuthorOption);
		AuthorOption.setOpaque(false);
		AuthorOption.setFont(new Font("Verdana", Font.PLAIN, 13));
		AuthorOption.setActionCommand("AUTHOR");
		AuthorOption.setBounds(352, 230, 81, 25);
		SearchBookTab.add(AuthorOption);
		
		JLabel SearchBy = new JLabel("SEARCH BY :");
		SearchBy.setFont(new Font("Verdana", Font.PLAIN, 18));
		SearchBy.setBounds(149, 230, 132, 25);
		SearchBookTab.add(SearchBy);
		
		JCheckBox AvailabilityCheckBox = new JCheckBox("AVAILABILITY");
		AvailabilityCheckBox.setOpaque(false);
		AvailabilityCheckBox.setFont(new Font("Verdana", Font.PLAIN, 13));
		AvailabilityCheckBox.setBounds(588, 230, 117, 21);
		SearchBookTab.add(AvailabilityCheckBox);
		
		JButton SearchButton = new JButton("SEARCH");
		SearchButton.setForeground(Color.WHITE);
		SearchButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		SearchButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SearchButton.setBackground(new Color(93, 91, 106));
		SearchButton.setBounds(715, 178, 180, 47);
		SearchBookTab.add(SearchButton);
		
		JButton AddButton = new JButton("ADD TO LIBRARY");
		
		AddButton.setForeground(Color.WHITE);
		AddButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		AddButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		AddButton.setBackground(new Color(93, 91, 106));
		AddButton.setBounds(432, 656, 180, 47);
		SearchBookTab.add(AddButton);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(93, 91, 106)));
		scrollPane.setBounds(47, 265, 950, 381);
		SearchBookTab.add(scrollPane);
		
		
		
		
		//-------------------boogle----------------------
		JLabel B = new JLabel("B");
	     B.setHorizontalAlignment(SwingConstants.CENTER);
	     B.setHorizontalTextPosition(SwingConstants.CENTER);
	     B.setFont(new Font("Product Sans", Font.PLAIN, 90));
	     B.setForeground(new Color(66,133,244));
	     B.setBounds(298, 90, 85, 85);
	     SearchBookTab.add(B);
	     
	     JLabel O = new JLabel("o");
	     O.setFont(new Font("Product Sans", Font.PLAIN, 90));
	     O.setHorizontalTextPosition(SwingConstants.CENTER);
	     O.setHorizontalAlignment(SwingConstants.CENTER);
	     O.setForeground(new Color(219,68,55));
	     O.setBounds(348, 91, 85, 85);
	     SearchBookTab.add(O);
	     
	     JLabel O2 = new JLabel("o");
	     O2.setFont(new Font("Product Sans", Font.PLAIN, 90));
	     O2.setHorizontalTextPosition(SwingConstants.CENTER);
	     O2.setHorizontalAlignment(SwingConstants.CENTER);
	     O2.setForeground(new Color(244,160,0));
	     O2.setBounds(398, 90, 85, 85);
	     SearchBookTab.add(O2);
	     
	     JLabel G = new JLabel("g");
	     G.setVerticalAlignment(SwingConstants.BOTTOM);
	     G.setFont(new Font("Product Sans", Font.PLAIN, 90));
	     G.setHorizontalTextPosition(SwingConstants.CENTER);
	     G.setHorizontalAlignment(SwingConstants.CENTER);
	     G.setForeground(new Color(66, 133, 244));
	     G.setBounds(448, 105, 85, 85);
	     SearchBookTab.add(G);
	     
	     JLabel L = new JLabel("l");
	     L.setFont(new Font("Product Sans", Font.PLAIN, 90));
	     L.setHorizontalTextPosition(SwingConstants.CENTER);
	     L.setHorizontalAlignment(SwingConstants.CENTER);
	     L.setForeground(new Color(15,157,88));
	     L.setBounds(478, 90, 85, 85);
	     SearchBookTab.add(L);
	     
	     JLabel E = new JLabel("e");
	     E.setAlignmentY(0.0f);
	     E.setFont(new Font("Product Sans", Font.PLAIN, 90));
	     E.setHorizontalTextPosition(SwingConstants.CENTER);
	     E.setHorizontalAlignment(SwingConstants.CENTER);
	     E.setForeground(new Color(219,68,55));
	     E.setBounds(508, 90, 85, 85);
	     SearchBookTab.add(E);
		//------------------------------------------------
	     table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					boolean a = table.isEditing();
					if(!a) {
						isbn = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
						nbrOfCopies =  Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 4));
					}
				}
			}); 
	     SearchButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
		     			 String searchTerm = SearchField.getText();
		     			 Vector<Vector<String>> v = new  Vector<Vector<String>>();
		     			 String action = buttonGroup.getSelection().getActionCommand();
		     			if(AvailabilityCheckBox.isSelected() &&  action =="AUTHOR") {
		     				v = Select.getBooksTableAuthorAvailable(con,searchTerm);
		     			 }
		     			 else if (!AvailabilityCheckBox.isSelected() && action =="AUTHOR") {
		     				 v = Select.getBooksTableAuthor(con,searchTerm);
		     			 }
		     			 else if (AvailabilityCheckBox.isSelected()  && action =="TITLE" ) {
		     				 v = Select.getBooksTableTitleAvailable(con,searchTerm);
		     			 }
		     			 else if (!AvailabilityCheckBox.isSelected() &&  action =="TITLE") {
		     				 v = Select.getBooksTableTitle(con, searchTerm);
		     			 }
		     			 
		     			 DefaultTableModel model = new DefaultTableModel();
		     			 
		     				 model.addColumn("ISBN", v.elementAt(0));
		     				 model.addColumn("TITLE", v.elementAt(1));
		     				 model.addColumn("AUTHOR", v.elementAt(2));
		     				 model.addColumn("CATEGORY", v.elementAt(3));
		     				 model.addColumn("NUMBER OF COPIES", v.elementAt(4));
		     				 table.setModel(model);
		     				 repaint();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
		     	}
			});
	     AddButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		     		try {
		     			if(nbrOfCopies>0) {
		     				if(Select.UserBookDoesntExist(con, user, isbn)) {
		     					if(Select.UserBookInventoryDoesntExist(con, user, isbn)) {
		     						if(Insert.addBooksUsers(con, user, isbn,0)) {
										JOptionPane.showConfirmDialog(null, "REQUEST TO ADD BOOK TO LIBRARY ", "REQUEST SENT",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE );
									}
		     					}
		     					else {
		     						JOptionPane.showMessageDialog(null, "BOOK ALREADY EXIST IN YOUR LIBRARY","ERROR",JOptionPane.ERROR_MESSAGE);
									return;
		     					}
			     				
			     			}
			     			else {
			     				JOptionPane.showMessageDialog(null, "REQUEST ALREADY SENT","ERROR",JOptionPane.ERROR_MESSAGE);
								return;
			     			}
		     			}
		     			
		     			else {
		     				JOptionPane.showMessageDialog(null, "BOOK IS OUT OF STOCK","ERROR",JOptionPane.ERROR_MESSAGE);
							return;
		     			}
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
		     	}
			});
	}
public void ProfileTab() throws SQLException {
		readMore.setBackground(new Color(240,240,240));
		Requests.setForeground(Color.BLACK);
		JPanel AddBookTab = new JPanel();
		AddBookTab.setLayout(null);
		AddBookTab.setBorder(new MatteBorder(3, 3, 3, 3, new Color(112, 159, 176)));
		AddBookTab.setBounds(0, 0, 1044, 731);
		Main.add(AddBookTab);
		
		JLabel lblProfile = new JLabel("PROFILE");
		lblProfile.setOpaque(true);
		lblProfile.setHorizontalTextPosition(SwingConstants.CENTER);
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setFont(new Font("Verdana", Font.PLAIN, 69));
		lblProfile.setBackground(new Color(112, 159, 176));
		lblProfile.setBounds(0, 0, 1044, 76);
		AddBookTab.add(lblProfile);
		
		JLabel lblName = new JLabel("NAME :");
		lblName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblName.setBounds(10, 125, 121, 25);
		AddBookTab.add(lblName);
		
		NameField = new JTextField();
		NameField.setOpaque(false);
		NameField.setFont(new Font("Verdana", Font.PLAIN, 18));
		NameField.setColumns(10);
		NameField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		NameField.setBounds(130, 125, 125, 25);
		AddBookTab.add(NameField);
		
		JLabel lblLastName = new JLabel("LAST NAME :");
		lblLastName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblLastName.setBounds(0, 175, 131, 25);
		AddBookTab.add(lblLastName);
		
		LastNameField = new JTextField();
		LastNameField.setOpaque(false);
		LastNameField.setFont(new Font("Verdana", Font.PLAIN, 18));
		LastNameField.setColumns(10);
		LastNameField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 0)));
		LastNameField.setBounds(130, 175, 165, 25);
		AddBookTab.add(LastNameField);
		
		JLabel age = new JLabel("AGE :");
		age.setHorizontalTextPosition(SwingConstants.CENTER);
		age.setHorizontalAlignment(SwingConstants.RIGHT);
		age.setFont(new Font("Verdana", Font.PLAIN, 18));
		age.setBounds(10, 225, 111, 25);
		AddBookTab.add(age);
		
		JLabel lblBio = new JLabel("BIO :");
		lblBio.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBio.setHorizontalAlignment(SwingConstants.LEFT);
		lblBio.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblBio.setBounds(20, 375, 58, 25);
		AddBookTab.add(lblBio);
		
		JLabel lblUserPic = new JLabel("PROFILE PICTURE");
		lblUserPic.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPic.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblUserPic.setBounds(600, 140, 180, 25);
		AddBookTab.add(lblUserPic);
		
		JLabel profilePic = new JLabel("");
		profilePic.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		profilePic.setOpaque(true);
		profilePic.setHorizontalTextPosition(SwingConstants.CENTER);
		profilePic.setHorizontalAlignment(SwingConstants.CENTER);
		profilePic.setBackground(new Color(160, 193, 184));
		profilePic.setBounds(600, 175, 180, 180);
		AddBookTab.add(profilePic);
		
		JButton btnEditProfile = new JButton("EDIT PROFILE");
		btnEditProfile.setForeground(Color.WHITE);
		btnEditProfile.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnEditProfile.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnEditProfile.setBackground(new Color(112, 159, 176));
		btnEditProfile.setBounds(695, 508, 180, 47);
		AddBookTab.add(btnEditProfile); 
		
		JButton SelectPhotoButton = new JButton("SELECT PHOTO");
		SelectPhotoButton.setOpaque(false);
		SelectPhotoButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		SelectPhotoButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SelectPhotoButton.setBounds(600, 365, 180, 25);
		AddBookTab.add(SelectPhotoButton);
		
		JButton CancelButton = new JButton("CANCEL");
		CancelButton.setForeground(Color.WHITE);
		CancelButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		CancelButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		CancelButton.setBackground(new Color(255, 113, 113));
		CancelButton.setBounds(695, 571, 180, 47);
		AddBookTab.add(CancelButton);
		
		JTextPane BIO = new JTextPane();
		BIO.setFont(new Font("Verdana", Font.PLAIN, 18));
		BIO.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		BIO.setBounds(20, 410, 491, 292);
		AddBookTab.add(BIO);
		
		AgeField = new JTextField();
		AgeField.setOpaque(false);
		AgeField.setFont(new Font("Verdana", Font.PLAIN, 18));
		AgeField.setColumns(10);
		AgeField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		AgeField.setBounds(130, 225, 72, 25);
		AddBookTab.add(AgeField);
		
		
		
		
		
		//--------------------------------------------------
		NameField.setText(Select.userInfo(con, user, 2));
		LastNameField.setText(Select.userInfo(con, user, 3));
		AgeField.setText(Select.userInfo(con, user, 4));
		BIO.setText(Select.userInfo(con, user, 7));
		
		Image im = Select.getUserImage(con, user).getImage(); 
	    Image myImg = im.getScaledInstance(profilePic.getWidth(), profilePic.getHeight(),Image.SCALE_REPLICATE);
	    ImageIcon newImage = new ImageIcon(myImg);
	    profilePic.setIcon(newImage);
	    //------------------------------------------------------------------------
	    SelectPhotoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","png","jpg","jpeg");
				JFileChooser BrowserImg  = new JFileChooser();
				BrowserImg.addChoosableFileFilter(fnef);
				int showDialog = BrowserImg.showOpenDialog(null);
				if(showDialog == JFileChooser.APPROVE_OPTION) {
					File  selectedImgFile = BrowserImg.getSelectedFile();
					String selectedImgPath = selectedImgFile.getAbsolutePath();
					f= selectedImgFile;
					ImageIcon image = new ImageIcon(selectedImgPath);
				    Image im = image.getImage(); 
				    Image myImg = im.getScaledInstance(profilePic.getWidth(), profilePic.getHeight(),Image.SCALE_SMOOTH);
				    ImageIcon newImage = new ImageIcon(myImg);
				    profilePic.setIcon(newImage);
				}
			}
		});
	    
	    btnEditProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = NameField.getText();
				String lastName = LastNameField.getText();
				String age = AgeField.getText();
				String Bio = BIO.getText();
				if(!RegexTest.TestAge(age)) {
					JOptionPane.showMessageDialog(null, "AGE MUST BE AN INTEGER AND LESS THAN 99","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				int iage = Integer.parseInt(age);

				
				try {
					if(f.getName() != "bookCover.png") {
						FileInputStream input = new FileInputStream(f);
						if(Update.updateUser(con, user,name, lastName, iage, Bio, input)) {
							JOptionPane.showConfirmDialog(null, "USER UPDATED", "UPDATED",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE );
							}
							else {
								JOptionPane.showMessageDialog(null, "CAN'T UPDATE USER","ERROR",JOptionPane.ERROR_MESSAGE);
								return;
							}
					}
					else {
						if(Update.updateUserNoImg(con, user,name, lastName, iage, Bio)) {
							JOptionPane.showConfirmDialog(null, "USER UPDATED", "UPDATED",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE );
							}
							else {
								JOptionPane.showMessageDialog(null, "CAN'T UPDATE USER","ERROR",JOptionPane.ERROR_MESSAGE);
								return;
							}
					}
						
					
				} catch (HeadlessException | SQLException | FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	}
}