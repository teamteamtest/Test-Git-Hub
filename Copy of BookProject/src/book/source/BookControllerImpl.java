package book.source;

public class BookControllerImpl implements BookController {

    private BookModel bookModel;
    private BookView bookView;

    /** Creates new BrokerControllerImpl */
    public BookControllerImpl(BookModel model, BookView view) {
        try {
            //** 1 Assign model to brokerModel
        	this.bookModel = model;

            //** 2 Assign view to brokerView
        	this.bookView = view;

            //** 3 Register this object as a user gesture listener with the brokerView object
            //**   Hint - invoke addUserGestureListener
        	bookView.addUserGestureListener(this);;
        	
            
        } catch (Exception e) {
            reportException(e);
        }
    }

    private void reportException(Object o) {
        // The responsibility of this method is to report exceptions
        try {
            bookView.showDisplay(o);
        } catch (Exception e) {
            System.out.println("BrokerControllerImpl reportException " + e);
        }
    }

    //user gesture call back methods
    /** get customer user gesture handle method called by the broker view */
    public void handleGetBook(String id) {
        System.out.println("handleGetCustomerGesture " + id);
        Book cust = null;
        try {

        	cust = bookModel.getBook(id);
bookView.showDisplay(cust);
            
        } catch (Exception e) {
            reportException(e);
        }
    }

    /** add new customer user gesture handle method called by the broker view */
    public void handleAddBook(Book book) {
        System.out.println("handleAddCustomerGesture " + book);
        try {
          bookModel.addBook(book);
            
        } catch (Exception e) {
            reportException(e);
        }
    }

    /** delete customer user gesture  handle method called by the broker view */
    public void handleDeleteBook(Book cust) {
        System.out.println("handleDeleteCustomerGesture " + cust);
        try {
         bookModel.deleteBook(cust);
            
        } catch (Exception e) {
            reportException(e);
        }
    }

    /** update customer user gesture callback method called by the broker view */
    public void handleUpdateBook(Book cust) {
        System.out.println("handleUpdateCustomerGesture " + cust);
        try {
          bookModel.updateBook(cust);
            
        } catch (Exception e) {
            reportException(e);
        }
    }

    /** get all customers user gesture callback method called the broker view */
    public void handleGetAllBook() {
        System.out.println("handleGetAllCustomersGesture ");
        Book[] custs;
        try {
           custs = bookModel.getAllBooks();

           bookView.showDisplay(custs);
            
        } catch (Exception e) {
            reportException(e);
        }
    }

	/*@Override
	public void handleGetAllStocksGesture() {
		System.out.println("handleGetAllStock");
		Stock[] stocks;
		try{
			stocks = bookModel.getAllStocks();
			bookView.showDisplay(stocks);
		}catch(BrokerException e){
			reportException(e);
		}
		
		
	}*/
}
