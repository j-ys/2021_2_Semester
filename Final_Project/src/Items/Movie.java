package Items;

import java.util.ArrayList;
import java.util.Scanner;

public class Movie extends Item{
	String movieDirector;
	ArrayList<String> mainActors = new ArrayList<String>();
	
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
		movieDirector = scan.next();
		String []mainActor = scan.next().split(",");
		for(String str : mainActor){
			mainActors.add(str);
		}
		summary = scan.nextLine();
	}
	
	@Override
	public boolean match(String kwd) {
		if(name.contains(kwd)) {
			return true;
		}
		if(movieDirector.contains(kwd)) {
			return true;
		}
		if(kwd.equals(""+time)) {
			return true;
		}
		if(kwd.equals(""+rating)) {
			return true;
		}
		for(String actor : mainActors) {
			if(actor.contains(kwd)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.printf(" %s |",movieDirector);
		for(int i=0;i<mainActors.size();i++){
			if(i==(mainActors.size()-1)) {
				System.out.printf("%s",mainActors.get(i));	
			}
			else {
				System.out.printf("%s,",mainActors.get(i));	
			}
		}	
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
		movieDirector = scan.next();
		String []mainActor = scan.next().split(",");
		for(String str : mainActor){
			mainActors.add(str);
		}
		summary = scan.nextLine();
	}
}
