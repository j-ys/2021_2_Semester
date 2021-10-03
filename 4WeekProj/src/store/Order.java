package store;

import java.util.ArrayList;
import java.util.Scanner;

class Order {
	int orderId;
	User user;
	String date;
	int point;
	int total;
	ArrayList<Item> orderedItemList = new ArrayList<>();
	ArrayList<Integer> itemCountList = new ArrayList<>();

	Order(int id) {
		this.orderId = id;
	}

	// (4주 과제) 합계 및 포인트 처리부 추가해야 함
	void read(Scanner scan) {
		// 3 park 20201010 O F3124 3 F3223 1 0
		String userId = scan.next();
		date = scan.next();
		Item item = null;
		String code = null;

		while (true) {
			code = scan.next();
			if (code.contentEquals("0"))
				break;

			item = Store.findItem(code);
			if (item == null) {
				System.out.println("해당 코드 상품 없음: " + code);
				scan.nextInt();
				continue;
			}
			orderedItemList.add(item);
			itemCountList.add(scan.nextInt());
		}

		for (int i = 0; i < orderedItemList.size(); i++) {
			user = Store.findUser("" + userId);
			total += orderedItemList.get(i).price * itemCountList.get(i);
		}
		point = total / 1000;

		if (user == null) {
			System.out.println("사용자 아이디 없음: " + userId);
			System.exit(1);
		}
		user.addOrder(this);
		user.addPoint(point);
	}

	boolean matches(String kwd) {
		if (("" + orderId).equals(kwd))
			return true;
		if (kwd.length() > 3 && date.contentEquals(kwd))
			return true;
		if (user.id.equals(kwd))
			return true;
		for (Item it : orderedItemList)
			if (it.matches(kwd))
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

	void print() {
		print(false);
	}

	void print(boolean bDetail) { // Order
		System.out.format("[주문아이디:%2d] %s 사용자: %5s", orderId, date, user.id);
		System.out.printf(" - 주문금액:%6d (포인트: %d점)\n", total, point);
		for (int i = 0; i < orderedItemList.size(); i++) {
			System.out.printf("\t (%2d개) ", itemCountList.get(i));
			orderedItemList.get(i).print();
		}
	}
}