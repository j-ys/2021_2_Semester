package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import ProcessManagement.Managers;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import Items.Item;

class JPanel011 extends JPanel { // 1번 패널

	public JPanel011() { // 1번째 패널 생성자
		JPanel jp_label = new JPanel();


		JToggleButton btns[] = new JToggleButton[Managers.managedList.itemList.size()];
		
		for (int i = 0; i < Managers.managedList.itemList.size(); i++) {
			Item nowItem = Managers.managedList.itemList.get(i);
			btns[i] = makeImageButton(nowItem.getImagePath(),nowItem.getName());
			if (i < 4) {
				btns[i].setBounds(25 + i * 150, 50, 100, 100);
			} else {
				btns[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
			}
			add(btns[i]);
		}
		
	}
	static boolean isSelectedOrder = false;
	static int nowContentNumber = -1;
	private JToggleButton makeImageButton(String imagePath,String buttonName) {
		ImageIcon image = new ImageIcon(imagePath);
		Image image2 = image.getImage();
		Image i4 = image2.getScaledInstance(160, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon i5 = new ImageIcon(i4);
		
		JToggleButton b = new JToggleButton(buttonName, i5);
		b.setHorizontalTextPosition(SwingConstants.CENTER);
		b.setVerticalTextPosition(SwingConstants.BOTTOM);
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		b.setBackground(Color.white);
		b.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				if (ev.getStateChange() == ItemEvent.SELECTED) {
					Managers.recommendManager.addInterestItem(b.getLabel());
				} else if (ev.getStateChange() == ItemEvent.DESELECTED) {

					//isSelectedOrder = false;
				}
			}
		});
		return b;
	}
}

