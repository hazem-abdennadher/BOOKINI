package  Screens;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;


import DataBase.DBConnection;
import DataBase.Select;
import javax.swing.border.MatteBorder;

import java.awt.ComponentOrientation;

public class SignInScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private java.sql.Connection con = DBConnection.getConnection();
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					SignInScreen frame = new SignInScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignInScreen()  throws SQLException {
		setResizable(false);
		setTitle("BOOKINI");
		setBounds(new Rectangle(540, 100, 480, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 720, 480));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new MatteBorder(4, 4, 4, 4, new Color(167, 187, 199)));
		mainPanel.setBackground(new Color(240, 240, 240));
		mainPanel.setBounds(0, 1, 466, 681);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JTextField UserField = new JTextField();

		UserField.setBounds(128, 344, 220, 25);
		UserField.setToolTipText("USERNAME");
		UserField.setOpaque(false);
		UserField.setForeground(Color.BLACK);
		UserField.setFont(new Font("Verdana", Font.PLAIN, 14));
		UserField.setDisabledTextColor(Color.WHITE);
		UserField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		UserField.setColumns(10);
		UserField.setCaretColor(Color.BLACK);
		UserField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		UserField.setBackground(new Color(147, 149, 149));
		mainPanel.add(UserField);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(128, 412, 220, 25);
		passwordField.setToolTipText("PASSWORD");
		passwordField.setOpaque(false);
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 14));
		passwordField.setDisabledTextColor(Color.BLUE);
		passwordField.setCaretColor(Color.BLACK);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		mainPanel.add(passwordField);
		
		JLabel BOOKINI = new JLabel("BOOKINI");
		BOOKINI.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		BOOKINI.setFont(new Font("MV Boli", BOOKINI.getFont().getStyle(), BOOKINI.getFont().getSize() + 20));
		BOOKINI.setHorizontalAlignment(SwingConstants.CENTER);
		BOOKINI.setHorizontalTextPosition(SwingConstants.CENTER);
		BOOKINI.setBounds(10, 10, 150, 40);
		mainPanel.add(BOOKINI);
		
		JButton SignInButton = new JButton("SIGN IN");
		SignInButton.addMouseListener(new MouseAdapter() {
		
			@Override
	      	public void mouseEntered(MouseEvent e) {
	      		 SignInButton.setBackground(new Color(145, 199, 136));
	      	}
	      	@Override
	      	public void mouseExited(MouseEvent e) {
	      		 SignInButton.setBackground(new Color(158, 222, 115));
	      	}
	      	
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		
	      		ImageIcon userIcon = new ImageIcon("src/Images/user.png");
				ImageIcon adminIcon = new ImageIcon("src/Images/admin.png");
				
				String userName = UserField.getText();
				@SuppressWarnings("deprecation")
				String userPassword = passwordField.getText();
	      		SignInButton.setBackground(new Color(126, 202, 156));
	      		
	      		if(userName.equals("")) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER A USER NAME","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(userPassword.equals("")) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER A USER PASSWORD","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					if(Select.userExist(con, userName) 
							&& Select.matchPassword(DBConnection.getConnection(), userName, userPassword) && userName.equalsIgnoreCase("admin")  ) {
						if(JOptionPane.showConfirmDialog(null, "GREETING ADMIN", "SUDO ADMIN",
						        JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE , adminIcon) == 0) {
							dispose();
							AdminScreen adlinScreen  = new AdminScreen();
							adlinScreen.setVisible(true);;
						}
					}
					else if(Select.userExist(con, userName) 
							&& Select.matchPassword(con, userName, userPassword) ) {
						if(JOptionPane.showConfirmDialog(null, "WElCOME " + userName.toUpperCase() , "GREETING USER",
						        JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE , userIcon) == 0) {
							dispose();
							UserScreen userScreen  = new UserScreen(userName);
							userScreen.setVisible(true);
						}
					}
					else if(!Select.userExist(con, userName)) {
						JOptionPane.showMessageDialog(null, "USER DOESN'T EXIST","ERROR",JOptionPane.ERROR_MESSAGE);
					}
					else if(Select.userExist(con, userName)
							&& !Select.matchPassword(DBConnection.getConnection(), userName, userPassword)){
						JOptionPane.showMessageDialog(null, "WRONG PASSWORD","ERROR",JOptionPane.ERROR_MESSAGE);
					}
					
					
				} catch ( SQLException | FileNotFoundException e1) {
					e1.printStackTrace();
				}
	      	}
	      });
		
		
		JButton SignUpButton = new JButton("SIGN UP");

		
		SignUpButton.setBounds(188, 482, 90, 25);
		SignUpButton.setForeground(Color.WHITE);
		SignUpButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		SignUpButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SignUpButton.setBackground(new Color(239, 79, 79));
		mainPanel.add(SignUpButton);
		//new Color(30, 174, 152)
		JLabel UserNameLabel = new JLabel("USERNAME :");
		UserNameLabel.setForeground(Color.BLACK);
		UserNameLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		UserNameLabel.setBounds(127, 321, 91, 13);
		mainPanel.add(UserNameLabel);
		
		JLabel PasswordLabel = new JLabel("PASSWORD :");
		PasswordLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		PasswordLabel.setBounds(128, 389, 102, 13);
		mainPanel.add(PasswordLabel);
		
		JLabel SignInIcon = new JLabel("");
		
		SignInIcon.setIcon(new ImageIcon(SignInScreen.class.getResource("/Images/bookCover.png")));
		SignInIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		SignInIcon.setHorizontalAlignment(SwingConstants.CENTER);
		SignInIcon.setBounds(174, 151, 128, 128);
		mainPanel.add(SignInIcon);
		
		
		
		SignInButton.setForeground(Color.WHITE);
		SignInButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		SignInButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SignInButton.setBackground(new Color(158, 222, 115));
		SignInButton.setBounds(188, 447, 90, 25);
		mainPanel.add(SignInButton);
		
		
		
		
		 SignUpButton.addMouseListener(new MouseAdapter() {
		      	@Override
		      	public void mouseEntered(MouseEvent e) {
		      		 SignUpButton.setBackground(new Color(236, 70, 70));
		      	}
		      	@Override
		      	public void mouseExited(MouseEvent e) {
		      		 SignUpButton.setBackground(new Color(239, 79, 79));
		      	}
		
		      	@Override
		      	public void mouseClicked(MouseEvent e) {
		      		SignUpButton.setBackground(new Color(240, 84, 84));
		      		dispose();
					SignUpScreen signUpScreen;
					try {
						signUpScreen = new SignUpScreen();
						signUpScreen.setVisible(true);
					} catch (SQLException e1) {
					
						e1.printStackTrace();
					}
					
		      		
		      	}
		      });
		
	}
}
