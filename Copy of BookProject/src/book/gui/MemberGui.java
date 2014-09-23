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
	private String[] grade = {"�Ϲ�ȸ��", "���ȸ��","VIPȸ��"};
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
		
		lbId = new JLabel("ȸ��ID");
		lbName = new JLabel("��  ��");
		lbAddr = new JLabel("��  ��");
		lbPhone = new JLabel("��  ȭ");
		lbGrade = new JLabel("ȸ�����");
		lbAddDate = new JLabel("������");
		
		tfId = new JTextField(15);
		tfName = new JTextField(25);
		tfAddr = new JTextField(25);
		tfPhone = new JTextField(25);
		tfAddDate = new JTextField(25);
		
		btnSearch = new JButton("�˻�");
		btnAdd = new JButton("���");
		btnUpdate = new JButton("����");
		btnDelete = new JButton("����");
		
		panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		
	}
	
	public void launchFrame(){
		setLayout(new BorderLayout());
		//North�κ�
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

		//East�κ�
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