class JPanel022 extends JPanel implements ActionListener { // 2번째 패널
	public JPanel022() { // 2번째 패널 생성자
		ArrayList<Item> items = Managers.managedList.itemList;
		String header[] = { "종류", "장르", "제목", "방영년도", "평점", "시청등급", "줄거리" };

		ArrayList<String[]> itemsData = new ArrayList<String[]>();
		for (Item item : items) {
			String sample[] = { item.getType(), item.getCategories(), item.getName(), item.getTime() + "",
					item.getGrade() + "", item.getRating() + "", item.getSummary() };
			itemsData.add(sample);
		}
		String contents[][] = new String[itemsData.size()][];
		int index = 0;
		for (String[] itemData : itemsData) {
			contents[index++] = itemData;
		}
		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setLocation(100, 60);
		scrollpane.setSize(560, 460);
		add(scrollpane);

		setLayout(null);

		JTextField sText = new JTextField();
		sText.setLocation(100, 20);
		sText.setSize(560, 30);
		add(sText);
		/* 관리자에선 textField.getText()해서 inputstr[]에 넣고 add, delete */
		JButton sbutton = new JButton("검색");
		sbutton.setSize(80, 30);
		sbutton.setLocation(670, 20);
		add(sbutton);
		sbutton.addActionListener(this);

		JComboBox<String> combo;
		String[] cbdata = { "제목", "방영년도", "평점" };

		JComboBox<String> jcb = new JComboBox<String>(cbdata);
		jcb.setLocation(20, 20);
		jcb.setSize(70, 30);
		add(jcb);

		jcb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String field = (String) jcb.getSelectedItem();
				if (field.equals("제목")) {
					Managers.sortingManager.mySort(Managers.managedList.itemList, 1);
				} else if (field.equals("방영년도")) {
					Managers.sortingManager.mySort(Managers.managedList.itemList, 2);
				} else if (field.equals("평점")) {
					Managers.sortingManager.mySort(Managers.managedList.itemList, 3);
				} else {
					return;
				}
				tableModelUpdate(model);
			}

		});

		sbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String field = (String) jcb.getSelectedItem();
				String word = sText.getText();
				if (!word.equals(null)) {// 검색
					int index = 0;
					for (Item item : Managers.managedList.itemList) {
						if (item.match(word)) {
							item.print();
						}
					}
				}
			}

		});

	}

	void tableModelUpdate(DefaultTableModel model) {
		int rowCnt = model.getRowCount();
		for (int i = 0; i < rowCnt; i++) {
			model.removeRow(0);
		}

		ArrayList<Item> items = Managers.managedList.itemList;
		ArrayList<String[]> itemsData = new ArrayList<String[]>();
		for (Item item : items) {
			String sample[] = { item.getType(), item.getCategories(), item.getName(), item.getTime() + "",
					item.getRating() + "", item.getSummary() };
			itemsData.add(sample);
		}
		String contents[][] = new String[itemsData.size()][];
		int index = 0;
		for (String[] itemData : itemsData) {
			contents[index++] = itemData;
		}

		for (int i = 0; i < contents.length; i++) {
			model.addRow(contents[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}

class JPanel033 extends JPanel {
	public JPanel033() {
		setLayout(null);
		JButton bt_img;

		// JTable table = new JTable();
		ImageIcon images = new ImageIcon("./NoRecommand.png");
		Image im = images.getImage(); // 뽑아온 이미지 객체 사이즈를 새롭게 만들기!
		Image im2 = im.getScaledInstance(230, 230, Image.SCALE_SMOOTH);

		ImageIcon icon2 = new ImageIcon(im2);
		bt_img = new JButton(icon2);
		bt_img.setSize(400, 400);
		bt_img.setLocation(220, 50);
		bt_img.setBorderPainted(false);
		bt_img.setFocusPainted(false);
		bt_img.setContentAreaFilled(false);
		add(bt_img);

		JButton nextRecom;
		ImageIcon next = new ImageIcon("./NextRecommand.png");
		Image nextim = next.getImage();
		Image im3 = nextim.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon icon3 = new ImageIcon(im3);
		nextRecom = new JButton(icon3);
		nextRecom.setSize(400, 400);
		nextRecom.setLocation(500, 50);
		nextRecom.setBorderPainted(false);
		// nextRecom.setFocusPainted(false);
		nextRecom.setContentAreaFilled(false);
		add(nextRecom);
		// 이벤트 처리하기

		// if 시청기록 없을 경우
		if(!Managers.recommendManager.existRecommendItem()) {
			JLabel label = new JLabel("추천드릴 콘텐츠가 없어요    :(");
			label.setLocation(330, 400);
			label.setSize(200, 20);
			add(label);
		}
		else {
			
		}

		/*
		 * else 시청기록 있을 경우
		 * 
		 */
	}
}

class JPanel044 extends JPanel {// 리뷰 Panel

}


public class MainGUI extends JFrame {
	public JPanel011 jpanel01 = null;
	public JPanel022 jpanel02 = null;
	public JPanel033 jpanel03 = null;
	public JPanel044 jpanel04 = null;
	final static int GUI_WIDTH = 900;
	final static int GUI_HEIGHT = 650;
	public MainGUI() {
		init();
		runFrame();
	}

	public void init() {
		setTitle("OTT Service_ Coffee Machine");
		jpanel01 = new JPanel011();
		jpanel02 = new JPanel022();
		jpanel03 = new JPanel033();
		jpanel04 = new JPanel044();

		JTabbedPane jtab = new JTabbedPane(); // JTabbedPane 객체 생성
		jtab.setTabPlacement(JTabbedPane.TOP);
		jtab.addTab("Contents", jpanel01);
		jtab.addTab("Search/Sorting", jpanel02);
		jtab.addTab("Recommend", jpanel03);
		jtab.addTab("Review", jpanel04);

		Dimension dim = new Dimension(430, 400);
		setResizable(false);
		add(jtab);
		setLocation(400, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.black);
		setSize(GUI_WIDTH, GUI_HEIGHT);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void runFrame() {
		setVisible(true);
	}

	public static void setJButtonStyle(JButton btn) {
		btn.setBackground(Color.DARK_GRAY);
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("맑은 고딕", 0, 15));
		btn.setHorizontalAlignment(JLabel.CENTER);
	}
}
