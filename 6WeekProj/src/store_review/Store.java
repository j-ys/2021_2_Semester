package store_review;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
	static Scanner scan = new Scanner(System.in);
	static Manager itemMGR = new Manager();
	static Manager userMGR = new Manager();
	static Manager orderMGR = new Manager();

	void run() {
		readAllFile();
		menu();
	}

	void menu() {
		int num;
		while (true) {
			System.out.print("(1)물품출력 (2)사용자출력 (3)주문출력 (4)검색 (5)정보수정 (6)탈퇴 (기타) 종료 ");
			num = scan.nextInt();
			if (num < 1 || num > 6)
				break;
			switch (num) {
			case 1:
				itemMGR.printAll();
				break;
			case 2:
				userMGR.printAll();
				break;
			case 3:
				orderMGR.printAll();
				break;
			case 4:
				searchMenu();
				break;
			default:
				break;
			}
		}
	}

	void searchMenu() {
		int num;
		while (true) {
			System.out.print("(1)물품검색 (2)사용자검색 (3)주문검색 (기타) 종료 ");
			num = scan.nextInt();
			if (num < 1 || num > 3)
				break;
			switch (num) {
			case 1:
				itemMGR.searchAll();
				break;
			case 2:
				userMGR.searchAll();
				break;
			case 3:
				orderMGR.searchAll();
				break;
			default:
				break;
			}
		}
	}

	void readAllFile() {
		itemMGR.readAll("items.txt", new Factory() {
			public Item create() {
				return new Item();
			}
		});
		userMGR.readAll("users.txt", new Factory() {
			public User create() {
				return new User();
			}
		});
		orderMGR.readAll("orders.txt", new Factory() {
			public Order create() {
				return new Order();
			}
		});
	}

	public static void main(String[] args) {
		Store m = new Store();
		m.run();
	}
}
