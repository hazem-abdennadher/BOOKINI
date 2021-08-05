package Screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import DataBase.DBConnection;
import DataBase.Insert;
import DataBase.RegexTest;
import DataBase.Select;
import DataBase.Update;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class AdminScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel Main;
	private int bookOldId;
	int isbn = -1 ;
	private String type ;
	private String  username ;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	java.sql.Connection con = DBConnection.getConnection();
	File f = new File(AdminScreen.class.getResource("/Images/bookCover.png").getFile());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminScreen frame = new AdminScreen();
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
	 * @throws FileNotFoundException 
	 */
	public AdminScreen() throws SQLException, FileNotFoundException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1366, 768);
		setTitle("BOOKINI");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		Main = new JPanel();
		Main.setBounds(308, 0, 1044, 731);
		contentPane.add(Main);
		Main.setLayout(null);
		
		
		
		
		
		
		//----------------------------------------------------------------------------------------------------------------

		JPanel SideBar = new JPanel();
		SideBar.setBounds(0, 0, 304, 731);
		contentPane.add(SideBar);
		SideBar.setLayout(null);
		
		JLabel BOOKINI = new JLabel("BOOKINI");
		BOOKINI.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		BOOKINI.setFont(new Font("MV Boli", BOOKINI.getFont().getStyle(), BOOKINI.getFont().getSize() + 50));
		BOOKINI.setHorizontalAlignment(SwingConstants.CENTER);
		BOOKINI.setHorizontalTextPosition(SwingConstants.CENTER);
		BOOKINI.setBounds(0, 0, 304, 80);
		SideBar.add(BOOKINI);
		
		JPanel addBook = new JPanel();
		addBook.setBackground(new Color(240,240,240));
		addBook.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		addBook.setBounds(0, 83, 304, 81);
		SideBar.add(addBook);
		addBook.setLayout(null);
		
		JLabel Add = new JLabel("ADD BOOK");
		Add.setFont(new Font("Verdana", Font.PLAIN, 29));
		Add.setHorizontalTextPosition(SwingConstants.CENTER);
		Add.setHorizontalAlignment(SwingConstants.CENTER);
		Add.setBounds(0, 0, 304, 80);
		addBook.add(Add);
		
		JPanel RemoveBook = new JPanel();
		RemoveBook.setBackground(new Color(240,240,240));
		RemoveBook.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		RemoveBook.setBounds(0, 163, 304, 80);
		SideBar.add(RemoveBook);
		RemoveBook.setLayout(null);
		
		JLabel Remove = new JLabel("REMOVE BOOK");
		Remove.setFont(new Font("Verdana", Font.PLAIN, 29));
		Remove.setHorizontalTextPosition(SwingConstants.CENTER);
		Remove.setHorizontalAlignment(SwingConstants.CENTER);
		Remove.setBounds(0, 0, 304, 80);
		RemoveBook.add(Remove);
		
		JPanel EditBook = new JPanel();
		EditBook.setBackground(new Color(240,240,240));
		
		EditBook.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		EditBook.setBounds(0, 243, 304, 80);
		SideBar.add(EditBook);
		EditBook.setLayout(null);
		
		JLabel Edit = new JLabel("EDIT BOOK");
		Edit.setFont(new Font("Verdana", Font.PLAIN, 29));
		Edit.setHorizontalAlignment(SwingConstants.CENTER);
		Edit.setHorizontalTextPosition(SwingConstants.CENTER);
		Edit.setBounds(0, 0, 304, 80);
		EditBook.add(Edit);
		
		JPanel UserRequests = new JPanel();
		UserRequests.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		UserRequests.setBounds(0, 323, 304, 80);
		SideBar.add(UserRequests);
		UserRequests.setLayout(null);
		
		JLabel Requests = new JLabel("REQUESTS");
		Requests.setFont(new Font("Verdana", Font.PLAIN, 29));
		Requests.setHorizontalTextPosition(SwingConstants.CENTER);
		Requests.setHorizontalAlignment(SwingConstants.CENTER);
		Requests.setBounds(0, 0, 304, 80);
		UserRequests.add(Requests);
		
		
		addBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.removeAll();
				try {
					AddBookTab();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				Main.revalidate();
				Main.repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				addBook.setBackground(new Color(255, 123, 84));
				Add.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				addBook.setBackground(new Color(240,240,240));
				Add.setForeground(Color.BLACK);
			}
		});
		RemoveBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.removeAll();
				RemoveBookTab();
				Main.revalidate();
				Main.repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				RemoveBook.setBackground(new Color(137, 120, 83));
				Remove.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				RemoveBook.setBackground(new Color(240,240,240));
				Remove.setForeground(Color.BLACK);
			}
		});
		EditBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.removeAll();
				EditBookTab();
				Main.revalidate();
				Main.repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				EditBook.setBackground(new Color(94, 170, 168));
				Edit.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				EditBook.setBackground(new Color(240,240,240));
				Edit.setForeground(Color.BLACK);
			}
		});
		UserRequests.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.removeAll();
				RequestsTab();
				Main.revalidate();
				Main.repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				UserRequests.setBackground(new Color(165, 143, 170));
				Requests.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				UserRequests.setBackground(new Color(240,240,240));
				Requests.setForeground(Color.BLACK);
			}
		});
		AddBookTab();
	}
	
	public void RequestsTab() {
		JPanel RequestTab = new JPanel();
		RequestTab.setBounds(0, 0, 1044, 731);
		Main.add(RequestTab);
		RequestTab.setLayout(null);
		
		JLabel Title = new JLabel("REQUESTS");
		Title.setBounds(0, 0, 1044, 76);
		Title.setForeground(Color.WHITE);
		Title.setOpaque(true);
		Title.setBackground(new Color(165, 143, 170));
		Title.setFont(new Font("Verdana", Font.PLAIN, 68));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setHorizontalTextPosition(SwingConstants.CENTER);
		RequestTab.add(Title);
		
		JTable table = new JTable();
		table.setSelectionBackground(new Color(165, 143, 170));
		table.setFont(new Font("Verdana", Font.PLAIN, 18));
		table.setBorder(new MatteBorder(3, 0, 0, 3, (Color) new Color(165, 143, 170)));
		table.setBounds(47, 196, 950, 450);
		RequestTab.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(165, 143, 170)));
		scrollPane.setBounds(47, 192, 950, 428);
		RequestTab.add(scrollPane);
		
		JButton AcceptButton = new JButton("ACCEPT");
		AcceptButton.setForeground(Color.WHITE);
		AcceptButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		AcceptButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		AcceptButton.setBackground(new Color(144, 127, 164));
		AcceptButton.setBounds(432, 645, 180, 47);
		RequestTab.add(AcceptButton);
		
		
		JButton RequestButton = new JButton("SHOW REQUESTS");
		RequestButton.setForeground(Color.WHITE);
		RequestButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		RequestButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		RequestButton.setBackground(new Color(144, 127, 164));
		RequestButton.setBounds(432, 120, 180, 47);
		RequestTab.add(RequestButton);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean a = table.isEditing();
				if(!a) {
					username = (String) table.getValueAt(table.getSelectedRow(), 0);
					isbn = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 1));
					type = (String) table.getValueAt(table.getSelectedRow(), 4);
				}
			}
		});
		
		RequestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
						Vector<Vector<String>> v = new  Vector<Vector<String>>();
		     			v = Select.getUsersBooksRequets(con);
		     			 
						 DefaultTableModel model = new DefaultTableModel();
	     				 model.addColumn("USER ID", v.elementAt(0));
	     				 model.addColumn("IBSN ", v.elementAt(1));
	     				 model.addColumn("USER NAME", v.elementAt(2));
	     				 model.addColumn("book TITLE", v.elementAt(3));
	     				model.addColumn("REQUEST TYPE", v.elementAt(4));
	     				 table.setModel(model);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		AcceptButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] Info = null;
				try {
					Info = Select.getBookInfo(con, isbn);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(type.equalsIgnoreCase("REQUEST") ) {
					try {
						if(Select.UserInventoryCount(con, username)<3) {
						if(DataBase.Delete.deleteUserBook(con, username, isbn)) {
							
							Update.updateBookCopies(con, isbn,Integer.parseInt(Info[5]));
							Insert.add2UserInventory(con, username, isbn);
							JOptionPane.showConfirmDialog(null, "REQUEST ACCEPTED", "ACCEPTED",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE );
						}
						}
						else {
							JOptionPane.showMessageDialog(null, username.toUpperCase() + " ALREADY HAVE 3 BOOKS IN HIS LIBRARY","ERROR",JOptionPane.ERROR_MESSAGE);
						}
						
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
				else if(type.equalsIgnoreCase("RETURN")) {
					try {
						if(DataBase.Delete.deleteUserBook(con, username, isbn)) {
							if(Update.ReturnBookDeadLine(con, username, isbn, Integer.parseInt(Info[5]))){
								JOptionPane.showConfirmDialog(null, "BOOK RETURNED", "ACCEPTED",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE );
							}
							else {
								JOptionPane.showMessageDialog(null, "CAN'T REMOVE BOOK FROM USER LIBRARY","ERROR",JOptionPane.ERROR_MESSAGE);
							}
							
						}
						else {
							JOptionPane.showMessageDialog(null, "CAN'T REMOVE REQUEST","ERROR",JOptionPane.ERROR_MESSAGE);
						}
						
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "YOU NEED TO SELECT A REQUEST","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					
					Vector<Vector<String>> v = new  Vector<Vector<String>>();
	     			v = Select.getUsersBooksRequets(con);
	     			 
					 DefaultTableModel model = new DefaultTableModel();
     				 model.addColumn("USER ID", v.elementAt(0));
     				 model.addColumn("IBSN ", v.elementAt(1));
     				 model.addColumn("USER NAME", v.elementAt(2));
     				 model.addColumn("book TITLE", v.elementAt(3));
     				 model.addColumn("REQUEST TYPE", v.elementAt(4));
     				 table.setModel(model);
						} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				RequestButton.setBackground(new Color(165, 143, 170));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				RequestButton.setBackground(new Color(144, 127, 164));
			}
		});
		
		
	}
	
	
	public void EditBookTab() {
		
		JPanel EditBookTab = new JPanel();
		EditBookTab.setBorder(new MatteBorder(3, 3, 3, 3, new Color(163, 210, 202)));
		EditBookTab.setBounds(0, 0, 1044, 731);
		Main.add(EditBookTab);
		EditBookTab.setLayout(null);
		
		JLabel Title = new JLabel("EDIT BOOK");
		Title.setForeground(Color.WHITE);
		Title.setBackground(new Color(163, 210, 202));
		Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Verdana", Font.PLAIN, 69));
		Title.setBounds(0, 0, 1044, 76);
		Title.setOpaque(true);
		EditBookTab.add(Title);
		
		JTextField SearchField = new JTextField();
		SearchField.setFont(new Font("Verdana", Font.PLAIN, 32));
		SearchField.setOpaque(false);
		SearchField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		SearchField.setBounds(149, 115, 556, 35);
		EditBookTab.add(SearchField);
		SearchField.setColumns(10);
		//----------------
		JRadioButton TitleOption = new JRadioButton("TITLE");
		buttonGroup.add(TitleOption);
		TitleOption.setSelected(true);
		TitleOption.setOpaque(false);
		TitleOption.setFont(new Font("Verdana", Font.PLAIN, 13));
		TitleOption.setActionCommand("TITLE");
		TitleOption.setBounds(287, 155, 63, 25);
		EditBookTab.add(TitleOption);
		
		JRadioButton AuthorOption = new JRadioButton("AUTHOR");
		buttonGroup.add(AuthorOption);
		AuthorOption.setOpaque(false);
		AuthorOption.setFont(new Font("Verdana", Font.PLAIN, 13));
		AuthorOption.setActionCommand("AUTHOR");
		AuthorOption.setBounds(352, 155, 81, 25);
		EditBookTab.add(AuthorOption);
		
		JLabel SearchBy = new JLabel("SEARCH BY :");
		SearchBy.setFont(new Font("Verdana", Font.PLAIN, 18));
		SearchBy.setBounds(149, 155, 132, 25);
		EditBookTab.add(SearchBy);
		
		JCheckBox AvailabilityCheckBox = new JCheckBox("AVAILABILITY");
		AvailabilityCheckBox.setFont(new Font("Verdana", Font.PLAIN, 13));
		AvailabilityCheckBox.setOpaque(false);
		AvailabilityCheckBox.setBounds(588, 155, 117, 21);
		EditBookTab.add(AvailabilityCheckBox);
		
		JButton SearchButton = new JButton("SEARCH");
		SearchButton.setForeground(Color.WHITE);
		SearchButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		SearchButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SearchButton.setBackground(new Color(163, 210, 202));
		SearchButton.setBounds(715, 103, 180, 47);
		EditBookTab.add(SearchButton);
		
		JTable table = new JTable();
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(new Color(190, 229, 211));
		table.setFont(new Font("Verdana", Font.PLAIN, 16));
		table.setBorder(new MatteBorder(3, 0, 0, 3, (Color) new Color(163, 210, 202)));
		table.setBounds(47, 192, 950, 148);
		EditBookTab.add(table);
		
		
		JLabel BookTitle = new JLabel("TITLE :");
		BookTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		BookTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		BookTitle.setFont(new Font("Verdana", Font.PLAIN, 18));
		BookTitle.setBounds(10, 424, 72, 25);
		EditBookTab.add(BookTitle);
		
		JTextField TitleField = new JTextField();
		TitleField.setFont(new Font("Verdana", Font.PLAIN, 18));
		TitleField.setOpaque(false);
		TitleField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		TitleField.setBounds(92, 425, 189, 25);
		EditBookTab.add(TitleField);
		TitleField.setColumns(10);
		JLabel ISBN = new JLabel("ISBN :");
		ISBN.setHorizontalTextPosition(SwingConstants.CENTER);
		ISBN.setHorizontalAlignment(SwingConstants.RIGHT);
		ISBN.setFont(new Font("Verdana", Font.PLAIN, 18));
		ISBN.setBounds(8, 374, 62, 25);
		EditBookTab.add(ISBN);
		
		JTextField ISBNField = new JTextField();
		ISBNField.setFont(new Font("Verdana", Font.PLAIN, 18));
		ISBNField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		ISBNField.setOpaque(false);
		ISBNField.setBounds(80, 375, 125, 25);
		EditBookTab.add(ISBNField);
		ISBNField.setColumns(10);
		
	
		
		JLabel Author = new JLabel("AUTHOR :");
		Author.setFont(new Font("Verdana", Font.PLAIN, 18));
		Author.setHorizontalTextPosition(SwingConstants.CENTER);
		Author.setHorizontalAlignment(SwingConstants.RIGHT);
		Author.setBounds(10, 475, 95, 25);
		EditBookTab.add(Author);
		
		JTextField authorIdField = new JTextField();
		authorIdField.setFont(new Font("Verdana", Font.PLAIN, 18));
		authorIdField.setOpaque(false);
		authorIdField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		authorIdField.setBounds(115, 476, 166, 25);
		EditBookTab.add(authorIdField);
		authorIdField.setColumns(10);
		
		JLabel Genre = new JLabel("GENRE :");
		Genre.setHorizontalTextPosition(SwingConstants.CENTER);
		Genre.setHorizontalAlignment(SwingConstants.RIGHT);
		Genre.setFont(new Font("Verdana", Font.PLAIN, 18));
		Genre.setBounds(321, 409, 87, 25);
		EditBookTab.add(Genre);
		
		JComboBox<String> GenrecomboBox = new JComboBox<String>();
		GenrecomboBox.setBounds(418, 413, 125, 25);
		GenrecomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"ACTION", "ADVENTURE", "CLASSIC", "MYSTERY", "FANTASY", "HORROR", "ROMANCE", "SCIENCE"}));
		EditBookTab.add(GenrecomboBox);
		
		JLabel Quanitity = new JLabel("QUANITITY :");
		Quanitity.setHorizontalTextPosition(SwingConstants.CENTER);
		Quanitity.setHorizontalAlignment(SwingConstants.RIGHT);
		Quanitity.setFont(new Font("Verdana", Font.PLAIN, 18));
		Quanitity.setBounds(321, 374, 121, 25);
		EditBookTab.add(Quanitity);
		
		JSpinner spinner = new JSpinner();
		spinner.setBackground(Color.WHITE);
		spinner.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		spinner.setFont(new Font("Verdana", Font.PLAIN, 18));
		spinner.setBounds(452, 375, 87, 25);
		EditBookTab.add(spinner);
		
		JLabel BookDescription = new JLabel("Description :");
		BookDescription.setHorizontalTextPosition(SwingConstants.CENTER);
		BookDescription.setHorizontalAlignment(SwingConstants.LEFT);
		BookDescription.setFont(new Font("Verdana", Font.PLAIN, 18));
		BookDescription.setBounds(8, 525, 121, 25);
		EditBookTab.add(BookDescription);
		
		JLabel BookCover = new JLabel("BOOK COVER :");
		BookCover.setHorizontalTextPosition(SwingConstants.CENTER);
		BookCover.setHorizontalAlignment(SwingConstants.RIGHT);
		BookCover.setFont(new Font("Verdana", Font.PLAIN, 18));
		BookCover.setBounds(747, 374, 148, 25);
		EditBookTab.add(BookCover);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminScreen.class.getResource("/Images/bookCover.png")));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 213, 107));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(715, 399, 236, 201);
		EditBookTab.add(lblNewLabel);
		
		JTextPane Description = new JTextPane();
		Description.setFont(new Font("Verdana", Font.PLAIN, 18));
		Description.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		Description.setBounds(10, 560, 540, 159);
		Description.setSize(826,159);
		EditBookTab.add(Description);
		
		
		JButton EditBookButton = new JButton("EDIT BOOK");
		
		EditBookButton.setForeground(Color.WHITE);
		EditBookButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		EditBookButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		EditBookButton.setBackground(new Color(148, 208, 204));
		EditBookButton.setBounds(664, 661, 180, 47);
		EditBookTab.add(EditBookButton);
		
		JButton SelectPhotoButton = new JButton("SELECT PHOTO");
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
					    Image myImg = im.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
					    ImageIcon newImage = new ImageIcon(myImg);
					    lblNewLabel.setIcon(newImage);
					}
			}
		});
		SelectPhotoButton.setOpaque(false);
		SelectPhotoButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SelectPhotoButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		SelectPhotoButton.setBounds(757, 610, 148, 25);
		EditBookTab.add(SelectPhotoButton);
		
		JButton CancelButton = new JButton("CANCEL");
		CancelButton.setForeground(Color.WHITE);
		CancelButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		CancelButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		CancelButton.setBackground(new Color(255, 113, 113));
		CancelButton.setBounds(854, 661, 180, 47);
		EditBookTab.add(CancelButton);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(163, 210, 202)));
		scrollPane.setBounds(47, 192, 950, 148);
		EditBookTab.add(scrollPane);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(309, 374, 2, 140);
		EditBookTab.add(separator);
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane(Description);
		scrollPane_1.setBounds(18, 560, 540, 159);
		EditBookTab.add(scrollPane_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(588, 374, 2, 280);
		EditBookTab.add(separator_1);
		
		
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
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	     	}
		});
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean a = table.isEditing();
				if(!a) {
					int isbn = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
					bookOldId= isbn;
					String[] Info;
					try {
						Info = Select.getBookInfo(con, isbn);
						ISBNField.setText(Info[0]);
						TitleField.setText(Info[1]);
						authorIdField.setText(Info[2]);
						Description.setText(Info[4]);
						spinner.setValue(Integer.parseInt(Info[5]));	
						int i=0;
						for ( i= 0; i < GenrecomboBox.getItemCount(); i++) {
							if(Info[3].equalsIgnoreCase((String) GenrecomboBox.getItemAt(i))) {
								GenrecomboBox.setSelectedItem(i);
								GenrecomboBox.revalidate();
								GenrecomboBox.repaint();	
								break;
							}
						}
						
						Image im = Select.getBookImage(con, isbn).getImage(); 
					    Image myImg = im.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
					    ImageIcon newImage = new ImageIcon(myImg);
					    lblNewLabel.setIcon(newImage);
						
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					} 
					
					
				}
			}
		});
		
		EditBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = ISBNField.getText();
				String title = TitleField.getText();
				String Genre = GenrecomboBox.getSelectedItem().toString();
				String author= authorIdField.getText();
				String description = Description.getText();
				int Copies = (Integer) spinner.getValue();
				if(isbn.isEmpty()) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER AN ISBN","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!RegexTest.OnlyNum(isbn)) {
					JOptionPane.showMessageDialog(null, "ISBN MUST BE AN INTEGER","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				int isbni = Integer.parseInt(isbn);
				if(title.isEmpty()) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER A TITLE","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(author.isEmpty()) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER AN AUTHOR","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(description.isEmpty()) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER A DESCRIPTION","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(Copies<0) {
					JOptionPane.showMessageDialog(null, "N° OF COPIES CAN'T BE NEGATIVE","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					if(Select.bookExist(con, bookOldId)) {
						if(f.getName() != "bookCover.png") {
							FileInputStream input = new FileInputStream(f);
							if(Update.updateBook(con, bookOldId ,isbni, title, author, Genre, description, Copies,input)) {
							JOptionPane.showConfirmDialog(null, "BOOK UPDATED", "UPDATED",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE );
							}
							else {
								JOptionPane.showMessageDialog(null, "CAN'T UPDATE BOOK","ERROR",JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
						else {
							if(Update.updateBookNoImg(con, bookOldId ,isbni, title, author, Genre, description, Copies)) {
								JOptionPane.showConfirmDialog(null, "BOOK UPDATED", "UPDATED",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE );
								}
								else {
									JOptionPane.showMessageDialog(null, "CAN'T UPDATE BOOK","ERROR",JOptionPane.ERROR_MESSAGE);
									return;
								}
						}
						
						
					}
					else {
						JOptionPane.showMessageDialog(null, "BOOK DOESN'T EXIST","ERROR",JOptionPane.ERROR_MESSAGE);
						return;
						
					}
				} catch (HeadlessException | SQLException | FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
	}
	
	
	public void RemoveBookTab() {
		JPanel RemoveBookTab = new JPanel();
		RemoveBookTab.setFont(new Font("Verdana", Font.PLAIN, 18));
		RemoveBookTab.setBorder(new MatteBorder(3, 3, 3, 3, new Color(137, 120, 83)));
		RemoveBookTab.setBounds(0, 0, 1044, 731);
		Main.add(RemoveBookTab);
		RemoveBookTab.setLayout(null);
		
		JLabel RemoveBookLabel = new JLabel("REMOVE BOOK");
		RemoveBookLabel.setFont(new Font("Verdana", Font.PLAIN, 69));
		RemoveBookLabel.setForeground(Color.WHITE);
		RemoveBookLabel.setBounds(0, 0, 1044, 76);
		RemoveBookLabel.setBackground(new Color(137, 120, 83));
		RemoveBookLabel.setOpaque(true);
		RemoveBookLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		RemoveBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RemoveBookTab.add(RemoveBookLabel);
		
		JTextField SearchField = new JTextField();
		SearchField.setFont(new Font("Verdana", Font.PLAIN, 32));
		SearchField.setOpaque(false);
		SearchField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		SearchField.setBounds(149, 115, 556, 35);
		RemoveBookTab.add(SearchField);
		SearchField.setColumns(10);
		
		JTable table = new JTable();
		table.setSelectionBackground(new Color(241, 202, 137));
		table.setFont(new Font("Verdana", Font.PLAIN, 18));
		table.setBorder(new MatteBorder(3, 0, 0, 3, (Color) new Color(137, 120, 83)));
		table.setBounds(47, 196, 950, 450);
		RemoveBookTab.add(table);
		
		JRadioButton TitleOption = new JRadioButton("TITLE");
		buttonGroup.add(TitleOption);
		TitleOption.setSelected(true);
		TitleOption.setOpaque(false);
		TitleOption.setFont(new Font("Verdana", Font.PLAIN, 13));
		TitleOption.setActionCommand("TITLE");
		TitleOption.setBounds(287, 155, 63, 25);
		RemoveBookTab.add(TitleOption);
		
		JRadioButton AuthorOption = new JRadioButton("AUTHOR");
		buttonGroup.add(AuthorOption);
		AuthorOption.setOpaque(false);
		AuthorOption.setFont(new Font("Verdana", Font.PLAIN, 13));
		AuthorOption.setActionCommand("AUTHOR");
		AuthorOption.setBounds(352, 155, 81, 25);
		RemoveBookTab.add(AuthorOption);
		
		JLabel SearchBy = new JLabel("SEARCH BY :");
		SearchBy.setFont(new Font("Verdana", Font.PLAIN, 18));
		SearchBy.setBounds(149, 155, 132, 25);
		RemoveBookTab.add(SearchBy);
		
		JCheckBox AvailabilityCheckBox = new JCheckBox("AVAILABILITY");
		AvailabilityCheckBox.setFont(new Font("Verdana", Font.PLAIN, 13));
		AvailabilityCheckBox.setOpaque(false);
		AvailabilityCheckBox.setBounds(588, 155, 117, 21);
		RemoveBookTab.add(AvailabilityCheckBox);
		
		JButton SearchButton = new JButton("SEARCH");
		
		SearchButton.setForeground(Color.WHITE);
		SearchButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		SearchButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SearchButton.setBackground(new Color(137, 120, 83));
		SearchButton.setBounds(715, 103, 180, 47);
		RemoveBookTab.add(SearchButton);
		
		JButton RemoveButton = new JButton("REMOVE");
		
		RemoveButton.setForeground(Color.WHITE);
		RemoveButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		RemoveButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		RemoveButton.setBackground(new Color(73, 51, 35));
		RemoveButton.setBounds(432, 656, 180, 47);
		RemoveBookTab.add(RemoveButton);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(137, 120, 83)));
		scrollPane.setBounds(47, 196, 950, 450);
		RemoveBookTab.add(scrollPane);
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
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	     	}
		});
		RemoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt( (String) table.getValueAt(table.getSelectedRow(), 0));
				try {
					if(DataBase.Delete.deleteBook(con, x)) {
						JOptionPane.showConfirmDialog(null, "BOOK REMOVED", "REMOVED",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE );
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
					}
					else {
						JOptionPane.showMessageDialog(null, "CAN'T DELETE BOOK","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		

	}
	
	
	
	
	public void AddBookTab() throws FileNotFoundException {
		
		JPanel AddBookTab = new JPanel();
		AddBookTab.setBorder(new MatteBorder(3, 3, 3, 3, new Color(255, 123, 84)));
		AddBookTab.setBounds(0, 0, 1044, 731);
		Main.add(AddBookTab);
		AddBookTab.setLayout(null);
		
		JLabel Title = new JLabel("ADD BOOK");
		Title.setBounds(0, 0, 1044, 76);
		Title.setForeground(Color.WHITE);
		Title.setOpaque(true);
		Title.setBackground(new Color(255, 123, 84));
		Title.setFont(new Font("Verdana", Font.PLAIN, 69));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setHorizontalTextPosition(SwingConstants.CENTER);
		AddBookTab.add(Title);
		
		JLabel ISBN = new JLabel("ISBN :");
		ISBN.setHorizontalTextPosition(SwingConstants.CENTER);
		ISBN.setHorizontalAlignment(SwingConstants.RIGHT);
		ISBN.setFont(new Font("Verdana", Font.PLAIN, 18));
		ISBN.setBounds(69, 125, 62, 25);
		AddBookTab.add(ISBN);
		
		JTextField ISBNField = new JTextField();
		ISBNField.setFont(new Font("Verdana", Font.PLAIN, 18));
		ISBNField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		ISBNField.setOpaque(false);
		ISBNField.setBounds(130, 125, 125, 25);
		AddBookTab.add(ISBNField);
		ISBNField.setColumns(10);
		
		JLabel BookTitle = new JLabel("TITLE :");
		BookTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		BookTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		BookTitle.setFont(new Font("Verdana", Font.PLAIN, 18));
		BookTitle.setBounds(44, 175, 87, 25);
		AddBookTab.add(BookTitle);
		
		JTextField TitleField = new JTextField();
		TitleField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		TitleField.setFont(new Font("Verdana", Font.PLAIN, 18));
		TitleField.setOpaque(false);
		TitleField.setBounds(130, 175, 165, 25);
		AddBookTab.add(TitleField);
		TitleField.setColumns(10);
		
		JLabel Author = new JLabel("AUTHOR :");
		Author.setFont(new Font("Verdana", Font.PLAIN, 18));
		Author.setHorizontalTextPosition(SwingConstants.CENTER);
		Author.setHorizontalAlignment(SwingConstants.RIGHT);
		Author.setBounds(18, 225, 113, 25);
		AddBookTab.add(Author);
		
		JTextField authorIdField = new JTextField();
		authorIdField.setFont(new Font("Verdana", Font.PLAIN, 18));
		authorIdField.setOpaque(false);
		authorIdField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		authorIdField.setBounds(130, 225, 125, 25);
		AddBookTab.add(authorIdField);
		authorIdField.setColumns(10);
		
		JLabel Genre = new JLabel("GENRE :");
		Genre.setHorizontalTextPosition(SwingConstants.CENTER);
		Genre.setHorizontalAlignment(SwingConstants.RIGHT);
		Genre.setFont(new Font("Verdana", Font.PLAIN, 18));
		Genre.setBounds(44, 275, 87, 25);
		AddBookTab.add(Genre);
		
		JComboBox<String> GenrecomboBox = new JComboBox<String>();
		GenrecomboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		GenrecomboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"ACTION", "ADEVNETURE", "CLASSIC", "MYSTERY", "FANTASY", "HORROR", "ROMANCE", "SCIENCE"}));
		GenrecomboBox.setBounds(130, 275, 125, 25);
		AddBookTab.add(GenrecomboBox);
		
		JLabel Quanitity = new JLabel("QUANITITY :");
		Quanitity.setHorizontalTextPosition(SwingConstants.CENTER);
		Quanitity.setHorizontalAlignment(SwingConstants.RIGHT);
		Quanitity.setFont(new Font("Verdana", Font.PLAIN, 18));
		Quanitity.setBounds(10, 325, 121, 25);
		AddBookTab.add(Quanitity);
		
		JSpinner spinner = new JSpinner();
		spinner.setOpaque(false);
		spinner.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		spinner.setFont(new Font("Verdana", Font.PLAIN, 18));
		spinner.setBounds(130, 325, 87, 25);
		AddBookTab.add(spinner);
		
		JLabel BookDescription = new JLabel("Description :");
		BookDescription.setHorizontalTextPosition(SwingConstants.CENTER);
		BookDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		BookDescription.setFont(new Font("Verdana", Font.PLAIN, 18));
		BookDescription.setBounds(10, 375, 121, 25);
		AddBookTab.add(BookDescription);
		
		JLabel BookCover = new JLabel("BOOK COVER :");
		BookCover.setHorizontalTextPosition(SwingConstants.CENTER);
		BookCover.setHorizontalAlignment(SwingConstants.RIGHT);
		BookCover.setFont(new Font("Verdana", Font.PLAIN, 18));
		BookCover.setBounds(600, 125, 148, 25);
		AddBookTab.add(BookCover);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminScreen.class.getResource("/Images/bookCover.png")));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 213, 107));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(600, 175, 180, 180);
		AddBookTab.add(lblNewLabel);
		
		JButton AddBookButton = new JButton("ADD BOOK");
		AddBookButton.setForeground(Color.WHITE);
		AddBookButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		AddBookButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		AddBookButton.setBackground(new Color(255, 123, 84));
		AddBookButton.setBounds(695, 508, 180, 47);
		AddBookTab.add(AddBookButton);
		
		JButton SelectPhotoButton = new JButton("SELECT PHOTO");
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
				    Image myImg = im.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
				    ImageIcon newImage = new ImageIcon(myImg);
				    lblNewLabel.setIcon(newImage);
				}
			}
		});
		SelectPhotoButton.setOpaque(false);
		SelectPhotoButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SelectPhotoButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		SelectPhotoButton.setBounds(600, 365, 180, 25);
		AddBookTab.add(SelectPhotoButton);
		
		JButton CancelButton = new JButton("CANCEL");
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.removeAll();
				try {
					AddBookTab();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				Main.revalidate();
				Main.repaint();
			}
		});
		CancelButton.setForeground(Color.WHITE);
		CancelButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		CancelButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		CancelButton.setBackground(new Color(255, 113, 113));
		CancelButton.setBounds(695, 571, 180, 47);
		AddBookTab.add(CancelButton);
		
		JTextPane Description = new JTextPane();
		Description.setFont(new Font("Verdana", Font.PLAIN, 18));
		Description.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		Description.setBounds(20, 410, 491, 292);
		AddBookTab.add(Description);
		
		JScrollPane scrollPane = new JScrollPane(Description);
		scrollPane.setBounds(20, 410, 491, 292);
		AddBookTab.add(scrollPane);
		
		AddBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = ISBNField.getText();
				String title = TitleField.getText();
				String Genre = GenrecomboBox.getSelectedItem().toString();
				String author= authorIdField.getText();
				String description = Description.getText();
				int Copies = (Integer) spinner.getValue();
				
				if(isbn.isEmpty()) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER AN ISBN","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!RegexTest.OnlyNum(isbn)) {
					JOptionPane.showMessageDialog(null, "ISBN MUST BE AN INTEGER","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				int isbni = Integer.parseInt(isbn);
				if(title.isEmpty()) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER A TITLE","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(author.isEmpty()) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER AN AUTHOR","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(description.isEmpty()) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER A DESCRIPTION","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(Copies<0) {
					JOptionPane.showMessageDialog(null, "N° OF COPIES CAN'T BE NEGATIVE","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				try {
					if(Select.bookExist(con, isbni)) {
						JOptionPane.showMessageDialog(null, "BOOK EXIST ALREADY","ERROR",JOptionPane.ERROR_MESSAGE);
						return;
					}
					else {
						
						FileInputStream input = new FileInputStream(f);
						if(Insert.addBook(con, isbni, title, author, Genre, description, Copies,input)) {
						JOptionPane.showConfirmDialog(null, "BOOK ADDED", "ADDED",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE );
						}
						else {
							JOptionPane.showMessageDialog(null, "CAN'T ADD BOOK","ERROR",JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				} catch (HeadlessException | SQLException | FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
}
