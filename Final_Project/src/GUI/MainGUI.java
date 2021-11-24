package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ProcessManagement.Managers;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

class JPanel011 extends JPanel { // 1번 패널

	public JPanel011() { // 1번째 패널 생성자
		setLayout(null);
		JButton bt_img1;
		//JTable table = new JTable();
		ImageIcon images= new ImageIcon("./Animation/겨울왕국.png");
		Image im = images.getImage(); //뽑아온 이미지 객체 사이즈를 새롭게 만들기!

		Image im2 = im.getScaledInstance(200, 300, Image.SCALE_SMOOTH);

		//새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon 객체를 다시 생성

		ImageIcon icon2 = new ImageIcon(im2);
		bt_img1 = new JButton(icon2);
		//bt_img.setPreferredSize(new Dimension(300, 10));
		
		//JLabel img = new JLabel(icon2);
		//img.setLocation(100,60);
		bt_img1.setSize(200,300);
		bt_img1.setLocation(10, 20);
		bt_img1.setBorderPainted(false);

		bt_img1.setFocusPainted(false);

		bt_img1.setContentAreaFilled(false);
		add(bt_img1);
		
		JButton bt_img2;
		//JTable table = new JTable();
		ImageIcon images2= new ImageIcon("./Animation/귀멸의칼날.png");
		Image im3 = images2.getImage(); //뽑아온 이미지 객체 사이즈를 새롭게 만들기!

		Image im4 = im3.getScaledInstance(200, 300, Image.SCALE_SMOOTH);

		//새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon 객체를 다시 생성

		ImageIcon icon3 = new ImageIcon(im4);
		bt_img2 = new JButton(icon3);
		bt_img2.setSize(200,300);
		bt_img2.setLocation(240, 20);
		bt_img2.setBorderPainted(false);

		bt_img2.setFocusPainted(false);

		bt_img2.setContentAreaFilled(false);
		add(bt_img2);
		
		}
	
	
}

class JPanel022 extends JPanel implements ActionListener { // 2번째 패널
	public JPanel022() { // 2번째 패널 생성자
		String header[] = { "종류", "장르", "제목", "방영년도", "평점", "주연", "줄거리" };
		String contents[][] = { { "Animation", "SF, FANTASY", "귀멸의 칼날", "2020", "3.7", "null", "탄지로 젠이츠 ~~" },
				{ "Movie", "THRILLER,COMEDY", "기생충", "2019", "4.4", "송강호, 이선균", "반지하 ~~" } };

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

		JTextField search = new JTextField(15);
		JComboBox<String> combo;
		String[] cbdata = { "장르", "제목", "종류", "방영년도", "평점", "주연" };
		;

		JComboBox<String> jcb = new JComboBox<String>(cbdata);
		jcb.setLocation(20, 20);
		jcb.setSize(70, 30);
		add(jcb);

		sbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String field = (String) jcb.getSelectedItem();
				String word = search.getText();
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

class JPanel033 extends JPanel {
	public JPanel033() {
		setLayout(null);
		JButton bt_img;
		
		//JTable table = new JTable();
		ImageIcon images= new ImageIcon("./NoRecommand.png");
		Image im = images.getImage(); //뽑아온 이미지 객체 사이즈를 새롭게 만들기!

		Image im2 = im.getScaledInstance(230, 230, Image.SCALE_SMOOTH);

		//새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon 객체를 다시 생성

		ImageIcon icon2 = new ImageIcon(im2);
		bt_img = new JButton(icon2);
		//bt_img.setPreferredSize(new Dimension(300, 10));
		
		//JLabel img = new JLabel(icon2);
		//img.setLocation(100,60);
		bt_img.setSize(400,400);
		bt_img.setLocation(220,50);
		bt_img.setBorderPainted(false);
		bt_img.setFocusPainted(false);
		bt_img.setContentAreaFilled(false);
		add(bt_img);
		
		JButton nextRecom;
		ImageIcon next= new ImageIcon("./NextRecommand.png");
		Image nextim = next.getImage();
		Image im3 = nextim.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon icon3 = new ImageIcon(im3);
		nextRecom = new JButton(icon3);
		nextRecom.setSize(400,400);
		nextRecom.setLocation(500,50);
		nextRecom.setBorderPainted(false);
		//nextRecom.setFocusPainted(false);
		nextRecom.setContentAreaFilled(false);
		add(nextRecom);
		//이벤트 처리하기 
		
		//if 시청기록 없을 경우
		JLabel label = new JLabel("추천드릴 콘텐츠가 없어요    :(");
		label.setLocation(330,400);
		label.setSize(200,20);
		add(label);
		
		/*
		 	else 시청기록 있을 경우
		 	
		 */
	}
}

class JPanel044 extends JPanel {

}

public class MainGUI extends JFrame {
	public JPanel011 jpanel01 = null;
	public JPanel022 jpanel02 = null;
	public JPanel033 jpanel03 = null;
	public JPanel044 jpanel04 = null;

	
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
		setSize(900, 650);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
	}
	
	public void runFrame()
	{
		setVisible(true);
	}
	/*
	 * public static void setJComboBoxStyle(JComboBox combo) {
	 * combo.setBackground(Color.LIGHT_GRAY); //TODO 백그라운드 색상 정의
	 * combo.setForeground(Color.WHITE); //TODO 텍스트 색상 정의 combo.setFont(new
	 * Font("맑은 고딕", 0, 15)); //TODO 폰트 정의 }
	 */

	public static void setJButtonStyle(JButton btn) {
		btn.setBackground(Color.DARK_GRAY); // TODO 백그라운드 색상 정의
		btn.setForeground(Color.WHITE); // TODO 텍스트 색상 정의
		btn.setFont(new Font("맑은 고딕", 0, 15)); // TODO 폰트 정의
		btn.setHorizontalAlignment(JLabel.CENTER); // TODO 텍스트 센터 표시 설정
	}
	
	/*
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Process done");
		Managers.menuManger.changeMenuState("END");
		System.out.println("Process done");
	}*/

	
}

/*
 * 정렬부분 원래 코드 String header[]= {"종류", "장르", "제목","방영년도", "평점", "출연진", "줄거리"};
 * String contents[][]= {{"Animation", "SF, FANTASY", "귀멸의 칼날", "2020",
 * "3.7","null", "탄지로 젠이츠 ~~"}, {"Movie", "THRILLER,COMEDY", "기생충", "2019",
 * "4.4", "송강호, 이선균", "반지하 ~~"} }; DefaultTableModel model = new
 * DefaultTableModel(contents, header); JTable table = new JTable(model);
 * JScrollPane scrollpane = new JScrollPane(table);
 * scrollpane.setLocation(20,20); scrollpane.setSize(520,460); add(scrollpane);
 * JButton jButton1 = new JButton("오래된 순"); jButton1.setSize(130,20);
 * jButton1.setLocation(560,20); //이벤트 처리 해야함 add(jButton1);
 * 
 * JButton jButton2 = new JButton("최신 순"); jButton2.setSize(130,20);
 * jButton2.setLocation(560,60); add(jButton2);
 * 
 * JButton jButton3 = new JButton("가나다 순(제목)"); jButton3.setSize(130,20);
 * jButton3.setLocation(560,100); add(jButton3);
 * 
 * JButton jButton4 = new JButton("평점 높은 순"); jButton4.setSize(130,20);
 * jButton4.setLocation(560,140); add(jButton4);
 * 
 * JButton jButton5 = new JButton("평점 낮은 순"); jButton5.setSize(130,20);
 * jButton5.setLocation(560,180); add(jButton5);
 */