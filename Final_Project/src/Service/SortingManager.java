package Service;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import Items.Item;

public class SortingManager <T extends Item>{

	
	public void mySort(ArrayList<T> targetList, int sortOption) {
		switch (sortOption) {
		case 1://by name
			Collections.sort(targetList, new Comparator<T>() {
				@Override
				public int compare(T item1, T item2) {
					return item1.getName().compareTo(item2.getName());
				}
			});
			break;
		case 2://by time
			Collections.sort(targetList, new Comparator<T>() {
				@Override
				public int compare(T item1, T item2) {
					if (item1.getTime() == item2.getTime())
						return 0;
					else if (item1.getTime()> item2.getTime())
						return 1;
					else
						return -1;
				}
			});
			break;
		case 3://by grade
			Collections.sort(targetList, new Comparator<T>() {
				@Override
				public int compare(T item1, T item2) {
					if (item1.getGrade() == item2.getGrade())
						return 0;
					else if (item1.getGrade() > item2.getGrade())
						return 1;
					else
						return -1;
				}
			});
			break;	
		}
	}
}
