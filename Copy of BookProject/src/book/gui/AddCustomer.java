package book.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCustomer extends JPanel {
	public AddCustomer() {
		//setDefaultCloseOperation(AddCustomer.CROSSHAIR_CURSOR);
		//setTitle("회원 등록");
		setSize(350, 150);
//		setLocation(500, 400);

		JPanel custPan = new JPanel();
		JPanel custPan2 = new JPanel();

		custPan.setLayout(new GridLayout(4, 2));
		JTextField idTf = new JTextField(15);
		JTextField nameTf = new JTextField(15);
		JTextField addrTf = new JTextField(15);
		JTextField telTf = new JTextField(15);

		custPan.add(new JLabel("ID"));
		custPan.add(idTf);
		custPan.add(new JLabel("이름"));
		custPan.add(nameTf);
		custPan.add(new JLabel("주소"));
		custPan.add(addrTf);
		custPan.add(new JLabel("전화번호"));
		custPan.add(telTf);

		add(custPan, BorderLayout.CENTER);

		custPan2.setLayout(new GridLayout(1, 4));
		JButton addBt = new JButton("검색");
		JButton searchBt = new JButton("저장");
		JButton upBt = new JButton("수정");
		JButton delBt = new JButton("삭제");

		custPan2.add(addBt);
		custPan2.add(searchBt);
		custPan2.add(upBt);
		custPan2.add(delBt);

		add(custPan2, BorderLayout.SOUTH);

		setVisible(true);
	}

	//public static void main(String[] args) {
		//JFrame frame = new AddCustomer();
//	}

}
