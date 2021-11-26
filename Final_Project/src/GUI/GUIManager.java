package GUI;

import java.awt.EventQueue;

public class GUIManager {
	private LoginFrame loginFrame;
	private MainGUI mainGUI;

	public GUIManager() {

	}

	public void init() {

	}

	public void runMenu(String menuName) {
		if (menuName.equals("login")) {
			loginFrame = new LoginFrame();
		} 
		else if (menuName.equals("main")) {
			mainGUI = new MainGUI();
		}
	}
}
