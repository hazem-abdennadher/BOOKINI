package Screens;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class HomeScreen extends JFrame {

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
		setBounds(new Rectangle(0, 0, 722, 482));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 500);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 722, 482));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane HomeScreen = new JLayeredPane();
		HomeScreen.setBounds(0, 0, 722, 482);
		HomeScreen.setLayout(null);
		contentPane.add(HomeScreen);

		//---------------------------adding background ---------------------------------
		JLabel Background = new JLabel();
		Background.setIcon(new ImageIcon(HomeScreen.class.getResource("/Images/Background.png")));
		Background.setBounds(new Rectangle(0, 0, 722, 472));
		HomeScreen.add(Background);
		HomeScreen.setLayer(Background, 0);
		//------------------------------------------------------------------------------
		
		//-------------------------title------------------------------------------------
		JLabel Title = new JLabel("BOOKINI");
		HomeScreen.setLayer(Title, 1);
		Title.setBorder(null);
		Title.setForeground(new Color(255, 255, 255)); 
		Title.setFont(new Font("MV Boli", Title.getFont().getStyle() | Font.BOLD, Title.getFont().getSize() + 44));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(210, 240, 281, 66);	
		HomeScreen.add(Title);
		JSeparator separator = new JSeparator();
		HomeScreen.setLayer(separator, 1);
		separator.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(221, 240, 270, 66);
		HomeScreen.add(separator);
		
		//------------------------------------------------------------------------------
		
		//--------------------------button bech tod5il li sign in screen ---------------
		JButton Access = new JButton("ACCESS LIBRARY");
		HomeScreen.setLayer(Access, 1);
	   Access.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignInScreen signInScreen  = new SignInScreen();
				signInScreen.setVisible(true);
				
			}
		});
		
		Access.setForeground(new Color(255, 255, 255));
		Access.setFont(new Font("Verdana", Font.PLAIN, 12));
		Access.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Access.setBackground(new Color(61, 132, 184));
		Access.setBounds(221, 358, 117, 29);
		HomeScreen.add(Access);
		//------------------------------------------------------------------------------
		//--------------------------------Button bech ysakir app------------------------
		JButton Exit = new JButton("EXIT");
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
		Exit.setFont(new Font("Verdana", Font.PLAIN, 12));
		Exit.setBounds(374, 358, 117, 29);
		HomeScreen.add(Exit);
		//------------------------------------------------------------------------------
	}
}
