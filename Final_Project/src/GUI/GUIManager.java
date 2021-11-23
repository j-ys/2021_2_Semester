package GUI;

public class GUIManager {
	private LoginFrame loginFrame;
	private MainGUI mainGUI;
	
	public GUIManager() {
		
	}
	
	public void init(){
		loginFrame = new LoginFrame();
		mainGUI = new MainGUI();
		
		loginFrame.init();
		mainGUI.init();
	}
	
	public void runMenu(String menuName) {		
		if(menuName.equals("login")) {
			loginFrame.runFrame();
		}
		else if (menuName.equals("main")){
			mainGUI.runFrame();
		}
	}
}
