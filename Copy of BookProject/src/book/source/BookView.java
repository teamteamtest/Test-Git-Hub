package book.source;



public interface BookView {
	
	void addUserGestureListener(BookController con) throws BookException;
	
	void showDisplay(Object display) throws BookException;
	
	void handleCustomerChange(Book cust) throws BookException;

}
