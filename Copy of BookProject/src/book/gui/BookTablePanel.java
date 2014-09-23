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

public class BookTablePanel implements BrokerPanel {

    BookModel model;
    BookController controller;
      
    protected JPanel paAllBookList = new JPanel();
    protected JLabel allStockLb = new JLabel("도서 관리", SwingConstants.CENTER);
    String[] tableHeaders = { "책No", "도서명", "출판사","저자","대여상태"};    
    DefaultTableModel tableModel;
    JTable table;
    JScrollPane tablePane;
       
    public BookTablePanel(BookModel model){
       this.model = model;
       buildAllCustPanel();
        refresh();
    }
    
    public BookTablePanel() {
      
   }

   void buildAllCustPanel() {
       paAllBookList.setLayout(new BorderLayout());
       paAllBookList.add(allStockLb, BorderLayout.NORTH);
        tableModel = new DefaultTableModel(tableHeaders, 5);
        table = new JTable(tableModel);

        tablePane = new JScrollPane(table);
        paAllBookList.add(new SearchCust(), BorderLayout.NORTH);
        paAllBookList.add(new BookRent(),BorderLayout.SOUTH);
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
               refreshAllCustPan((Book[])obj);
           }

   }

   @Override
   public void refresh() {
         try {
               Book[] book = model.getAllBooks();
               refreshAllCustPan(book);
           } catch (Exception e) {
               System.out.println(e.toString());
           }
       }

   @Override
   public JPanel getPanel() {
      
      return paAllBookList;
   }
   
    void refreshAllCustPan(Book[] book) {
          String[][] newData = new String[book.length][5];
       for(int i=0; i< newData.length; i++){
            newData[i][0] = String.valueOf(book[i].getBookId());
            newData[i][1] = book[i].getBookName();
            newData[i][2] = book[i].getPublisher();
            newData[i][3] = book[i].getAuthor();
            newData[i][4] = book[i].getRentState();
            
         }
         tableModel.setDataVector(newData, tableHeaders);

       }
}