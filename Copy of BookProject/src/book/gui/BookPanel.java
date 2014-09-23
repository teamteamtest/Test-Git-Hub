package book.gui;

import javax.swing.*;

import book.source.BookController;

public interface BookPanel {

    void registerController(BookController controller);

    /**그 객체의 상태정보를 표시해줌*/
    void display(Object obj);

    void refresh();

    JPanel getPanel();
    
}
