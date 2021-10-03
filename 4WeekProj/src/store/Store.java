package store;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
	static ArrayList<Item> items = new ArrayList<Item>();
	static ArrayList<Order> orders = new ArrayList<Order>();
	static ArrayList<User> users = new ArrayList<User>();
	static Scanner scan = new Scanner(System.in);

	public void init() {
		readAll();
	}

	public void run() {
		mainMenu();
	}

	private void readAll() {
		readItems();
		readUsers();
		readOrders();
	}

	private void readItems() {
		String id;
		while (true) {
			if ((id = scan.next()).equals("0"))
				break;
			Item item = new Item(id);
			item.read(scan);
			items.add(item);
		}
	}

	private void readUsers() {
		String id;
		while (true) {
			if ((id = scan.next()).equals("0"))
				break;
			User user = new User(id);
			user.read(scan);
			users.add(user);
		}
	}

	private void readOrders() {
		int id;
		while (true) {
			if ((id = scan.nextInt()) == 0)
				break;
			Order order = new Order(id);
			order.read(scan);
			orders.add(order);
		}
	}

	public static Item findItem(String kwd) {
		for (Item item : items) {
			if (item.matches(kwd)) {
				return item;
			}
		}
		return null;
	}

	public static User findUser(String code) {
		for (User user : users) {
			if (user.matches(code)) {
				return user;
			}
		}
		return null;
	}
	
	public static Order findOrder(String code) {
		for (Order order : orders) {
			if (order.matches(code)) {
				return order;
			}
		}
		return null;
	}

	private void mainMenu() {
		boolean running = true;
		int input;
		while (running) {
			input = inputMenu("(1)물품출력 (2)사용자출력 (3)주문출력 (4)검색 (기타) 종료 ");
			switch (input) {
			case 1:
				printItems();
				break;
			case 2:
				printUsers();
				break;
			case 3:
				printOrders();
				break;
			case 4:
				searchMenu();
				break;
			default:
				running = false;
				break;
			}
		}
	}

	private int inputMenu(String message) {
		int num;
		System.out.printf("%s", message);
		num = scan.nextInt();
		if (num >= 1 && num <= 6)
			return num;
		return 0;
	}

	private void printItems() {
		for (Item item : items) {
			item.print();
		}
	}

	private void printUsers() {
		for (Item item : items) {
			item.print();
		}
	}

	
	private void printOrders() {
		for (Order order : orders) {
			order.print();
		}
	}

	private void searchMenu() {
		boolean running = true;
		int input;
		while (running) {
			input = inputMenu("(1)물품검색 (2)사용자검색 (3)주문검색 (기타) 종료 ");
			switch (input) {
			case 1:
				searchItem();
				break;
			case 2:
				searchUser();
				break;
			case 3:
				searchOrder();
				break;
			default:
				running = false;
				break;
			}
		}
	}

	private String inputKWD() {
		System.out.printf("검색 키워드: ");
		return scan.next();
	}

	private void searchItem() {
		String kwd = inputKWD();
		for (Item item : items) {
			if (item.matches(kwd))
				item.print();
		}
	}

	private void searchOrder() {
		String kwd = inputKWD();
		for (Order order : orders) {
			if (order.matches(kwd))
				order.print();
		}
	}

	private void searchUser() {
		String kwd = inputKWD();
		for (User user : users) {
			if (user.matches(kwd))
				user.print();
		}
	}

	public static void main(String[] args) {
		Store store = new Store();
		store.init();
		store.run();
	}
}
