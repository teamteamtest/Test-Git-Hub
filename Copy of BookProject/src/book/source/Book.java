package book.source;


import java.io.Serializable;

public class Book implements Serializable{
	private int bookId;
	private String bookName;
	private String publisher;
	private String author;
	private String rentState;
	
	
	public Book(int bookId){
		this.bookId = bookId;
	}
	
	public Book(int id, String bookName, String publisher, String author,
			String rentState) {
		this.bookId = id;
		this.bookName = bookName;
		this.publisher = publisher;
		this.author = author;
		this.rentState = rentState;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getRentState() {
		return rentState;
	}


	public void setRentState(String rentState) {
		this.rentState = rentState;
	}

	@Override
	public String toString(){
		return "BookInfo [" + bookId + "," + bookName + ", " + publisher+", "+author+", "+rentState+"]";
		
	}
	
}

