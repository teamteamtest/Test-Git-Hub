package book.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookInfo extends JPanel {
	public BookInfo() {
		// setDefaultCloseOperation(AddCustomer.CROSSHAIR_CURSOR);
		// setTitle("회원 등록");
		setSize(350, 150);
		// setLocation(500, 400);

		JPanel custPan = new JPanel();
		JPanel custPan2 = new JPanel();

		custPan.setLayout(new GridLayout(5, 2));
		JTextField bookIdTf = new JTextField(15);
		JTextField bookNameTf = new JTextField(15);
		JTextField publisherTf = new JTextField(15);
		JTextField authorTf = new JTextField(15);
		JTextField rentstateTf = new JTextField(15);

		custPan.add(new JLabel("책No"));
		custPan.add(bookIdTf);
		custPan.add(new JLabel("도서명"));
		custPan.add(bookNameTf);
		custPan.add(new JLabel("출판사"));
		custPan.add(publisherTf);
		custPan.add(new JLabel("저자"));
		custPan.add(authorTf);
		custPan.add(new JLabel("대여상태"));
		custPan.add(rentstateTf);

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

	// public static void main(String[] args) {
	// JFrame frame = new AddCustomer();
	// }

}
