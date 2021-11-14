package Items;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Item {//Our Manageable
	public abstract void read(Scanner scan);
	public void modify() {
		
	}
	public abstract void print();
	public abstract boolean match(String kwd);
	
	public enum Category {
		THRILLER, ACTION, ROMANCE, SF, COMEDY, HORROR, FANTASY, DOCUMENTARY, LIFESTYLE
	}
	public Category stringToCategory(String kwd) {
		return Category.valueOf(kwd);
	}
	
	public String getName() {
		return name;	
	}
	public int getTime() {
		return time;	
	}
	public float getGrade() {
		return grade;	
	}
	 
	public int getRating(){ 
		return rating;
	}
	
	protected String name;
	protected int time;
	protected float grade;
	protected int rating;//관람등급
	protected ArrayList<Category> category = new ArrayList<Category>(); 
	protected String summary;
}

