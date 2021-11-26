package ProcessManagement;

import FileSystem.FileManager;
import Service.ServiceManager;
import UserManagement.UserManager;
import Service.ManagedList;
import Service.MenuManager;

//Global singleton managers
public class Managers {
	public static ServiceManager serviceManager = new ServiceManager(); 
	public static FileManager fileManager = new FileManager();	
	public static MenuManager menuManger = new MenuManager();
	public static ManagedList managedList = new ManagedList();
	public static UserManager userManager = new UserManager();
}
