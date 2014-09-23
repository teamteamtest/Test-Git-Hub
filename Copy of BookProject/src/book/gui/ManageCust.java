package book.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManageCust extends JFrame {
	public ManageCust() {
		setDefaultCloseOperation(ManageCust.CROSSHAIR_CURSOR);
		setTitle("ȸ�� ���");
		setSize(500, 200);
		setLocation(400, 400);

		JPanel custPan = new JPanel();
		JPanel custPan2 = new JPanel();

		custPan.setLayout(new GridLayout(4, 2));
		JTextField idTf = new JTextField(15);
		JTextField nameTf = new JTextField(15);
		JTextField addrTf = new JTextField(15);
		JTextField telTf = new JTextField(15);

		custPan.add(new JLabel("ID"));
		custPan.add(idTf);
		custPan.add(new JLabel("�̸�"));
		custPan.add(nameTf);
		custPan.add(new JLabel("�ּ�"));
		custPan.add(addrTf);
		custPan.add(new JLabel("��ȭ��ȣ"));
		custPan.add(telTf);

		add(custPan, BorderLayout.CENTER);

		custPan2.setLayout(new GridLayout(1, 3));
		JButton addBt = new JButton("����");
		JButton upBt = new JButton("����");
		JButton delBt = new JButton("����");

		custPan2.add(addBt);
		custPan2.add(upBt);
		custPan2.add(delBt);

		add(custPan2, BorderLayout.SOUTH);

		setVisible(true);
	}

	public static void main(String[] args) {
		JFrame frame = new ManageCust();
	}

}
