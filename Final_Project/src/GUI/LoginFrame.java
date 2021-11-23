package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.sun.tools.javac.Main;
import ProcessManagement.Managers;

public class LoginFrame extends JFrame implements MyFrame {

	private JPanel lPanel;
	private JLabel lLogin, lId, lPassword;
	private JTextField tId;
	private JPasswordField tPassword;
	private JButton loginButton, signUpButton, exitButton;
	private String nextSystem;
	private boolean isRunning = false;

	public void startMenu() {
		isRunning = true;
	}
	
	public boolean isRunning() {
		return this.isRunning;
	}
	
	public LoginFrame() {
		super("Nutflix");
	}

	public void init() {
		super.setResizable(true);
		setSize(350, 400);
		setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon("nut.png");
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false); // �׸��� ǥ���ϰ� ����,�����ϰ� ����
				super.paintComponent(g);
			}
		};

		lPanel = new JPanel();
		lPanel.setLayout(new BorderLayout());
		setContentPane(lPanel);

		lLogin = new JLabel("Nutflix");
		lLogin.setFont(new Font("Couruer New", Font.BOLD, 50));
		lLogin.setForeground(Color.red);
		lLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lLogin.setPreferredSize(new Dimension(120, 120));
		lPanel.add(lLogin, BorderLayout.NORTH);

		JPanel Main = new JPanel(new GridLayout(2, 2, 15, 15));

		lId = new JLabel("아이디");
		lId.setFont(new Font("Couruer New", Font.BOLD, 15));
		lId.setHorizontalAlignment(SwingConstants.CENTER);
		Main.add(lId);

		tId = new JTextField();
		tId.setColumns(10);
		Main.add(tId);

		lPassword = new JLabel("비밀번호");
		lPassword.setFont(new Font("Couruer New", Font.BOLD, 15));
		lPassword.setHorizontalAlignment(SwingConstants.CENTER);
		Main.add(lPassword);

		tPassword = new JPasswordField();
		tPassword.setColumns(10);
		Main.add(tPassword);

		lPanel.add(Main, BorderLayout.WEST);

		JPanel btnMain = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 60));
		buttonSetting();
		btnMain.add(loginButton);
		btnMain.add(signUpButton);
		btnMain.add(exitButton);
		lPanel.add(btnMain, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void runFrame() {
		setVisible(true);
	}

	public void disposeFrame() {

	}

	private void buttonSetting() {
		loginButton = new JButton("로그인");
		signUpButton = new JButton("회원가입");
		exitButton = new JButton("닫기");

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tId.getText();
				String password = tPassword.getText();

				String result = tId.getText();
				if (result.equals("1")) {
					JOptionPane.showMessageDialog(null, "로그인 완료");
					Managers.menuManger.changeMenuState("MAIN");
					dispose();
				} else if (result.equals("2")) {// ticket 2 : admin일 때로ㅓ 바꾸기
					JOptionPane.showMessageDialog(null, "어드민 로그인 완료");
					Managers.menuManger.changeMenuState("ADMIN");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}

			}
		});
		signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpFrame signUpFrame = new SignUpFrame();
				signUpFrame.init();
				signUpFrame.runFrame();
			}
		});
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Managers.menuManger.changeMenuState("END");
				dispose(); // ticket 1아예 프로그램 종료해버리는걸로 바꾸기
			}
		});
	}
}