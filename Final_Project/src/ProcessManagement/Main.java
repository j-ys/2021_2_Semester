package ProcessManagement;

public class Main {
	public static void main(String[] args) {
		Managers.serviceManager.init();
		Managers.serviceManager.run();
	}
}
