package UserManagement;
import java.util.Scanner;

public class User{
	public String userId;
	public String pw;
	

	public void read(Scanner scan) {
		userId = scan.next();
		pw = scan.next();
	}

	public void print() {
		System.out.printf("[%s] (%s)\n", userId, pw);
	}
	public boolean match(String kwd) {
		if (userId.equals(kwd)) {
			return true;
		}
		return false;
	}
}