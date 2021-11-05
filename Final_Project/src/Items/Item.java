package Items;

public abstract class Item {//Our Manageable
	public abstract void insert();
	public abstract void modify();
	public abstract void delete();
	public abstract boolean match(String kwd);
	public abstract void print();
	
	protected String name;
	protected int time;
	protected int grade;
	public String getName() {
		return name;	
	}
	public int getTime() {
		return time;	
	}
	public int getGrade() {
		return grade;	
	}
	
	
}
