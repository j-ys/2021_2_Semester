package book;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
	Scanner scan = new Scanner(System.in);
	ArrayList<Book> bookList = new ArrayList<>();
	ArrayList<Manageable> sellList = new ArrayList<>();

	void run() {
		readAll("book.txt");
		printAll();
		search();
	}

	void printAll() {
		for (Manageable m : sellList)
			m.print();
	}

	void readAll(String filename) {
		Scanner filein = openFile(filename);
		Manageable item = null;
		while (filein.hasNext()) {
			int type = filein.nextInt();
			switch (type) {
			case 1:
				item = new Book();
				break;
			case 2:
				item = new EBook();
				break;
			case 3:
				item = new AppendixBook();
				break;
			case 4:
				item = new Pen();
				break;
			case 5:
				item = new Tissue();
				break;
			default:
				break;
			}
			item.read(filein);
			sellList.add(item);
		}

	}

	void search() {
		String kwd = null;
		while (true) {
			System.out.print(">> ");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			for (Manageable m : sellList) {
				if (m.matches(kwd))
					m.print();
			}
		}
	}

	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (IOException e) {
			System.out.println("File open failed" + filename);
		}
		return filein;
	}

	public static void main(String[] args) {
		BookStore store = new BookStore();
		store.run();
	}
}
