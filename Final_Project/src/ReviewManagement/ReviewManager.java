package ReviewManagement;
import java.util.ArrayList;
import java.util.Scanner;



public class ReviewManager {

	public ReviewManager(ArrayList<Review> reviewList, Scanner scan) {
		this.reviewList = reviewList;
		this.scan = scan;
	}
	private ArrayList<Review> reviewList;
	private Scanner scan;
	
	public Review find(String id, String name) {
		for (Review m: reviewList) {
			if(m.match(id, name))
				return m;
		}
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
