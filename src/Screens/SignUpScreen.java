package Screens;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.HeadlessException;



import DataBase.*;
import SendingMails.SendMails;


public class SignUpScreen extends JFrame {

	private JPanel contentPane;

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
	public SignUpScreen() {
		setResizable(false);
		setTitle("BOOKINI");
		setBounds(new Rectangle(0, 0, 722, 482));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 500);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JLayeredPane SignUpPanel = new JLayeredPane();
		SignUpPanel.setBounds(0, 0, 722, 482);
		contentPane.add(SignUpPanel);
		
		//---------------------------adding background ---------------------------------
				JLabel Background = new JLabel();
				Background.setIcon(new ImageIcon(SignUpScreen.class.getResource("/Images/SignUp.png")));
				Background.setBounds(new Rectangle(0, 0, 722, 482));
				SignUpPanel.add(Background);
				SignUpPanel.setLayer(Background, 0);
				//------------------------------------------------------------------------------
				
				//-----------------------------------Title--------------------------------------
				JLabel Title = new JLabel("BOOKINI");
				SignUpPanel.setLayer(Title, 1);
				Title.setBorder(null);
				Title.setForeground(new Color(255, 255, 255));
				Title.setFont(new Font("MV Boli", Title.getFont().getStyle() | Font.BOLD, Title.getFont().getSize() + 12));
				Title.setHorizontalAlignment(SwingConstants.CENTER);
				Title.setBounds(10, 10, 106, 29);
				SignUpPanel.add(Title);
				
				JSeparator separator = new JSeparator();
				SignUpPanel.setLayer(separator, 1);
				separator.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				separator.setForeground(new Color(255, 255, 255));
				separator.setBounds(10, 10, 111, 29);
				SignUpPanel.add(separator);
				//------------------------------------------------------------------------------
				
				
				
				
				JLabel Email = new JLabel("Email :");
				SignUpPanel.setLayer(Email, 1);
				Email.setHorizontalAlignment(SwingConstants.RIGHT);
				Email.setForeground(Color.WHITE);
				Email.setFont(new Font("Verdana", Font.PLAIN, 13));
				Email.setBounds(60, 105, 101, 20);
				SignUpPanel.add(Email);
				JLabel userName = new JLabel("USER NAME :");
				userName.setHorizontalAlignment(SwingConstants.RIGHT);
				userName.setForeground(Color.WHITE);
				userName.setFont(new Font("Verdana", Font.PLAIN, 13));
				userName.setBounds(60, 140, 101, 20);
				SignUpPanel.add(userName);
				SignUpPanel.setLayer(userName, 1);
				
				JLabel Name = new JLabel("NAME :");
				SignUpPanel.setLayer(Name, 1);
				Name.setHorizontalAlignment(SwingConstants.RIGHT);
				Name.setForeground(Color.WHITE);
				Name.setFont(new Font("Verdana", Font.PLAIN, 13));
				Name.setBounds(60, 175, 101, 20);
				SignUpPanel.add(Name);

				
				
				JLabel LastName = new JLabel("LAST NAME :");
				SignUpPanel.setLayer(LastName, 1);
				LastName.setHorizontalAlignment(SwingConstants.RIGHT);
				LastName.setFont(new Font("Verdana", Font.PLAIN, 13));
				LastName.setForeground(new Color(255, 255, 255));
				LastName.setBounds(20, 210, 141, 20);
				SignUpPanel.add(LastName);
				
				JLabel Age = new JLabel("AGE :");
				SignUpPanel.setLayer(Age, 1);
				Age.setHorizontalAlignment(SwingConstants.RIGHT);
				Age.setForeground(Color.WHITE);
				Age.setFont(new Font("Verdana", Font.PLAIN, 13));
				Age.setBounds(60, 245, 101, 20);
				SignUpPanel.add(Age);
				
				JLabel Gender = new JLabel("GENDER :");
				SignUpPanel.setLayer(Gender, 1);
				Gender.setHorizontalAlignment(SwingConstants.RIGHT);
				Gender.setForeground(Color.WHITE);
				Gender.setFont(new Font("Verdana", Font.PLAIN, 13));
				Gender.setBounds(60, 280, 101, 20);
				SignUpPanel.add(Gender);
				
				JLabel UserPassword = new JLabel("PASSWORD :");
				SignUpPanel.setLayer(UserPassword, 1);
				UserPassword.setForeground(new Color(255, 255, 255));
				UserPassword.setFont(new Font("Verdana", Font.PLAIN, 13));
				UserPassword.setHorizontalAlignment(SwingConstants.RIGHT);
				UserPassword.setBounds(30, 315, 131, 20);
				SignUpPanel.add(UserPassword);
				
				JPasswordField passwordField = new JPasswordField();
				passwordField.setFont(new Font("Verdana", Font.PLAIN, 13));
				SignUpPanel.setLayer(passwordField, 1);
				passwordField.setBackground(SystemColor.inactiveCaption);
				passwordField.setBounds(171, 315, 286, 26);
				SignUpPanel.add(passwordField);
				passwordField.setColumns(20);
				
