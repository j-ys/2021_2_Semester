package Service;

import java.util.ArrayList;
import Items.Item;

public class RecommendManager {
	final public static int RECOMMEND_ITEM_COUNT=10;
	ArrayList<Item> interestItems;
	Item[] recommendItems;
	
	public RecommendManager() {
		recommendItems = new Item[RECOMMEND_ITEM_COUNT];
	}
	
	public void addInterestItem(Item newItem) {
		interestItems.add(newItem);
	}
	
	public void provideRecommendItems() {
		
	}
	
}
