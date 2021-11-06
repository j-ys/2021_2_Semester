package Service;

import java.awt.event.ActionEvent;
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
					return item1.getName().compareTo(item2.getName());
				}
			});
			break;
		case 2://by time
			Collections.sort(list, new Comparator<T>() {
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
			Collections.sort(list, new Comparator<T>() {
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
	
	public void categorySort() {
		boolean done = false;
		int input = 0;
		while(!done) {
			System.out.println("****Category sort Menu****");
			Item.Category selectedCategory;
			//GUI option select
			//case - switch : which button clicked? => selectedCategory value 
			
			switch(input) {
			case 1:
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				done = true;
				break;
			default:
				break;
			}
		}	
	}	
	//예시 버튼 이벤트 
	//@Override
	public void actionPerformed(ActionEvent e) {
		//THRILLER, ACTION, ROMANCE, SF, COMEDY, HORROR, FANTASY, DOCUMENTARY
		String buttonName = e.getActionCommand();
		if (buttonName.equals("스릴러")) {
			
		}
		else if (buttonName.equals("액션")) {
			
		}
		else if (buttonName.equals("로맨스")) {
			
		}
		else if (buttonName.equals("SF")) {
			
		}
		else if (buttonName.equals("코미디")) {

		} 
		else if (buttonName.equals("호러")) {

		} 
		else if (buttonName.equals("판타지")) {

		} 
		else if (buttonName.equals("다큐")) {

		} 
		else if (buttonName.equals("SF")) {

		}
	}
}
