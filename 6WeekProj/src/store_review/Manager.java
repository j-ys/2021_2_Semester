package store_review;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Manager {
	ArrayList<Manageable> mList = new ArrayList<Manageable>();

	public void readAll(String file, Factory fac) {
		Scanner filein = openFile(file);
		Manageable m = null;
		while (filein.hasNext()) {
			m = fac.create();
			m.read(filein);
			mList.add(m);
		}
		filein.close();
	}

	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (IOException e) {
			System.out.println("파일 입력 오류");
			System.exit(0);
		}
		return filein;
	}

	void searchAll() {
		String kwd = null;
		while (true) {
			System.out.print(">> ");
			kwd = Store.scan.next();
			if (kwd.contentEquals("end"))
				break;
			for (Manageable m : mList) {
				if (m.matches(kwd))
					m.print();
			}
		}
	}

	Manageable find(String kwd) {
		for (Manageable m : mList) {
			if (m.matches(kwd))
				return m;
		}
		return null;
	}

	void printAll() {
		for (Manageable m : mList) {
			m.print();
		}
	}
}
