package Service;

import java.util.ArrayList;
import java.util.Scanner;

import Items.Animation;
import Items.Entertainment;
import Items.Item;
import Items.Movie;
import Items.OriginalSeries;
import Items.RegularSeries;
import ReviewManagement.Review;
import UserManagement.User;
import UserManagement.UserManager;

public class MenuManager {
	public MenuManager(ArrayList<Item> itemList, ArrayList<User> userList, ArrayList<Review> reviewList, Scanner scan) {
		this.itemList = itemList;
		this.userList = userList;
		this.reviewList = reviewList;
		this.scan = scan;
	}
	private ArrayList<Item> itemList;
	private ArrayList<User> userList;
	private ArrayList<Review> reviewList;
	private Scanner scan;
	private User nowUser = new User();
	private UserManager log = new UserManager(userList, scan);
	
	//menu system
		private enum MenuState{
			NONE, START, MAIN, LOGIN, SIGN_UP, ADMIN, REVIEW
		}
		private MenuState menuState = MenuState.ADMIN;//plz modify to NONE
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
		
		private void reviewMenu()
		{
			String id = nowUser.userId;
			id = "kkk";
			int exist = 0;
			String name = "오징어게임";
			for (Review rev : reviewList) {
				if (rev.match(id, name)) {
					exist = 1;
				}
			}
			if(exist == 1) {
		    	System.out.println("이미 리뷰를 남기셨습니다.");
			}
			else if(exist == 0) {
				System.out.print("평점: ");
				float grade = scan.nextFloat();
				System.out.print("간단한 리뷰를 써주세요.: ");
				String review = scan.nextLine();
				Review newReview = new Review();
				newReview.userId = id;
				newReview.name = name;
				newReview.grade = grade;
				newReview.content = review;
		        reviewList.add(newReview);
			}
		}
		
		
		private void loginMenu() {
			nowUser = log.login();
		}
		
		private void signUpMenu() {
			log.signUp();
		}
		
		
		//Admin Menus
		private void adminMenu() { //삽입 삭제 수정
			boolean done = false;
			int input = 0;
			while(!done) {
				System.out.println("****Admin mode on****");
				System.out.print("Data handling|(1)Insert (2)Delete (3)Modify (4)Print (5)exit :");
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
					printData();
				case 5:
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
				default:
					done = true;
					continue;
				}
				item.setData(scan);
				itemList.add(item);
			}
		}	
		
		private void printData() {
			for(Item item : itemList) {
				item.print();
			}
		}
		
		private void deleteData() {
			boolean done = false;
			System.out.println("****Delete mode on****");
			ArrayList<Item> findItems = new ArrayList<Item>();
			
			String kwd = null;
			while (true) {
				System.out.print("Data Delete | find item (input [end] to exit): ");
				kwd = scan.next();
				if (kwd.equals("end"))
					break;
				for (Item item : itemList) {
					if (item.match(kwd)) {
						item.print();
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
					itemList.remove(findItems.get(input-1));
					System.out.println("Delete done");
				}	
			}
		}
		
		private void modifyData() {
			boolean done = false;
			System.out.println("****Modify mode on****");
			ArrayList<Item> findItems = new ArrayList<Item>();
			
			String kwd = null;
			int cnt=1;
			while (true) {
				System.out.print("Data Modify | find item (input [end] to exit): ");
				kwd = scan.next();
				if (kwd.equals("end"))
					break;
				for (Item item : itemList) {
					if (item.match(kwd)) {
						System.out.printf("(%d) : ",cnt++);
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
					Item myitem = findItems.get(input-1);	
					myitem.modify(scan);
					System.out.println("Modify done");
				}	
			}
		}
}
