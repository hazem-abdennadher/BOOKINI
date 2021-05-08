package Screens;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UserScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserScreen frame = new UserScreen();
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
	public UserScreen() {
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
		
		JLayeredPane UserScreen = new JLayeredPane();
		UserScreen.setBounds(0, 0, 722, 482);
		UserScreen.setLayout(null);
		contentPane.add(HomeScreen);
	}

}
