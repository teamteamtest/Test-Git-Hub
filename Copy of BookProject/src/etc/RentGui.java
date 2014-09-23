package etc;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class RentGui extends JFrame{
	
	
	private JLabel lbName, lbAddr, lbPhone, lbGrade, lbDvdId;
	private String[] colName= {"번호","제목","감독","공급사","장르","대여일","반납일"};
	private DefaultTableMode tableModel;
	private JTabel taRent;
	private JScrollPane sp;
	private JButton btnRent;
	private JPanel paNorth, paCenter, paSouth;
	
	public RentGui(){
		lbName = new JLabel("이  름");
		lbAddr = new JLabel("주  소");
		lbPhone = new JLabel("전  화");
		lbGrade = new JLabel("회원등급");
		lbDvdId = new JLabel("DVD번호");
		
		btnRent = new JButton("대여/반납처리");
		
		
		//tableModel = new DefaultTableModel(colName, 0);
		//taRent = new JTable(tableModel);
		//sp = new JScrollPane(taMember);
	}
	
	public void launchFrame(){
		
		paNorth.setBorder(new TitledBorder(null, "회원 정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
	}
	
	

}
