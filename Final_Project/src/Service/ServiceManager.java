package Service;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import ProcessManagement.Managers;
import ReviewManagement.Review;
import UserManagement.User;
import Items.Item;
import Items.ItemFactory;

public class ServiceManager {
	private ArrayList<Item> itemList= new ArrayList<Item>();
	private ArrayList<User> userList= new ArrayList<User>();
	private ArrayList<Review> reviewList= new ArrayList<Review>();
	private Scanner scan = new Scanner(System.in);
	private MenuManager menuManger;

	public void init() {
		readDatas();
		readUsers();
		readReviews();
		menuManger = new MenuManager(itemList, userList, reviewList, scan);
	}
	
	public void run() {
		menuManger.menuRun();
	}
	
	private void readDatas() {
		Scanner file = Managers.fileManager.openFile("datas.txt");
		String nowData;
		Item nowItem;
		while(file.hasNext()){
			nowData = file.next();
			nowItem = ItemFactory.createItem(nowData);
			nowItem.read(file);
			nowItem.print();
			itemList.add(nowItem);
		}
	}
	
	public void readUsers() {
		Scanner file = Managers.fileManager.openFile("users.txt");
		User nowUser = new User();
		while(file.hasNext()){
			nowUser.read(file);
			nowUser.print();
			userList.add(nowUser);
		}
	}
	
	public void readReviews() {
		Scanner file = Managers.fileManager.openFile("reviews.txt");
		Review review = new Review();
		while(file.hasNext()){
			review.read(file);
			review.print();
			reviewList.add(review);
		}
	}
}


















