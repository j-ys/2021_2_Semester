package book;

import java.util.Scanner;

public class Pen implements Manageable {
	String name;
	float thickSize;
	int price;

	public void read(Scanner scan) {
		name = scan.next();
		thickSize = scan.nextFloat();
		price = scan.nextInt();
	}

	public void print() {
		System.out.printf("%s %5.2fmm (%d원)\n",
				name, thickSize, price);
	}

	public boolean matches(String kwd) {
		if(name.contains(kwd))
			return true;
		if(kwd.contentEquals(""+thickSize))
			return true;
		return false;
	}

}
