package book.db;


import java.util.ArrayList;

import book.source.Book;
import book.source.BookException;
import book.source.BookModel;
import book.source.BookView;
import book.source.Customer;

public class BookModelImpl implements BookModel {
	ArrayList<BookView> changeListeners = new ArrayList<BookView>(10);
	BookDAO bookDAO;

	/** Creates a new instance of BrokerModelImpl */
	public BookModelImpl(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public void addChangeListener(BookView view) throws BookException {
		changeListeners.add(view);
	}

	/**
	 * ----------------------------------------------------------- This method
	 * notifies all registered BrokerView listeners that a customer object has
	 * changed.
	 */
	private void fireModelChangeEvent(Book cust) {
		for (BookView view : changeListeners) {
			try {
				view.handleCustomerChange(cust);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Customer segment state change methods
	/**
	 * ---------------------------------------------------------- Adds the
	 * Customer to the broker model
	 */
	public void addBook(Book cust) throws BookException {
		if (bookDAO.bnExists(cust.getBookName())
				&& bookDAO.bnExists(cust.getPublisher())) {
			throw new BookException("Duplicate Name & Publisher : "
					+ cust.getBookName());
		}
		try {
			bookDAO.createBook(cust);
			this.fireModelChangeEvent(cust);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BookException("BrokerModelImpl.addCustomer\n" + e);
		}
	}

	/**
	 * ------------------------------------------------------------- Deletes the
	 * customer from the broker model
	 */
	public void deleteBook(Book cust) throws BookException {

		if (!(bookDAO.bnExists(cust.getBookName()) && bookDAO.bnExists(cust
				.getPublisher()))) {
			throw new BookException("Record for Name&Publisher "
					+ cust.getBookName() + " not found ");
		}

		try {

			bookDAO.removeBook(cust);
			cust.setBookName("- bookInfo deleted -");

			this.fireModelChangeEvent(cust);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BookException("BrokerModelImpl.deleteCustomer\n" + e);
		}
	}

	/**
	 * ------------------------------------------------------------- Updates the
	 * customer in the broker model
	 */
	public void updateBook(Book cust) throws BookException {
		if (!(bookDAO.bnExists(cust.getBookName()) && bookDAO.bnExists(cust
				.getPublisher()))) {
			throw new BookException("Record for Name&Publisher"
					+ cust.getBookName() + "( " + cust.getPublisher()
					+ ") not found ");
		}
		try {
			bookDAO.changeBookInfo(cust);

			this.fireModelChangeEvent(cust);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BookException("BrokerModelImpl.updateCustomer\n" + e);
		}
	}

	public Book getBook(String id) throws BookException {
		Book cust = null;
		try {
			cust = bookDAO.getBook(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BookException("BrokerModelImpl.getBook\n" + e);
		}

		if (cust == null) {
			throw new BookException("Record for Id " + id + " not found");
		}
		return cust;
	}

	/**
	 * ------------------------------------------------------------- Returns all
	 * customers in the broker model
	 */
	public Book[] getAllBooks() throws BookException {
		Book[] all = null;
		try {
			all = bookDAO.getAllBooks();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BookException("BrokerModelImpl.getAllBooks\n" + e);
		}
		return all;
	}

	@Override
	public Customer[] getAllCustomers() throws BookException {
		// TODO Auto-generated method stub
		return null;
	}
}
