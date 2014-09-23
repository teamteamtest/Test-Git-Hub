package book.source;

import javax.swing.*;

public interface BrokerPanel {

    void registerController(BookController controller);

    /**그 객체의 상태정보를 표시해줌*/
    void display(Object obj);

    void refresh();

    JPanel getPanel();
    
}
