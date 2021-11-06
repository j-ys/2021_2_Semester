package Service;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import ProcessManagement.Managers;
import Items.Item;

public class ServiceManager {
	private ArrayList<Item> itemList= new ArrayList<Item>();
	private Scanner scan = new Scanner(System.in);
	private MenuManager menuManger;

	public void init() {
		readUsers();
		menuManger = new MenuManager(itemList, scan);
	}
	
	private void readUsers() {
		Scanner file = Managers.fileManager.openFile("Users.txt");
		while(true){
			//******Please Implements******
			//switch - case
			//Item i = new Item();
			//itemList.add(i);
			//*****************************
			
		}
	}
	
	public void run() {
		menuManger.menuRun();
	}
	
}


















