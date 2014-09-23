package book.gui;

import javax.swing.*;

import book.source.BookController;

public interface BookPanel {

    void registerController(BookController controller);

    /**�� ��ü�� ���������� ǥ������*/
    void display(Object obj);

    void refresh();

    JPanel getPanel();
    
}
