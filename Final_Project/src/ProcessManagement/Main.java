package ProcessManagement;

public class Main {
	public static void main(String[] args) {
		Managers.initManagers();
		Managers.serviceManager.run();
	}
}
