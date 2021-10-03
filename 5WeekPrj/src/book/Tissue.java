package book;

import java.util.Scanner;

public class Tissue implements Manageable {
	String name;
	int nSheet;
	int price;

	public void read(Scanner scan) {
		name = scan.next();
		nSheet = scan.nextInt();
		price = scan.nextInt();
	}

	public void print() {
		 System.out.printf("%s %dwkd (%d원)\n",
				 name, nSheet, price);
	}

	public boolean matches(String kwd) {
		if(name.contains(kwd))
			return true;
		if(kwd.contentEquals(""+nSheet))
			return true;
		return false;
	}
}
