package book.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import book.source.BookController;
import book.source.BookModel;
import book.source.Customer;

public class BookManage implements BrokerPanel {

	 BookModel model;
	 BookController controller;
	   
	 protected JPanel allCustPan = new JPanel();
	 protected JLabel allCustLb = new JLabel("도서관리", SwingConstants.CENTER);
	 String[] tableHeaders = {"책No", "도서명", "출판사","저자","대여상태"};    
	 DefaultTableModel tableModel;
	 JTable table;
	 JScrollPane tablePane;
	    
	 public BookManage(BookModel model){
		 this.model = model;
		 buildAllCustPanel();
	     refresh();
	 }
	 
	 public BookManage() {
		
	}

	void buildAllCustPanel() {
		allCustPan.setLayout(new BorderLayout());
		allCustPan.add(allCustLb, BorderLayout.NORTH);
	     tableModel = new DefaultTableModel(tableHeaders, 5);
	     table = new JTable(tableModel);

	     tablePane = new JScrollPane(table);
	     allCustPan.add(new BookInfo(), BorderLayout.NORTH);
	     allCustPan.add(tablePane, BorderLayout.CENTER);

	     Dimension dim = new Dimension(500, 150);
	     table.setPreferredScrollableViewportSize(dim);
	    }

	@Override
	public void registerController(BookController controller) {
		 this.controller = controller;
	}

	@Override
	public void display(Object obj) {
		  if (obj instanceof Customer[]) {
	            refreshAllCustPan((Customer[])obj);
	        }

	}

	@Override
	public void refresh() {
		   try {
	            Customer[] cust = model.getAllCustomers();
	            refreshAllCustPan(cust);
	        } catch (Exception e) {
	            System.out.println(e.toString());
	        }
	    }

	@Override
	public JPanel getPanel() {
		
		return allCustPan;
	}
	
	 void refreshAllCustPan(Customer[] cust) {
	       String[][] newData = new String[cust.length][4];
	    for(int i=0; i< newData.length; i++){
				newData[i][0] = String.valueOf(cust[i].getId());;
				newData[i][1] = cust[i].getName();
				newData[i][2] = cust[i].getAddr();
				newData[i][3] = cust[i].getPhone();
				
				
			}
			tableModel.setDataVector(newData, tableHeaders);

	    }
}

