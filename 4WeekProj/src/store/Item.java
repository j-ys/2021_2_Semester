package store;

import java.util.Scanner;

public class Item {
	String id;
	String name;
	int price;

	Item(String id2) {
		id = id2;
	}

	void read(Scanner scan) {
		name = scan.next();
		StringBuilder buil = new StringBuilder(name);
		for (int i = name.getBytes().length; i < 20; i++)
			buil.append(' ');
		name = buil.toString();
		price = scan.nextInt();
	}

	void print() {
		System.out.printf("[%s] %s\t", id, name);
		System.out.printf("%5d원\n", price);
	}

	boolean matches(String kwd) {
		if (name.contains(kwd))
			return true;
		if (kwd.length() > 2 && id.contains(kwd))
			return true;
		return false;
	}

	boolean matches(String[] kwdArr) {
		for (String kwd : kwdArr) {
			if (!matches(kwd))
				return false;
		}
		return true;
	}
}
