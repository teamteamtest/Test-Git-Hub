package etc;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class RentGui extends JFrame{
	
	
	private JLabel lbName, lbAddr, lbPhone, lbGrade, lbDvdId;
	private String[] colName= {"��ȣ","����","����","���޻�","�帣","�뿩��","�ݳ���"};
	private DefaultTableMode tableModel;
	private JTabel taRent;
	private JScrollPane sp;
	private JButton btnRent;
	private JPanel paNorth, paCenter, paSouth;
	
	public RentGui(){
		lbName = new JLabel("��  ��");
		lbAddr = new JLabel("��  ��");
		lbPhone = new JLabel("��  ȭ");
		lbGrade = new JLabel("ȸ�����");
		lbDvdId = new JLabel("DVD��ȣ");
		
		btnRent = new JButton("�뿩/�ݳ�ó��");
		
		
		//tableModel = new DefaultTableModel(colName, 0);
		//taRent = new JTable(tableModel);
		//sp = new JScrollPane(taMember);
	}
	
	public void launchFrame(){
		
		paNorth.setBorder(new TitledBorder(null, "ȸ�� ����", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
	}
	
	

}
