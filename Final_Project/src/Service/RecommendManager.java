package Service;

import Items.Item;
import ProcessManagement.Managers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RecommendManager {
	final public static int RECOMMEND_ITEM_COUNT = 10;
	ArrayList<Item> interestItems;
	LinkedList<Item> recommendItems;
	ArrayList<Item.Category> interestedCategory;
	
	public RecommendManager() {
		recommendItems = new LinkedList<Item>();
		interestItems = new ArrayList<Item>();
		interestedCategory = new ArrayList<Item.Category>();
	}

	public boolean existRecommendItem() {
		if(interestItems.size()==0)
			return false;
		return true;
	}
	
	public void addInterestItem(String name) {
		Item nowItem = findbyName(name);
		for (Item item : interestItems) {
			if (nowItem.equals(item)) {
				return;
			}
		}
		interestItems.add(nowItem);

		boolean isDuplicate = false;
		for (Item.Category newCate : nowItem.getCategory()) {
			for (Item.Category oldCate : interestedCategory) {
				if (newCate.equals(oldCate)) {
					isDuplicate = true;
				}
			}
			if (!isDuplicate) {
				interestedCategory.add(newCate);
			}
			isDuplicate = false;
		}
		
		updateRecommendItem();
		for(Item i : recommendItems) {
			i.print();
		}
		System.out.println();
	}

	public List<Item> provideRecommendItems() {
		updateRecommendItem();
		return recommendItems;
	}

	private void updateRecommendItem() {
		boolean passFlag = false;
		for (Item.Category interestCategory : interestedCategory) {
			for (Item toAddItem : Managers.managedList.itemList) {
				for (Item oldItem : recommendItems) {
					if (oldItem.equals(toAddItem)) {
						passFlag = true;
						break;
					}
				}

				if (passFlag) {
					passFlag = false;
					continue;
				}

				if (categoryMatch(interestCategory, toAddItem.getCategory())) {
					if (recommendItems.size() == RECOMMEND_ITEM_COUNT) {
						int removeIndex = 0;
						Item toRemove = recommendItems.get(removeIndex);
						for (int i = 1; i < RECOMMEND_ITEM_COUNT; i++) {
							if (toRemove.getGrade() > recommendItems.get(i).getGrade()) {
								removeIndex = i;
							}
						}
						recommendItems.remove(removeIndex);
					}
					recommendItems.add(toAddItem);
				}
			}
		}
	}

	private boolean categoryMatch(Item.Category category, ArrayList<Item.Category> list) {
		for (Item.Category cate : list) {
			if (cate.equals(category)) {
				return true;
			}
		}
		return false;
	}

	private Item findbyName(String name) {
		for (Item item : Managers.managedList.itemList) {
			if (name.equals(item.getName())) {
				return item;
			}
		}
		return null;
	}

}
