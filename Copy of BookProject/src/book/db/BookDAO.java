package book.db;
import book.source.Book;
import book.source.BookException;


public interface BookDAO {
	
	/**�� ���� �� ������ �߰��ϴ� ����� ����*/
	void createBook(Book book) throws BookException;

	/**������ �� ������ �����ϴ� ����� ����*/
	void removeBook(Book book)throws BookException;

	/**������ �� ������ �����ϴ� ����� ����*/
	void changeBookInfo(Book book)throws BookException;
	
	/**ssn ������ ����� �� ������ �˻��ϴ� ����� ����*/
	Book getBook(String ssn)throws BookException;

	/**��� �� ������ ��ȸ�ϴ� ����� ����*/
	Book[] getAllBooks()throws BookException;

	/**�־��� ssn ������ �ش��ϴ� ���� �����ϴ��� ���θ� Ȯ���ϴ� ����� ����*/
	boolean bnExists(String ssn);

	//Customer[] getAllCustomers() throws BookException;

}
