package ProcessManagement;

enum ProcessState{
	None,
	Initial,
	Run,
	End
}

public class ProcessFlowManager {
	ProcessState processState = ProcessState.None;
	
	public void init() {
		processState = ProcessState.Initial;
		Managers.serviceManager.init();
	}

	public void run(){
		processState = ProcessState.Run;
		Managers.serviceManager.run();
	}
	
	public void clean() {
		processState = ProcessState.End;
	}
}
