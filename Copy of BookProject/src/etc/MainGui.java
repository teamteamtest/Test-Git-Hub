package etc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class MainGui extends JFrame implements ActionListener {

	private String[] colName = {"회원Id, 회원이름, 전화번호, 회원종류"};
	private JButton btnM_R, btnD_R, btnExit, btnSearch;
	private JLabel lbMemberId;
	private JTable taMember;
	private JTextField tfMemberId;
	private JPanel paNorth, paCenter, pa_North;
	//private DefaultTableModel tableModel;
	private JScrollPane sp;

	public MainGui() {
		
		paNorth = new JPanel();
		paCenter = new JPanel();
		
		//paNorth 
		btnM_R = new JButton("회원관리");
		btnD_R = new JButton("자료관리");
		btnExit = new JButton("프로그램종료");
		

		//paCenter
		pa_North = new JPanel();
		
		//pa_North
		lbMemberId = new JLabel("회원이름");
		tfMemberId = new JTextField(10);
		btnSearch = new JButton("검  색");
		
		//pa_Center
		//tableModel = new DefaultTableModel(colName, 0);
		//taMember = new JTable(tableModel);
		//sp = new JScrollPane(taMember);
		
		launchFrame();
		
		/*
		 * 이미지 파일은 해당 프로젝트 폴더가 기본이다. new ImageIcon("주소및 파일명");
		 

		btn1 = new JButton(new ImageIcon("Korea.gif"));
		btn2 = new JButton(new ImageIcon("USA.gif"));
		btn3 = new JButton(new ImageIcon("Germany.gif"));
		// 해당 버튼에 ActionListener를 등록하는 방법

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		result = new JLabel();
		result.setText("Country Name");
		add(btn1);
		add(btn2);
		add(btn3);
		add(result);*/
	}
	
	public void launchFrame(){
		
		paNorth.add(btnM_R);
		paNorth.add(btnD_R);
		paNorth.add(btnExit);
		add(paNorth, BorderLayout.NORTH);


		pa_North.add(lbMemberId);
		pa_North.add(tfMemberId);
		pa_North.add(btnSearch);
		
		//Table
		
		paCenter.add(pa_North, BorderLayout.NORTH);
		//paCenter.add(sp, BorderLayout.CENTER);
		
		
		
		add(paCenter, BorderLayout.CENTER);
		
		
		setLayout(new FlowLayout());
		setTitle("Label Example");
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		// (클래스)e.getSource(); 해당 객체의 정보를 넘긴다.
		JButton btn = (JButton) e.getSource();
		if (btn == btnD_R)
			System.out.println("");
		else if (btn == btnExit)
			System.exit(0);
		else if (btn == btnM_R)
			System.out.println("");
			

	}

	public static void main(String[] args) {
		MainGui f = new MainGui();
	
	}

}