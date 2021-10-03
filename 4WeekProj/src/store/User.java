package store;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	String id;
	String pwd;
	int point;
	ArrayList<Order> myOrderList = new ArrayList<>();

	User(String id) {
		this.id = id;
	}

	public void read(Scanner scan) { // Student
		pwd = scan.next();
		point = scan.nextInt(); // 1%
	}

	void addOrder(Order od) {
		myOrderList.add(od);
	}

	public void addPoint(int plus) {
		point += plus;
	}

	public boolean matches(String kwd) {
		if (id.equals(kwd)) {
			return true;
		}

		Order od = Store.findOrder(kwd);
		if (od != null && od.matches(id)) {
			return true;
		}

		return false;
	}

	public boolean matches(String[] kwdArr) {
		for (String kwd : kwdArr) {
			if (!matches(kwd))
				return false;
		}
		return true;
	}

	// (4주 과제) 포인트 처리부 추가해야 함
	public void print() {
		System.out.format("[%s] (%d점)\n ", id, point);
		for (Order od : myOrderList) {
			System.out.print("   ");
			od.print(false);
		}
	}
}
