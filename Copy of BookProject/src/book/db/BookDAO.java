package book.db;
import book.source.Book;
import book.source.BookException;


public interface BookDAO {
	
	/**한 명의 고객 정보를 추가하는 기능을 수행*/
	void createBook(Book book) throws BookException;

	/**기존의 고객 정보를 삭제하는 기능을 수행*/
	void removeBook(Book book)throws BookException;

	/**기존의 고객 정보를 수정하는 기능을 수행*/
	void changeBookInfo(Book book)throws BookException;
	
	/**ssn 정보를 사용해 고객 정보를 검색하는 기능을 수행*/
	Book getBook(String ssn)throws BookException;

	/**모든 고객 정보를 조회하는 기능을 수행*/
	Book[] getAllBooks()throws BookException;

	/**주어진 ssn 정보에 해당하는 고객이 존재하는지 여부를 확인하는 기능을 수행*/
	boolean bnExists(String ssn);

	//Customer[] getAllCustomers() throws BookException;

}
