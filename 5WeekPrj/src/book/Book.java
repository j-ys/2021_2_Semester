package book;

import java.util.ArrayList;
import java.util.Scanner;

public class Book implements Manageable{
	String title;
	String pub;
	int isbn;
	int year;
	ArrayList<String> authors;
	int price;
	
	@Override
	public void read(Scanner scan) {
		title = scan.next();
		pub = scan.next();
		isbn = scan.nextInt();
		year = scan.nextInt();
		String tmp;
		while(true) {		
			tmp = scan.next();
			if (tmp.contentEquals("0"))
				break;
			authors.add(tmp);
		}
		price = scan.nextInt();
	}

	void printBookType() { // Book
		System.out.print("[일반책] ");
	}
	
	@Override
	public void print() {
		printBookType();
		System.out.printf("%s (%s/%s/%d년) [%d원] 저자:", 
				title, pub, isbn, year, price);
	}
	
	@Override
	public boolean matches(String kwd) {
		if (title.contains(kwd))
			return true;
		if (pub.contains(kwd))
			return true;
		if (kwd.equals(""+isbn))
			return true;
		if (kwd.equals(""+year))
			return true;
		for(String a : authors)
			if(kwd.contentEquals(a))
				return true;
		return false;
	}
}
