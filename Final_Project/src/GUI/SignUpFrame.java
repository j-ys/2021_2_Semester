package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ProcessManagement.Managers;

public class SignUpFrame extends JFrame{

	private JPanel rPanel;
	private JLabel rLabel;
	private JLabel rId, rPassword;
	private JTextField tId, tPassword;
	private JButton signUpButton;

	public SignUpFrame() {
		super("회원가입");
	}
	
	public void init() {
		super.setResizable(true);
		setSize(350, 400);
		setLocationRelativeTo(null);

		rPanel = new JPanel();
		rPanel.setLayout(new BorderLayout());
		setContentPane(rPanel);

		rLabel = new JLabel("회원가입");
		rLabel.setFont(new Font("Couruer New", Font.BOLD, 40));
		rLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rPanel.add(rLabel, BorderLayout.NORTH);
		rLabel.setForeground(Color.black);

		JPanel main = new JPanel(new GridLayout(7, 2, 10, 10));
		rId =			new JLabel("아이디");
		tId = 			new JTextField();
		rPassword = 	new JLabel("비밀번호");
		tPassword = 	new JTextField();	
		rId.setHorizontalAlignment(SwingConstants.CENTER);		
		rPassword.setHorizontalAlignment(SwingConstants.CENTER);			
		main.add(rId);
		main.add(tId);
		main.add(rPassword);
		main.add(tPassword);

		rPanel.add(main, BorderLayout.CENTER);
		JPanel jPanel = new JPanel();
		buttonSetting();
		rPanel.add(jPanel, BorderLayout.EAST);
		rPanel.add(signUpButton, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	private void buttonSetting(){
		signUpButton = new JButton("회원가입");
		signUpButton.setFont(new Font("Couruer New", Font.BOLD, 20));
		signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				String id = tId.getText();
				String pw = tPassword.getText();
				int result = Managers.userManager.signUp(id, pw);
				
				if (result == 1) {
					JOptionPane.showMessageDialog(null, "회원등록 완료");
					dispose();
				} 
				else {
					JOptionPane.showMessageDialog(null, "회원동록 실패");
					dispose();
				}
			}
		});
	}
	
	public void runFrame() {
		setVisible(true);
	}
}
