package book.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.*;


public class MemberGui extends JFrame{
	private JLabel lbId, lbName, lbAddr, lbPhone, lbGrade, lbAddDate;
	private JTextField tfId, tfName, tfAddr, tfPhone, tfAddDate;
	private JComboBox cbGrade;
	private String[] grade = {"일반회원", "골드회원","VIP회원"};
	private JButton btnSearch, btnAdd, btnUpdate, btnDelete;
	private JPanel paNorth, paEast, paCenter;
	private JPanel pa1, pa2, pa3;
    private GridBagLayout gb ;
    private GridBagConstraints gc;
	private JPanel panel1, panel2, panel3;
    
	//setBorder(new TitledBorder( null));
	
	MemberGui(){
		cbGrade = new JComboBox();
		
		gb = new GridBagLayout();
		gc = new GridBagConstraints();  
		
		paNorth = new JPanel();
		paEast = new JPanel();
		paCenter = new JPanel();
		
		lbId = new JLabel("회원ID");
		lbName = new JLabel("이  름");
		lbAddr = new JLabel("주  소");
		lbPhone = new JLabel("전  화");
		lbGrade = new JLabel("회원등급");
		lbAddDate = new JLabel("가입일");
		
		tfId = new JTextField(15);
		tfName = new JTextField(25);
		tfAddr = new JTextField(25);
		tfPhone = new JTextField(25);
		tfAddDate = new JTextField(25);
		
		btnSearch = new JButton("검색");
		btnAdd = new JButton("등록");
		btnUpdate = new JButton("수정");
		btnDelete = new JButton("삭제");
		
		panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		
	}
	
	public void launchFrame(){
		setLayout(new BorderLayout());
		//North부분
		//paNorth.setLayout();
		paNorth.add(lbName);
		paNorth.add(tfName);
		paNorth.add(btnSearch);
		
		add(paNorth, BorderLayout.NORTH);
		
		paCenter.setLayout(new GridLayout(3,1));

	

		panel1.add(lbId);
		panel1.add(tfId);
		
		//paCenter.add(lbName);
		//paCenter.add(tfName);
		
		panel2.add(lbAddr);
		panel2.add(tfAddr);
		
		panel3.add(lbPhone);
		panel3.add(tfPhone);
		panel3.add(lbGrade);
		//paCenter.add(cbGrade);		
	/*	paCenter.add(lbAddDate);
		paCenter.add(tfAddDate);*/
		
		paCenter.add(panel1);
		paCenter.add(panel2);
		paCenter.add(panel3);
		add(paCenter, BorderLayout.CENTER);

		//East부분
		paEast.setLayout(new GridLayout(3,1));
		paEast.add(btnAdd);
		paEast.add(btnUpdate);
		paEast.add(btnDelete);
		
		add(paEast, BorderLayout.EAST);
		
		
		setTitle("Member Manager");
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	public static void main(String[] args){
		MemberGui g = new MemberGui();
		g.launchFrame();
	}
	

}
