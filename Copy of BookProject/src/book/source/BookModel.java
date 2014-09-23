package book.source;



public interface BookModel {
	
	/**Book model state change listener registration methods*/
	public void addChangeListener(BookView view) throws BookException;
	
	//Customer segment state change methods
	/**Adds the Book to the Book model*/
	public void addBook(Book cust) throws BookException;
	
	/**Deletes the customer*/
	public void deleteBook(Book cust) throws BookException;
	
	/**Update */
	public void updateBook(Book cust) throws BookException;
	
	/***/
	public Book getBook(String id) throws BookException;
	
	/***/
	public Book[] getAllBooks() throws BookException;

	public Customer[] getAllCustomers() throws BookException;

}
