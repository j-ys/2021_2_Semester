package ProcessManagement;

import FileSystem.FileManager;
import Service.ServiceManager;
import Service.MenuManager;

//Global singleton managers
public class Managers {
	public static ServiceManager serviceManager = new ServiceManager(); 
	public static FileManager fileManager = new FileManager();	
	public static MenuManager menuManger = new MenuManager();
	
	public static void initManagers(){
		Managers.serviceManager.init();
	}
}
