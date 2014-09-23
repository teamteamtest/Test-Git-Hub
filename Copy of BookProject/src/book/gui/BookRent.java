package book.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import book.gui.*;

public class BookRent extends JPanel{
   public BookRent() {
      //setDefaultCloseOperation(AddCustomer.CROSSHAIR_CURSOR);
      //setTitle("회원 등록");
      setSize(300, 80);
      setLocation(500, 400);

      JPanel custPan = new JPanel();
      JPanel custPan2 = new JPanel();

      custPan.setLayout(new GridLayout(1, 3));
      custPan.add(new JLabel("도서 No"));
      JTextField rentTf = new JTextField(15);
      JButton rentBt = new JButton("대출");
      
      custPan.add(rentTf);
      custPan.add(rentBt);
      

      add(custPan, BorderLayout.CENTER);


      setVisible(true);
   }

//   public static void main(String[] args) {
//      JFrame frame = new BookRent();
//   }
}