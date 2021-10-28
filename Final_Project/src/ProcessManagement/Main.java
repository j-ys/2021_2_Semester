package ProcessManagement;

public class Main {
	public static void main(String[] args) {
		ProcessFlowManager processFlowManager = new ProcessFlowManager();
		processFlowManager.init();
		processFlowManager.run();
		processFlowManager.clean();
	}
}
