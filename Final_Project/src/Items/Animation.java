package Items;

import java.util.ArrayList;
import java.util.Scanner;

public class Animation extends Item{
	
	@Override
	public void read(Scanner scan) {
		name = scan.next();
		String []categorys = scan.next().split(",");
		for(String str : categorys){
			category.add(stringToCategory(str));
		}
		time = scan.nextInt();
		grade = scan.nextFloat();
		rating = scan.nextInt();
		summary = scan.nextLine();
	}
	
	@Override
	public boolean match(String kwd) {
		if(name.contains(kwd)) {
			return true;
		}
		if(kwd.equals(""+time)) {
			return true;
		}
		if(kwd.equals(""+rating)) {
			return true;
		}
		return false;
	}
	@Override
	public void print() {
		super.print();
		System.out.println();
	}
	@Override
	public void setData(Scanner scan) {
		System.out.println("Enter");
		name = scan.next();
		String []categorys = scan.next().split(",");
		for(String str : categorys){
			category.add(stringToCategory(str));
		}
		time = scan.nextInt();
		grade = scan.nextFloat();
		rating = scan.nextInt();
		summary = scan.nextLine();
	}
}
