package Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import Items.Item;

public class SortingManager <T extends Item>{
	public SortingManager(ArrayList<T> targetList,Scanner scan) {
		this.list = targetList;
		this.scan = scan;
	}
	private ArrayList<T> list;
	private Scanner scan;
	
	public void mySort(int sortOption) {

		switch (sortOption) {
		case 1://by name
			Collections.sort(list, new Comparator<T>() {
				@Override
				public int compare(T item1, T item2) {
					return item1.name.compareTo(item2.name);
				}
			});
			break;
		case 2://by time
			Collections.sort(list, new Comparator<T>() {
				@Override
				public int compare(T item1, T item2) {
					return item1.id.compareTo(item2.id);
				}
			});
			break;
		case 3://by grade
			Collections.sort(list, new Comparator<T>() {
				@Override
				public int compare(T item1, T item2) {
					if (item1.price == item2.price)
						return 0;
					else if (item1.price > item2.price)
						return 1;
					else
						return -1;
				}
			});
			break;
		}
	}
}
