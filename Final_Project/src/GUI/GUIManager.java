package GUI;

import java.awt.EventQueue;

public class GUIManager {
	private LoginFrame loginFrame;
	private MainGUI mainGUI;

	public GUIManager() {

	}

	public void init() {
		/*
		 * } EventQueue.invokeLater(new Runnable() {
		 * 
		 * public void run() { try { loginFrame = new LoginFrame(); loginFrame.init(); }
		 * catch (Exception e) { e.printStackTrace(); } }o });
		 * 
		 * EventQueue.invokeLater(new Runnable() { public void run() { try { mainGUI =
		 * new MainGUI(); mainGUI.init(); } catch (Exception e) { e.printStackTrace(); }
		 * } });
		 */
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
