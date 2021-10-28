package Service;

import java.util.ArrayList;
import java.util.Scanner;

import Patient.Patient;

public class MenuManager {
	public MenuManager(ArrayList<Patient> patientList,Scanner scan) {
		this.patientList = patientList;
		this.scan = scan;
	}
	private ArrayList<Patient> patientList;
	private Scanner scan;
	
	//menu system
		private enum MenuState{
			NONE,
			START,
			MAIN,
			LOGIN,
			SIGN_UP,
			ADMIN,
			BOOKING
		}
		private MenuState menuState = MenuState.START;
		public void menuRun(){
			boolean processRunning = true;
			//여기서 GUI Open
			while (processRunning) {
				switch (menuState) {
				case START:
					startMenu();
					break;
				case MAIN:
					mainMenu();
					break;
				case LOGIN:
					loginMenu();
					break;
				case SIGN_UP:
					signUpMenu();
					break;
				case ADMIN:
					adminMenu();
					break;
				case BOOKING:
					break;		
				}
			}
		}
		
		private void startMenu()
		{
			System.out.println("시작하기");
			boolean isCliked = false;
			while(isCliked) {
				//start 누르는 GUI 구현
				//start 눌리면 isClicked true로 바꾸기
			}
		}
		
		private void mainMenu(){
			boolean done = false;
			while(done ) {				
				// GUI버튼 보여주기
				System.out.println("로그인");			
				System.out.println("회원가입");
				System.out.println("뒤로가기");
				//if(로그인) menuState= LOGIN; done = false;
				//if(회원가입) menuState= SIGN_UP; done = false;
				//if(뒤로가기) menuState= MAIN; done = false;
			}
		}
		
		private void loginMenu() {
			String id = scan.next(); //GUI
			String pwd = scan.next(); //GUI
			
			for(Patient patient : patientList) {
				//if (id.match){ 
				//	if(pwd.match){
				//		print login ok
				//		이제 환자정보 입력 flow로 이동
				//	}
				//}
			}
		}
		
		private void signUpMenu() {
			
		}
		
		private void adminMenu() {
			
		}
		
}
