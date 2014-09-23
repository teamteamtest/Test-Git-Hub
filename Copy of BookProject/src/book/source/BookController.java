package book.source;



public interface BookController {
	
	void handleGetBook(String id);
	void handleAddBook(Book cust);
	void handleDeleteBook(Book cust);
	void handleUpdateBook(Book cust);	
	void handleGetAllBook();
	//void handleGetAllStocksGesture();

}