				JTextField emailField = new JTextField();
				emailField.setFont(new Font("Verdana", Font.PLAIN, 13));
				SignUpPanel.setLayer(emailField, 1);
				emailField.setColumns(20);
				emailField.setBorder(new EmptyBorder(0, 0, 0, 0));
				emailField.setBackground(SystemColor.inactiveCaption);
				emailField.setBounds(171, 105, 286, 26);
				SignUpPanel.add(emailField);
				
				JTextField LastNameField = new JTextField();
				LastNameField.setFont(new Font("Verdana", Font.PLAIN, 13));
				SignUpPanel.setLayer(LastNameField, 1);
				LastNameField.setBackground(SystemColor.inactiveCaption);
				LastNameField.setBounds(171, 210, 286, 26);
				LastNameField.setColumns(20);
				SignUpPanel.add(LastNameField);
				
				
				JTextField userNameField = new JTextField();
				userNameField.setFont(new Font("Verdana", Font.PLAIN, 13));
				SignUpPanel.setLayer(userNameField, 1);
				userNameField.setBackground(SystemColor.inactiveCaption);
				userNameField.setBorder(new EmptyBorder(0, 0, 0, 0));
				userNameField.setBounds(171, 140, 286, 26);
				userNameField.setColumns(20);
				SignUpPanel.add(userNameField);
				
				JTextField nameField = new JTextField();
				nameField.setFont(new Font("Verdana", Font.PLAIN, 13));
				SignUpPanel.setLayer(nameField, 1);
				nameField.setColumns(20);
				nameField.setBorder(new EmptyBorder(0, 0, 0, 0));
				nameField.setBackground(SystemColor.inactiveCaption);
				nameField.setBounds(171, 175, 286, 26);
				SignUpPanel.add(nameField);
				
				JTextField ageField = new JTextField();
				ageField.setFont(new Font("Verdana", Font.PLAIN, 13));
				SignUpPanel.setLayer(ageField, 1);
				ageField.setColumns(3);
				ageField.setBorder(new EmptyBorder(0, 0, 0, 0));
				ageField.setBackground(SystemColor.inactiveCaption);
				ageField.setBounds(171, 245, 286, 26);
				SignUpPanel.add(ageField);
				
				
				
				
				JLabel backButton = new JLabel("");
				SignUpPanel.setLayer(backButton, 1);
				backButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						SignInScreen signInScreen  = new SignInScreen();
						signInScreen.setVisible(true);
					}
				});
				
				
				JRadioButton MaleRadio = new JRadioButton("MALE");
				MaleRadio.setSelected(true);
				MaleRadio.setActionCommand("Male");
				MaleRadio.setBackground(SystemColor.inactiveCaption);
				MaleRadio.setFont(new Font("Verdana", Font.PLAIN, 13));
				SignUpPanel.setLayer(MaleRadio, 1);
				MaleRadio.setBounds(171, 280, 63, 26);
				SignUpPanel.add(MaleRadio);
				
				ButtonGroup genderGroup = new ButtonGroup();
				genderGroup.add(MaleRadio);
				JRadioButton FemaleRadio = new JRadioButton("FEMALE");
				genderGroup.add(FemaleRadio);
				SignUpPanel.setLayer(FemaleRadio, 1);
				FemaleRadio.setFont(new Font("Verdana", Font.PLAIN, 13));
				FemaleRadio.setBackground(SystemColor.inactiveCaption);
				FemaleRadio.setActionCommand("Female");
				FemaleRadio.setBounds(249, 280, 80, 26);
				SignUpPanel.add(FemaleRadio);
				
				
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
							if(DataBase.Insert.addUser(DBConnection.getConnection(),email,userName,name,lastName,AgeI,gender,password)) {
								SendMails.sendMail("email", "Acoount created", "DEAR "+name+" :\nYour account have been created successfully");
								JOptionPane.showConfirmDialog(null, "ACCOUNT CREATED\nCHECK YOUR EMAIL", "ADDED",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE ,addUserIcon );
								
							}
							else {
								JOptionPane.showMessageDialog(null, "USER ALREADY EXIST","ERROR",JOptionPane.ERROR_MESSAGE);
							}
						} catch (HeadlessException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
				
				
				signUp.setForeground(Color.WHITE);
				signUp.setFont(new Font("Verdana", Font.PLAIN, 13));
				signUp.setBackground(new Color(237, 46, 58));
				signUp.setBounds(261, 351, 101, 29);
				SignUpPanel.add(signUp);
				SignUpPanel.setLayer(signUp, 1);
				backButton.setIcon(new ImageIcon(SignUpScreen.class.getResource("/Images/Back.png")));
				backButton.setBounds(50, 400, 36, 35);
				SignUpPanel.add(backButton);
		
		
	}

}
