package ProcessManagement;

import FileSystem.FileManager;
import Service.ServiceManager;

//Global singleton managers
public class Managers {
	public static ServiceManager serviceManager = new ServiceManager(); 
	public static FileManager fileManager = new FileManager();	
}
