package Items;

import java.util.ArrayList;
import java.util.Scanner;

public class Entertainment extends Item{
	 String channel;
	 ArrayList<String> castmates = new ArrayList<String>();
	 
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
		channel = scan.next();
		String []castmate = scan.next().split(",");
		for(String str : castmate){
			castmates.add(str);
		}
		summary = scan.nextLine();
	}

	@Override
	public boolean match(String kwd) {
		if(name.contains(kwd)) {
			return true;
		}
		if(channel.contains(kwd)) {
			return true;
		}
		if(kwd.equals(""+time)) {
			return true;
		}
		if(kwd.equals(""+rating)) {
			return true;
		}
		for(String cast : castmates) {
			cast.contains(kwd);
			return true;
		}
		return false;
	}
	@Override
	public void print() {
		
	}
}
