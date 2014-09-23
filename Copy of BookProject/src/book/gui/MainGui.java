package book.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import book.db.BookModelImpl;
import book.source.Book;
import book.source.BookController;
import book.source.BookModel;
import book.source.Customer;

public class MainGui extends JFrame implements ActionListener {
	private BookController bookController;
	private BookModel model;
	private JPanel p;
	private JPanel paNorth, paWest, paCenter;
	private JPanel pa_North, pa_Center;
	private JButton btnRent, btnReturn, btnRentList, btnBookManager,
			btnMemberManager, btnExit;
	private JLabel lbBookSearch, lbSubject;
	private JTextField tfbookName;
	private JButton btnSearch;
	private JComboBox cbIf;
	String searchIf[] = { "도서명", "출판사", "저자명" }; // ComboBox를 위한 배열 선언
	String column[] = { "책NO", "도서명", "출판사", "저자", "대여상태" };
	private JPanel pa;
	private JTable taList;
	private JScrollPane spList;
	private CardLayout card;
	protected JPanel cardPan;
	private BrokerPanel[] panels = new BrokerPanel[5];

	BookTablePanel btp = new BookTablePanel(model);
	JoinCustPanel jcp = new JoinCustPanel(model);
	BookRentList bk = new BookRentList(model);
	BookManage bm = new BookManage(model);

	public MainGui(BookModel model) {
		this.model = model;
		init();
	}

	public void addController(BookController controller) {
		bookController = controller;
		for (int i = 0; panels[i] != null; i++) {
			panels[i].registerController(bookController);
		}
	}

	public MainGui() {
		setTitle("도서관리 프로그램");
		cardPan = new JPanel();

		p = new JPanel();
		pa_North = new JPanel(new BorderLayout());
		pa_Center = new JPanel();
		paNorth = new JPanel();
		paWest = new JPanel(new GridLayout(2, 1));
		paCenter = new JPanel();

		lbBookSearch = new JLabel("");
		lbSubject = new JLabel("BOOK MANAGER PROGRAM");

		btnRent = new JButton("대여");
		btnReturn = new JButton("반납");
		btnRentList = new JButton("대여목록");
		btnBookManager = new JButton("도서관리");
		btnMemberManager = new JButton("회원관리");
		btnExit = new JButton("종료");
		btnSearch = new JButton("검색");

		tfbookName = new JTextField(15);

		cbIf = new JComboBox<String>(searchIf);
		pa = new JPanel();
		card = new CardLayout();
	}

	public void init() {

		p.setBackground(Color.orange);
		card.addLayoutComponent("1", p);

		cardPan.setLayout(card);

		cardPan.add("1", p);
		cardPan.add("2", panels[0].getPanel());
		cardPan.add("3", panels[1].getPanel());
		cardPan.add("4", panels[2].getPanel());
		cardPan.add("5", panels[3].getPanel());

		/*
		 * cardPane.add("2", mj); cardPane.add("3", ll);
		 */

		setLayout(new BorderLayout());
		Font font = new Font("Courier New", Font.BOLD, 40);
		lbSubject.setFont(font);
		paNorth.add(lbSubject);
		this.add(paNorth, BorderLayout.NORTH);

		this.add(cardPan, BorderLayout.EAST);
		// this.add(spList, BorderLayout.EAST);

		pa.setLayout(new GridLayout(2, 1));
		pa_North.setLayout(new GridLayout(3, 1, 5, 5));

		pa_North.setBorder(new TitledBorder(null, "도서 검색",

		TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pa_North.add(cbIf);
		pa_North.add(tfbookName);
		pa_North.add(btnSearch);
		pa.add(pa_North);
		paWest.add(pa);

		pa_Center.setLayout(new GridLayout(6, 5, 5, 5));
		pa_Center.add(btnRent);
		pa_Center.add(btnReturn);
		pa_Center.add(btnRentList);
		pa_Center.add(btnBookManager);
		pa_Center.add(btnMemberManager);
		pa_Center.add(btnExit);
		paWest.add(pa_Center);

		btnBookManager.addActionListener(this);

		this.add(paWest, BorderLayout.WEST);
		this.add(paCenter);

		btnRent.addActionListener(this);
		btnReturn.addActionListener(this);
		btnRentList.addActionListener(this);
		btnBookManager.addActionListener(this);
		btnMemberManager.addActionListener(this);
		btnExit.addActionListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(800, 700);
		setLocation(150, 200);
		setVisible(true);

	}
	 private void addCardView(String label, JPanel panel) {
	 cardPan.add(panel, label);
	 JButton newButton = new JButton(label);
	 selPan.add(newButton);
	 newButton.addActionListener(selectionPanListener);
	 }
	
	 private ActionListener selectionPanListener = new ActionListener() {
	 String buttonName;
	
	 public void actionPerformed(ActionEvent e) {
	 buttonName = e.getActionCommand();
	 System.out.println("SelectionPanelListener buttonName = " + buttonName);
	 card.show(cardPan, buttonName);
	 }
	 };
	 
	public static void main(String[] args) throws Exception {

		BookModelImpl model = new book.db.BookModelImpl(
				new book.db.BookDAOImpl());
		MainGui gui = new MainGui(model);
	}
	
	public void displayObject(Object obj) {
		if (obj instanceof Book) {
			panels[0].display(obj);
			panels[1].refresh();
		}
		if (obj instanceof Customer[]) {
			panels[1].display(obj);
		}

	}
	
//	public void displayObject(Object display) {
//		Object obj = e.getSource();
//
//		if (obj == btnBookManager) {
//			card.show(cardPan, "5");
//		} else if (obj == btnRent) {
//			card.show(cardPan, "2");
//		} else if (obj == btnReturn) {
//
//		} else if (obj == btnRentList) {
//			card.show(cardPan, "4");
//		} else if (obj == btnMemberManager) {
//			card.show(cardPan, "3");
//
//		} else if (obj == btnExit) {
//			System.exit(0);
//		}
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
