package book.source;

import book.gui.MainGui;

public class BookViewImpl implements BookView{

    private MainGui gui;
    private BookModel brokerModel;
    private BookController brokerController;

    /** Creates a new instance of BrokerViewImpl */
    public BookViewImpl(BookModel model) {
        System.out.println("Creating BrokerViewImpl");
        try {
            //** 1 Assign model to the attribute brokerModel
        	this.brokerModel = model;
            
            //** 2 Invoke the addChangeListener method of the model with this instance
        	model.addChangeListener(this);
        	
        } catch (Exception e) {
            System.out.println("BrokerViewImpl constructor " + e);
        }
        gui = new MainGui(model);
    }


    public void addUserGestureListener(BookController con) throws BookException {
        System.out.println("BrokerViewImpl.addUserGestureListener " + con);
        this.brokerController = con;
        gui.addController(con);

    }

    //display selection request service methods
    public void showDisplay(Object display) throws BookException {
        System.out.println("BrokerViewImpl.showDisplay " + display);
        gui.displayObject(display);

    }

    public void handleCustomerChange(Book book) throws BookException {
        System.out.println("BrokerViewImpl.processCustomer " + book);
        gui.displayObject(book);

    }
}
