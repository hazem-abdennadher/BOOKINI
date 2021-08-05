package Screens;
import java.awt.EventQueue;
public class Home {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					@SuppressWarnings("unused")
					Home window = new Home();
				} catch (Exception e) { 
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HomeScreen homeScreen  = new HomeScreen();
		homeScreen.setVisible(true);	
	}

}
