package Screens;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.HeadlessException;


import DataBase.*;
import javax.swing.border.MatteBorder;

public class SignUpScreen extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private java.sql.Connection con =  DBConnection.getConnection();
	File f = new File(AdminScreen.class.getResource("/Images/bookCover.png").getFile());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {  
					SignUpScreen frame = new SignUpScreen();
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
	public SignUpScreen() throws SQLException {
		setResizable(false);
		setTitle("BOOKINI");
		setBounds(new Rectangle(340, 100, 880, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 720, 480));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new MatteBorder(4, 4, 4, 4, new Color(167, 187, 199)));
		mainPanel.setBackground(new Color(240, 240, 240));
		mainPanel.setBounds(0, 0, 866, 681);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel BOOKINI = new JLabel("BOOKINI");
		BOOKINI.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		BOOKINI.setFont(new Font("MV Boli", BOOKINI.getFont().getStyle(), BOOKINI.getFont().getSize() + 20));
		BOOKINI.setHorizontalAlignment(SwingConstants.CENTER);
		BOOKINI.setHorizontalTextPosition(SwingConstants.CENTER);
		BOOKINI.setBounds(10, 10, 150, 40);
		mainPanel.add(BOOKINI);
		
		
		JLabel Email = new JLabel("Email :");
		
		Email.setHorizontalAlignment(SwingConstants.LEFT);
		Email.setForeground(Color.BLACK);
		Email.setFont(new Font("Verdana", Font.PLAIN, 14));
		Email.setBounds(50, 72, 101, 20);
		mainPanel.add(Email);
		JLabel userName = new JLabel("USER NAME :");
		userName.setHorizontalAlignment(SwingConstants.LEFT);
		userName.setForeground(Color.BLACK);
		userName.setFont(new Font("Verdana", Font.PLAIN, 14));
		userName.setBounds(50, 137, 101, 20);
		mainPanel.add(userName);
		
		
		JLabel Name = new JLabel("NAME :");
		
		Name.setHorizontalAlignment(SwingConstants.LEFT);
		Name.setForeground(Color.BLACK);
		Name.setFont(new Font("Verdana", Font.PLAIN, 14));
		Name.setBounds(50, 202, 101, 20);
		mainPanel.add(Name);

		
		
		JLabel LastName = new JLabel("LAST NAME :");
		
		LastName.setHorizontalAlignment(SwingConstants.LEFT);
		LastName.setFont(new Font("Verdana", Font.PLAIN, 14));
		LastName.setForeground(Color.BLACK);
		LastName.setBounds(50, 267, 141, 20);
		mainPanel.add(LastName);
		
		JLabel Age = new JLabel("AGE :");
		Age.setHorizontalAlignment(SwingConstants.LEFT);
		Age.setForeground(Color.BLACK);
		Age.setFont(new Font("Verdana", Font.PLAIN, 14));
		Age.setBounds(50, 332, 101, 20);
		mainPanel.add(Age);
		
		JLabel Gender = new JLabel("GENDER :");
		Gender.setHorizontalAlignment(SwingConstants.LEFT);
		Gender.setForeground(Color.BLACK);
		Gender.setFont(new Font("Verdana", Font.PLAIN, 14));
		Gender.setBounds(50, 387, 101, 20);
		mainPanel.add(Gender);
		
		JLabel UserPassword = new JLabel("PASSWORD :");
		
		UserPassword.setForeground(Color.BLACK);
		UserPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		UserPassword.setHorizontalAlignment(SwingConstants.LEFT);
		UserPassword.setBounds(50, 439, 131, 20);
		mainPanel.add(UserPassword);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		passwordField.setOpaque(false);
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 14));
		passwordField.setBackground(SystemColor.inactiveCaption);
		passwordField.setBounds(50, 469, 286, 25);
		mainPanel.add(passwordField);
		passwordField.setColumns(20);
		
		JTextField emailField = new JTextField();
		emailField.setForeground(Color.BLACK);
		emailField.setOpaque(false);
		emailField.setFont(new Font("Verdana", Font.PLAIN, 14));

		emailField.setColumns(20);
		emailField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		emailField.setBackground(SystemColor.inactiveCaption);
		emailField.setBounds(50, 102, 286, 25);
		mainPanel.add(emailField);
		
		JTextField LastNameField = new JTextField();
		LastNameField.setForeground(Color.BLACK);
		LastNameField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		LastNameField.setOpaque(false);
		LastNameField.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		LastNameField.setBackground(SystemColor.inactiveCaption);
		LastNameField.setBounds(50, 297, 286, 25);
		LastNameField.setColumns(20);
		mainPanel.add(LastNameField);
		
		
		JTextField userNameField = new JTextField();
		userNameField.setForeground(Color.BLACK);
		userNameField.setOpaque(false);
		userNameField.setFont(new Font("Verdana", Font.PLAIN, 14));
		userNameField.setBackground(SystemColor.inactiveCaption);
		userNameField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		userNameField.setBounds(50, 167, 286, 25);
		userNameField.setColumns(20);
		mainPanel.add(userNameField);
		
		JTextField nameField = new JTextField();
		nameField.setForeground(Color.BLACK);
		nameField.setOpaque(false);
		nameField.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		nameField.setColumns(20);
		nameField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		nameField.setBackground(SystemColor.inactiveCaption);
		nameField.setBounds(50, 232, 286, 25);
		mainPanel.add(nameField);
		
		JTextField ageField = new JTextField();
		ageField.setForeground(Color.BLACK);
		ageField.setOpaque(false);
		ageField.setFont(new Font("Verdana", Font.PLAIN, 14));
		ageField.setColumns(3);
		ageField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		ageField.setBackground(SystemColor.inactiveCaption);
		ageField.setBounds(50, 352, 40, 25);
		mainPanel.add(ageField);
		
		
		JRadioButton MaleRadio = new JRadioButton("MALE");
		MaleRadio.setOpaque(false);
		MaleRadio.setSelected(true);
		MaleRadio.setActionCommand("Male");
		MaleRadio.setBackground(SystemColor.inactiveCaption);
		MaleRadio.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		MaleRadio.setBounds(50, 413, 63, 20);
		mainPanel.add(MaleRadio);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(MaleRadio);
		JRadioButton FemaleRadio = new JRadioButton("FEMALE");
		FemaleRadio.setOpaque(false);
		genderGroup.add(FemaleRadio);
		FemaleRadio.setFont(new Font("Verdana", Font.PLAIN, 14));
		FemaleRadio.setBackground(SystemColor.inactiveCaption);
		FemaleRadio.setActionCommand("Female");
		FemaleRadio.setBounds(128, 413, 80, 20);
		mainPanel.add(FemaleRadio);
		
		
		JButton signUp = new JButton("SIGN UP");
		signUp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon addUserIcon = new ImageIcon("src/Images/addUserIcon.png");
				String email =  emailField.getText();
				String userName =  userNameField.getText();
				String name =  nameField.getText();
				String lastName =  LastNameField.getText();
				String age =  ageField.getText();
				String gender = genderGroup.getSelection().getActionCommand() ;
				@SuppressWarnings("deprecation")
				String password =  passwordField.getText();
				
				if(email.equals("")) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER AN EMAIL","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!RegexTest.TestEmail(email)) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER A VALID EMAIL","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(userName.equals("")) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER A USER NAME","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER A NAME","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(lastName.equals("")) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER A LAST NAME","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(age.equals("")) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER AN AGE","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!RegexTest.TestAge(age)) {
					JOptionPane.showMessageDialog(null, "AGE MUST BE AN INTEGER BETWEEN 0-99 ","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(genderGroup.getSelection().getActionCommand() == null) {
					JOptionPane.showMessageDialog(null, "PLEASE SELECT A GENDER ","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(password.equals("")) {
					JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER A PASSWORD","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				int AgeI= Integer.parseInt(age);
				
				try {
					
					
						if(!Select.userExist(con, userName)) {
							System.out.print(Select.userInfo(con, userName, 1));
							if(!Select.emailExist(con, email)) {
								FileInputStream input = new FileInputStream(f);
								if(DataBase.Insert.addUser(DBConnection.getConnection(),email,userName,name,lastName,AgeI,gender,password,input)) {
									
									if(JOptionPane.showConfirmDialog(null, "ACCOUNT CREATED", "ADDED",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE ,addUserIcon)==0){
										dispose();
										SignInScreen singInScreen = new SignInScreen();
										singInScreen.setVisible(true);
									}
									}
									else {
										JOptionPane.showMessageDialog(null, "USER ALREADY EXIST","ERROR",JOptionPane.ERROR_MESSAGE);
								 	}
							}
							else {
								JOptionPane.showMessageDialog(null, "EMAIL ALREADY EXIST","ERROR",JOptionPane.ERROR_MESSAGE);
							}
							
						}
						else {
							JOptionPane.showMessageDialog(null, "USER ALREADY EXIST","ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch (HeadlessException | SQLException | FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		signUp.setForeground(Color.WHITE);
		signUp.setFont(new Font("Verdana", Font.PLAIN, 13));
		signUp.setBackground(new Color(158, 222, 115));
		signUp.setBounds(128, 504, 101, 30);
		mainPanel.add(signUp);
	    
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(432, 102, 2, 392);
		mainPanel.add(separator);
		
		
		
		
	    
	    JLabel Img = new JLabel("");
	    Img.setIcon(new ImageIcon(SignUpScreen.class.getResource("/Images/contract.png")));
	    Img.setHorizontalTextPosition(SwingConstants.CENTER);
	    Img.setHorizontalAlignment(SwingConstants.CENTER);
	    Img.setBounds(442, 102, 414, 392);
	    mainPanel.add(Img);
	    
	    JButton Cancel = new JButton("CANCEL");
	    Cancel.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dispose();
				SignInScreen singInScreen;
				try {
					singInScreen = new SignInScreen();
					singInScreen.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	    	}
	    });
	    Cancel.setForeground(Color.WHITE);
	    Cancel.setFont(new Font("Verdana", Font.PLAIN, 13));
	    Cancel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    Cancel.setBackground(new Color(237, 46, 58));
	    Cancel.setBounds(128, 544, 101, 30);
	    mainPanel.add(Cancel);
	    
	    
	    
	    
	}
}
