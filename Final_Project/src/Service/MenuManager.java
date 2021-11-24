package Service;

import java.util.ArrayList;
import java.util.Scanner;

import GUI.GUIManager;
import Items.Animation;
import Items.Entertainment;
import Items.Item;
import Items.Movie;
import Items.OriginalSeries;
import Items.RegularSeries;
import ProcessManagement.Managers;
import ReviewManagement.Review;
import UserManagement.User;
import UserManagement.UserManager;

public class MenuManager {
	public MenuManager() {

	}

	private Scanner scan;
	private User nowUser;
	private UserManager userManager;
	private GUIManager guiManager;

	public void init(Scanner scan) {
		this.scan = scan;
		nowUser = new User();
		userManager = new UserManager(scan);
		guiManager = new GUIManager();
		guiManager.init();
	}

	// menu system
	private enum MenuState {
		NONE, MAIN, LOGIN, ADMIN, END
	}

	private MenuState menuState = MenuState.NONE;// plz modify to NONE

	public void changeMenuState(String nextMenu) {
		menuState = MenuState.valueOf(nextMenu);
	}

	public void menuRun() {
		System.out.println("Menu Run start");
		menuState = MenuState.LOGIN;
		loginMenu();
		if (menuState == MenuState.MAIN) {
			mainMenu();
		} else if (menuState == MenuState.ADMIN) {
			adminMenu();
		}

		menuState = MenuState.END;

	}

	// User Menus
	private void mainMenu() {
		guiManager.runMenu("main");
	}

	private void reviewMenu() {
		String id = nowUser.userId;
		id = "kkk";
		int exist = 0;
		String name = "오징어게임";
		for (Review rev : Managers.managedList.reviewList) {
			if (rev.match(id, name)) {
				exist = 1;
			}
		}
		if (exist == 1) {
			System.out.println("이미 리뷰를 남기셨습니다.");
		} else if (exist == 0) {
			System.out.print("평점: ");
			float grade = scan.nextFloat();
			System.out.print("간단한 리뷰를 써주세요.: ");
			String review = scan.nextLine();
			Review newReview = new Review();
			newReview.userId = id;
			newReview.name = name;
			newReview.grade = grade;
			newReview.content = review;
			Managers.managedList.reviewList.add(newReview);
		}
	}

	private void loginMenu() {
		guiManager.runMenu("login");
		// nowUser = userManager.login();
	}

	// Admin Menus
	public void adminMenu() { // 삽입 삭제 수정
		boolean done = false;
		int input = 0;
		System.out.println("****Admin mode on****");
		while (!done) {
			System.out.println("****Admin loop on****");
			System.out.print("Data handling|(1)Insert (2)Delete (3)Modify (4)Print (5)exit :");
			input = scan.nextInt();
			switch (input) {
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
				break;
			case 5:
				done = true;
				break;
			default:
				break;
			}
		}
		System.out.println("****Admin mode off****");
	}

	private void insertData() {
		boolean done = false;
		System.out.println("****Insert mode on****");
		int input = 0;
		Item item = null;
		while (!done) {
			System.out.print("Data Insert|(1)Regular (2)Original (3)Movie (4)Animation (5)Entertainment (6)exit : ");
			input = scan.nextInt();
			switch (input) {
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
			Managers.managedList.itemList.add(item);
		}
		System.out.println("****Insert mode off****");
	}

	private void printData() {
		for (Item item : Managers.managedList.itemList) {
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
			for (Item item : Managers.managedList.itemList) {
				if (item.match(kwd)) {
					item.print();
					findItems.add(item);
				}
			}
			if (findItems.isEmpty()) {
				System.out.println("Can't find item");
				continue;
			} else {
				int input = 0;
				System.out.printf("[%d]items matched, Select one :", findItems.size());
				input = scan.nextInt();
				Managers.managedList.itemList.remove(findItems.get(input - 1));
				System.out.println("Delete done");
			}
		}
		System.out.println("****Delete mode off****");
	}

	private void modifyData() {
		boolean done = false;
		System.out.println("****Modify mode on****");
		ArrayList<Item> findItems = new ArrayList<Item>();

		String kwd = null;
		int cnt = 1;
		while (true) {
			System.out.print("Data Modify | find item (input [end] to exit): ");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			for (Item item : Managers.managedList.itemList) {
				if (item.match(kwd)) {
					System.out.printf("(%d) : ", cnt++);
					item.print(); // add Matches, print method
					findItems.add(item);
				}
			}
			if (findItems.isEmpty()) {
				System.out.println("Can't find item");
				continue;
			} else {
				int input = 0;
				System.out.printf("[%d]items matched, Select one :", findItems.size());
				input = scan.nextInt();
				Item myitem = findItems.get(input - 1);
				myitem.modify(scan);
				System.out.println("Modify done");
			}
		}
		System.out.println("****Modify mode off****");
	}
}
