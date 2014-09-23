package book.source;

import javax.swing.*;

public interface BrokerPanel {

    void registerController(BookController controller);

    /**�� ��ü�� ���������� ǥ������*/
    void display(Object obj);

    void refresh();

    JPanel getPanel();
    
}
