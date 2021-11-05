package Service;

import java.util.ArrayList;
import java.util.Scanner;

import Items.Animation;
import Items.Entertainment;
import Items.Item;
import Items.Movie;
import Items.OriginalSeries;
import Items.RegularSeries;

public class MenuManager {
	public MenuManager(ArrayList<Item> itemList,Scanner scan) {
		this.itemList = itemList;
		this.scan = scan;
	}
	private ArrayList<Item> itemList;
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
		
		//User Menus
		private void startMenu()
		{
			System.out.println("시작하기");
			boolean isClicked = false;
			while(true) {
				//시작하기가 눌리면 다음 인터페이스로 이동
				if(isClicked) {
					menuState =  MenuState.MAIN;
				}
			}
		}
		
		private void mainMenu(){
			boolean done = false;
			while(done ) {				
				// GUI버튼 보여주기		
			}
		}
		
		private void loginMenu() {
			//로그인은 만들지 말지 아직 미결정
			String id = scan.next(); //GUI
			String pwd = scan.next(); //GUI
			
			for(Item item : itemList) {

			}
		}
		
		private void signUpMenu() {
			//회원가입은 만들지 말지 아직 미결정
		}
		
		
		//Admin Menus
		private void adminMenu() { //삽입 삭제 수정
			boolean done = false;
			int input = 0;
			while(!done) {
				System.out.println("****Admin mode on****");
				System.out.print("Data handling|(1)Insert (2)Delete (3)Modify (4)exit:");
				input = scan.nextInt();
				
				switch(input) {
				case 1:
					insertData();
					break;
				case 2:
					deleteData();
					break;
				case 3:
					modifyData();
					break;
				case 4:
					done = true;
					break;
				default:
					break;
				}
			}
		}
		
		private void insertData() {
			boolean done = false;
			System.out.println("****Insert mode on****");
			int input = 0;
			Item item = null;
			while(!done) {
				System.out.print("Data Insert|(1)Regular (2)Original (3)Movie (4)Animation (5)Entertainment (6)exit : ");
				input = scan.nextInt();
				switch(input) {
				case 1:
					item = new RegularSeries();
					break;
				case 2:
					item = new OriginalSeries();
					break;
				case 3:
					item = new Movie();
					break;
				case 4:
					item = new Animation();
					break;
				case 5:
					item = new Entertainment();
					break;
				case 6:
					done = true;
					break;
				default:
					break;
				}
				item.insert();
				itemList.add(item);
			}
		}	
		
		private void deleteData() {
			
		}
		
		private void modifyData() {
			boolean done = false;
			System.out.println("****Modify mode on****");
			ArrayList<Item> findItems = new ArrayList<Item>();
			
			String kwd = null;
			while (true) {
				System.out.print("Data Modify | find item (input [end] to exit): ");
				kwd = scan.next();
				if (kwd.equals("end"))
					break;
				for (Item item : itemList) {
					if (item.match(kwd)) {
						item.print(); //add Matches, print method
						findItems.add(item);
					}
				}
				if(findItems.isEmpty()) {
					System.out.println("Can't find item");	
					continue;
				}
				else {
					int input = 0;
					System.out.printf("[%d]items matched, Select one :", findItems.size());
					input = scan.nextInt();
					Item myitem = findItems.get(input);	
					myitem.modify();
				}	
			}
		}
}
