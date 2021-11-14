package Service;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import ProcessManagement.Managers;
import Items.Item;
import Items.ItemFactory;

public class ServiceManager {
	private ArrayList<Item> itemList= new ArrayList<Item>();
	private Scanner scan = new Scanner(System.in);
	private MenuManager menuManger;

	public void init() {
		readDatas();
		menuManger = new MenuManager(itemList, scan);
	}
	
	private void readDatas() {
		Scanner file = Managers.fileManager.openFile("datas.txt");
		String nowData;
		Item nowItem;
		while(true){
			nowData = file.next();
			nowItem = ItemFactory.createItem(nowData);
			nowItem.read(file);
			nowItem.print();
			itemList.add(nowItem);
		}
	}
	
	public void run() {
		menuManger.menuRun();
	}
	
}


















