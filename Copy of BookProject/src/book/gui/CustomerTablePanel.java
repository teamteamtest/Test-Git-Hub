package book.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import book.source.Book;
import book.source.BookController;
import book.source.BookModel;
import book.source.Customer;

public class CustomerTablePanel implements BookPanel {

	 BookModel model;
	 BookController controller;
	   
	 protected JPanel paAllBookList = new JPanel();
	 protected JLabel allStockLb = new JLabel("회원 관리", SwingConstants.CENTER);
	 String[] tableHeaders = { "회원No", "이  름", "H.P.","주  소"};    
	 DefaultTableModel tableModel;
	 JTable table;
	 JScrollPane tablePane;
	    
	 public CustomerTablePanel(BookModel model){
		 this.model = model;
		 buildAllCustPanel();
	     refresh();
	 }
	 
	 public CustomerTablePanel() {
		
	}

	void buildAllCustPanel() {
		 paAllBookList.setLayout(new BorderLayout());
		 paAllBookList.add(allStockLb, BorderLayout.NORTH);
	     tableModel = new DefaultTableModel(tableHeaders, 5);
	     table = new JTable(tableModel);

	     tablePane = new JScrollPane(table);
	     paAllBookList.add(new AddCustomer(), BorderLayout.NORTH);
	     paAllBookList.add(new BookSearch(),BorderLayout.SOUTH);
	     paAllBookList.add(tablePane, BorderLayout.CENTER);

	     Dimension dim = new Dimension(500, 150);
	     table.setPreferredScrollableViewportSize(dim);
	    }

	@Override
	public void registerController(BookController controller) {
		 this.controller = controller;
	}

	@Override
	public void display(Object obj) {
		  if (obj instanceof Book[]) {
	            refreshAllCustPan((Customer[]) obj);
	        }

	}

	@Override
	public void refresh() {
		   try {
	            Customer[] customer = model.getAllCustomers();
	            refreshAllCustPan(customer);
	        } catch (Exception e) {
	            System.out.println(e.toString());
	        }
	    }

	@Override
	public JPanel getPanel() {
		
		return paAllBookList;
	}
	
	 void refreshAllCustPan(Customer[] customer) {
	       String[][] newData = new String[customer.length][4];
	    for(int i=0; i< newData.length; i++){
				newData[i][0] = String.valueOf(customer[i].getId());
				newData[i][1] = customer[i].getName();
				newData[i][2] = customer[i].getPhone();
				newData[i][3] = customer[i].getAddr();
				
			}
			tableModel.setDataVector(newData, tableHeaders);

	    }
}
