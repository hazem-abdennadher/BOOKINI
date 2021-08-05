package Screens;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EtchedBorder;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;


public class HomeScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen frame = new HomeScreen();
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
	public HomeScreen() {
		setResizable(false);
		setTitle("BOOKINI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1210, 732);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 1366, 768));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane HomeScreen = new JLayeredPane();
		HomeScreen.setBounds(0, 0, 1366, 768);
		HomeScreen.setLayout(null);
		contentPane.add(HomeScreen);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0,90));
		panel.setBounds(561, -43, 645, 811);
		HomeScreen.add(panel);
		panel.setLayout(null);
		//------------------------------------------------------------------------------
		
		//-------------------------title------------------------------------------------
		JLabel Title = new JLabel("BOOKINI");
		Title.setBounds(112, 360, 421, 90);
		panel.add(Title);
		HomeScreen.setLayer(Title, 1);
		Title.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.WHITE));
		Title.setForeground(new Color(255, 255, 255)); 
		Title.setFont(new Font("MV Boli", Title.getFont().getStyle() | Font.BOLD, Title.getFont().getSize() + 70));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		//------------------------------------------------------------------------------
		//--------------------------------Button bech ysakir app------------------------
		JButton Exit = new JButton("EXIT");
		Exit.setBounds(346, 493, 160, 40);
		panel.add(Exit);
		HomeScreen.setLayer(Exit, 1);
		
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				//a9wa faza xD
			}
		});
		Exit.setForeground(new Color(255, 255, 255));
		Exit.setBackground(new Color(232, 69, 69));
		Exit.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Exit.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		
		//------------------------------------------------------------------------------
		
		//--------------------------button bech tod5il li sign in screen ---------------
		JButton Access = new JButton("ACCESS LIBRARY");
		Access.setBounds(149, 493, 160, 40);
		panel.add(Access);
		Access.setForeground(new Color(255, 255, 255));
		Access.setFont(new Font("Verdana", Font.PLAIN, 16));
		Access.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Access.setBackground(new Color(61, 132, 184));
		HomeScreen.setLayer(Access, 1);
		Access.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					SignInScreen signInScreen = new SignInScreen();
					signInScreen.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		

		//---------------------------adding background ---------------------------------
		JLabel Background = new JLabel();
		Background.setBounds(new Rectangle(0, 0, 1206, 703));
		HomeScreen.add(Background);
		HomeScreen.setLayer(Background, 0);
		ImageIcon image = new ImageIcon(HomeScreen.class.getResource("/Images/BackgroundPro.png"));
	    Image im = image.getImage(); 
	    Image myImg = im.getScaledInstance(Background.getWidth(), Background.getHeight(),Image.SCALE_SMOOTH);
	    ImageIcon newImage = new ImageIcon(myImg);
	    Background.setIcon(newImage);
		//------------------------------------------------------------------------------
	}
}
