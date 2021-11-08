package Items;

public abstract class Item {//Our Manageable
	public abstract void insert();
	public abstract void modify();
	public abstract void delete();
	public abstract void print();
	public abstract boolean match(String kwd);
	
	public enum Category {
		THRILLER, ACTION, ROMANCE, SF, COMEDY, HORROR, FANTASY, DOCUMENTARY
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
	public int getGrade() {
		return grade;	
	}
	 
	public int getRating(){ 
		return rating;
	}
	
	protected String name;
	protected int time;
	protected int grade;
	protected int rating;//관람등급
	protected Category category; 
}
