package ReviewManagement;
import java.util.ArrayList;
import java.util.Scanner;

import Items.Item;
import ProcessManagement.Managers;



public class ReviewManager {

	public ReviewManager() {
	}
	private ArrayList<Review> reviewList;
	private Scanner scan;
		
	public void init(Scanner scan) {
		this.scan = scan;
	}
	
	public Review find(String id, String name) {
		for (Review m: reviewList) {
			if(m.match(id, name))
				return m;
		}
		return null;
	}
	
	public Review findByName(String itemName) {
		/*for(Item item : Managers.managedList.itemList) {
			if(item.getName().equals(itemName))
				return item;
		}*/
		return null;
	}
	
	public void writeRev(String id, String name) {
		Review exist = find(id, name);
		if(exist != null) {
	    	System.out.println("이미 리뷰를 남기셨습니다.");
		}
		else if(exist == null) {
			System.out.print("평점: ");
			float grade = scan.nextFloat();
			System.out.print("간단한 리뷰를 써주세요.: ");
			String review = scan.nextLine();
			Review newReview = new Review();
			newReview.userId = id;
			newReview.itemName = name;
			newReview.grade = grade;
			newReview.content = review;
	        reviewList.add(newReview);
		}
	}
}
