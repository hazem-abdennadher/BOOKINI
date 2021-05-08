package  Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import DataBase.DBConnection;
import DataBase.Select;

public class SignInScreen extends JFrame {

	private JPanel contentPane;

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
	public SignInScreen() {
		setResizable(false);
		setTitle("BOOKINI");
		setBounds(new Rectangle(0, 0, 722, 482));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 500);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JLayeredPane SignInPanel = new JLayeredPane();
		SignInPanel.setBounds(0, 0, 722, 482);
		contentPane.add(SignInPanel);
		
		//---------------------------adding background ---------------------------------
				JLabel Background = new JLabel();
				Background.setIcon(new ImageIcon(SignInScreen.class.getResource("/Images/SignIn.png")));
				Background.setBounds(new Rectangle(0, 0, 722, 482));
				SignInPanel.add(Background);
				SignInPanel.setLayer(Background, 0);
				//------------------------------------------------------------------------------
				//-------------------------title------------------------------------------------
				JLabel Title = new JLabel("BOOKINI");
				SignInPanel.setLayer(Title, 1);
				Title.setBorder(null);
				Title.setForeground(new Color(255, 255, 255));
				Title.setFont(new Font("MV Boli", Title.getFont().getStyle() | Font.BOLD, Title.getFont().getSize() + 12));
				Title.setHorizontalAlignment(SwingConstants.CENTER);
				Title.setBounds(10, 10, 106, 29);
				SignInPanel.add(Title);
				
				JSeparator separator = new JSeparator();
				SignInPanel.setLayer(separator, 1);
				separator.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				separator.setForeground(new Color(255, 255, 255));
				separator.setBounds(10, 10, 111, 29);
				SignInPanel.add(separator);
				
				
				JLabel userLabel = new JLabel("USER :");
				SignInPanel.setLayer(userLabel, 1);
				userLabel.setBounds(91, 283, 48, 20);
				userLabel.setForeground(Color.WHITE);
				userLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
				SignInPanel.add(userLabel);
				//------------------------------------------------------------------------------
				
				JPasswordField passwordField = new JPasswordField();
				SignInPanel.setLayer(passwordField, 1);
				passwordField.setBackground(new Color(167, 197, 235));
				passwordField.setBorder(null);
				passwordField.setBounds(219, 310, 286, 26);
				passwordField.setFont(new Font("Verdana", Font.PLAIN, 13));
				passwordField.setColumns(20);
				SignInPanel.add(passwordField);
				
				JLabel passWord = new JLabel("PASSWORD :");
				SignInPanel.setLayer(passWord, 1);
				passWord.setBounds(46, 313, 93, 20);
				passWord.setForeground(Color.WHITE);
				passWord.setFont(new Font("Verdana", Font.PLAIN, 13));
				passWord.setBackground(Color.WHITE);
				SignInPanel.add(passWord);
				
				JTextField textField = new JTextField();
				SignInPanel.setLayer(textField, 1);
				textField.setActionCommand("");
				textField.setToolTipText("");
				textField.setCaretColor(SystemColor.activeCaptionText);
				textField.setBackground(new Color(167, 197, 235));
				textField.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				textField.setBounds(219, 280, 286, 26);
				textField.setFont(new Font("Verdana", Font.PLAIN, 13));
				textField.setColumns(20);
				SignInPanel.add(textField);
				JButton signIn = new JButton("SIGN IN");
				SignInPanel.setLayer(signIn, 1);
				signIn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				signIn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ImageIcon userIcon = new ImageIcon("src/Images/user.png");
						ImageIcon adminIcon = new ImageIcon("src/Images/admin.png");
						String userName = textField.getText();
						String userPassword = passwordField.getText();
						if(userName.equals("")) {
							JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER A USER NAME","ERROR",JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(userPassword.equals("")) {
							JOptionPane.showMessageDialog(null, "YOU NEED TO ENTER A USER PASSWORD","ERROR",JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						try {
							if(Select.userExist(DBConnection.getConnection(), userName) 
									&& Select.matchPassword(DBConnection.getConnection(), userName, userPassword) && userName.equalsIgnoreCase("admin")  ) {
								if(JOptionPane.showConfirmDialog(null, "GREETING ADMIN", "SUDO ADMIN",
								        JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE , adminIcon) == 0) {
									SignInPanel.show(false);
								}
							}
							else if(Select.userExist(DBConnection.getConnection(), userName) 
									&& Select.matchPassword(DBConnection.getConnection(), userName, userPassword) ) {
								if(JOptionPane.showConfirmDialog(null, "WElCOME " + userName.toUpperCase() , "GREETING USER",
								        JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE , userIcon) == 0) {
									SignInPanel.show(false);
								}
							}
							else if(!Select.userExist(DBConnection.getConnection(), userName)) {
								JOptionPane.showMessageDialog(null, "USER DOESN'T EXIST","ERROR",JOptionPane.ERROR_MESSAGE);
							}
							else if(Select.userExist(DBConnection.getConnection(), userName)
									&& !Select.matchPassword(DBConnection.getConnection(), userName, userPassword)){
								JOptionPane.showMessageDialog(null, "WRONG PASSWORD","ERROR",JOptionPane.ERROR_MESSAGE);
							}
							
							
						} catch (HeadlessException | SQLException e1) {
							e1.printStackTrace();
						}
						
					}
		});
				signIn.setBounds(515, 292, 101, 29);
				signIn.setForeground(Color.WHITE);
				signIn.setFont(new Font("Verdana", Font.PLAIN, 13));
				signIn.setBackground(new Color(62, 180, 73));
				SignInPanel.add(signIn);
				
				JButton signUp = new JButton("SIGN UP");
				SignInPanel.setLayer(signUp, 1);
				signUp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				signUp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						SignUpScreen signUpScreen  = new SignUpScreen();
						signUpScreen.setVisible(true);
					}
				});
				signUp.setBounds(313, 346, 101, 29);
				signUp.setForeground(Color.WHITE);
				signUp.setFont(new Font("Verdana", Font.PLAIN, 13));
				signUp.setBackground(new Color(237, 46, 58));
				SignInPanel.add(signUp);
				
				
				

				JLabel backButton = new JLabel("");
				SignInPanel.setLayer(backButton, 1);
				backButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						HomeScreen homeScreen  = new HomeScreen();
						homeScreen.setVisible(true);
						
					}
				});
				backButton.setIcon(new ImageIcon(SignInScreen.class.getResource("/Images/Back.png")));
				backButton.setBounds(50, 400, 36, 35);
				SignInPanel.add(backButton);
		
	}

}
