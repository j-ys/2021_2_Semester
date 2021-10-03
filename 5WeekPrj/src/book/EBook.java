package book;

import java.util.Scanner;

public class EBook extends Book {
	String url;
	String format;

	@Override
	public void read(Scanner scan) {
		title = scan.next();
		pub = scan.next();
		isbn = scan.nextInt();
		year = scan.nextInt();
		while (true) {  }// 저자 여러명을 읽는 부분
		price = scan.nextInt();
		url = scan.next();
		format = scan.next();
	}

	@Override
	public void printBookType() { // EBook
		System.out.print("[전자책] ");
	}
	
	@Override
	public void print() {
		super.print();
		System.out.printf("%s [%s]\n", url, format);
	}

	@Override
	boolean matches(String kwd) {
		if (super.matches(kwd))
			return true;
		if (url.contains(kwd))
			return true;
		if (format.equals(kwd))
			return true;
		return false;
	}
}