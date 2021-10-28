package Service;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import ProcessManagement.Managers;
import Patient.Patient;

public class ServiceManager {
	private ArrayList<Patient> patientList= new ArrayList<Patient>();
	private Scanner scan = new Scanner(System.in);
	private MenuManager menuManger;

	public void init() {
		readUsers();
		menuManger = new MenuManager(patientList, scan);
	}
	
	private void readUsers() {
		Scanner file = Managers.fileManager.openFile("Users.txt");
		while(true){
			//******Please Implements******
			Patient p = new Patient();
			patientList.add(p);
			//*****************************
		}
	}
	
	public void run() {
		menuManger.menuRun();
	}
	
}


















