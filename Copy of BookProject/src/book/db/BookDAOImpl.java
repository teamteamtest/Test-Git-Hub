package book.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.source.Book;
import book.source.BookException;

public class BookDAOImpl implements BookDAO {
   private Connection theConnection;

   public BookDAOImpl() throws Exception {
      this("localhost");
   }

   public BookDAOImpl(String hostName) throws Exception {
      // String databaseName = "StockMarket";
      String user = "sku";
      String password = "sku";
      String url;
      try {
         Class.forName("oracle.jdbc.OracleDriver");
         url = "jdbc:oracle:thin:@" + hostName + ":1521:xe";
         theConnection = DriverManager.getConnection(url, user, password);
      } catch (Exception e) {
         e.printStackTrace();
         throw e;
      }
   }

   protected Connection obtainConnection() throws SQLException {
      return theConnection;
   }

   public boolean bnExists(String book) {
      PreparedStatement stmt;
      try {
         String query = ("SELECT book_num FROM BOOK_INFO WHERE book_num="+ "'" + book + "'");
         Connection con = obtainConnection();
         stmt = con.prepareStatement(query);
         ResultSet result = stmt.executeQuery();
         return result.next();
      } catch (SQLException e) {
         e.printStackTrace();
         return false;
      }
   }

   @Override
   public void createBook(Book book) throws BookException {
      // TODO Auto-generated method stub

   }

   @Override
   public void removeBook(Book book) throws BookException {
      // TODO Auto-generated method stub
      try {
         int id;
         Connection con;
         PreparedStatement stmt = null;
         String request;

         id = book.getBookId();
         con = obtainConnection();
         // request = "DELETE FROM Shares WHERE ssn=id";
         // stmt = con.prepareStatement(request);
         // stmt.executeUpdate();

         request = "DELETE FROM BOOK_INFO WHERE book_num=" + "'" + id + "'";
         stmt = con.prepareStatement(request);
         stmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
         throw new BookException("BrokerDAOImpl.removeBook\n" + e);
      }
   }

   @Override
   public void changeBookInfo(Book book) throws BookException {
      // TODO Auto-generated method stub

      try {
         int id ;
         String name = null;
         String pub = null;
         String aut = null;
         String rent = null;
         Connection con;
         PreparedStatement stmt;
         String request;

         id = book.getBookId();
         name = book.getBookName();
         pub = book.getPublisher();
         aut = book.getAuthor();
         rent = book.getRentState();

         con = obtainConnection();

         request = "UPDATE BOOK_INFO SET " + " id=" + "'" + id + "'" + ","
               + "book name =" + "'" + name + "'" + "," + "publisher ="+ "'" + pub + "'" + "," + "author=" + aut + "'" + ","
               + "rentstate=" + rent + "'" + "," + " WHERE book_num="+ "'" + id + "'";

         stmt = con.prepareStatement(request);
         stmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
         throw new BookException("BrokerDAOImpl.changeBookInfo\n" + e);
      }
   }

   @Override
   public Book getBook(String book_num) throws BookException {
      try {
         int id = 0 ;
         String name = null;
         String pub = null;
         String aut = null;
         String rent = null;
         Book book = null;
         Connection con;
         PreparedStatement stmt;
         String request;

         con = obtainConnection();
         request = "SELECT book_num, book_name, publisher,writer,rent_state FROM BOOK_INFO WHERE book_num="+ "'" + id + "'";
         stmt = con.prepareStatement(request);
         ResultSet result = stmt.executeQuery();

         if (result.next()) {
            id = result.getInt("book_num");
            name = result.getString("book_name").trim();
            pub = result.getString("publisher").trim();
            aut = result.getString("address").trim();
            rent = result.getString("writer").trim();
            book = new Book(id, name, pub, aut, rent);
         }
         return book;
      } catch (SQLException e) {
         e.printStackTrace();
         throw new BookException("BrokerDAOImpl.getBook\n" + e);
      }
   }

   @Override
   public Book[] getAllBooks() throws BookException {
      int id =0;
      String name = null;
      String pub = null;
      String aut = null;
      String rent = null;
      Connection con;
      PreparedStatement stmt;
      ResultSet result = null;
      String request;
      Book book = null;
      Book[] allBook;

      ArrayList<Book> aList = new ArrayList<Book>();
      try {
         con = this.obtainConnection();
         request = "SELECT * FROM BOOK_INFO";
         stmt = con.prepareStatement(request);
         result = stmt.executeQuery();

         while (result.next()) {
            id = result.getInt(1);
            name = result.getString(2).trim();
            pub = result.getString(3).trim();
            aut = result.getString(4).trim();
            rent = result.getString(5).trim();

            book = new Book(id, name, pub, aut, rent);
            aList.add(book);
         }
         allBook = aList.toArray(new Book[0]);
         return allBook;
      } catch (SQLException e) {
         e.printStackTrace();
         throw new BookException("BrokerDAOImpl.getAllBooks\n" + e);
      }
   }

}