package FileSystem;

import java.io.File;
import java.util.Scanner;

public class FileManager {
	public Scanner openFile(String filename) {
		Scanner file = null;
		try {
			file = new Scanner(new File("Final_Project/src/"+filename));
		} 
		catch (Exception e) {
			System.out.printf(filename + ": Can't Open [%s]\n", filename);
			System.exit(0);
		}
		return file;
	}

}
