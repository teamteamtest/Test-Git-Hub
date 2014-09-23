package formatter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatsTest {
	public void numberFormatTest() {
		NumberFormat formatter = NumberFormat.getInstance();
		String str = formatter.format(1234567890.123456789);
		System.out.println("getInstance() :\t" + str);
		
		formatter = NumberFormat.getCurrencyInstance();
		str = formatter.format(1234567890.123456789);
		System.out.println("Currency : \t" + str);
		
		formatter = NumberFormat.getIntegerInstance();
		str = formatter.format(1234567890.123456789);
		System.out.println("Integer : \t\t" + str);

		formatter = NumberFormat.getPercentInstance();
		str = formatter.format(1234567890.123456789);
		System.out.println("Percent : \t\t" + str);
	}

	public void decimalFormatTest() {
		double num = 123456789.123456789;
		String pattern1 = "#####,###0.0########";
		String pattern2 = "000000,0000.0000000000";
		String pattern3 = "'/'000,00.0000+E;\u00A4000,00.0000\u2030";
		
		/**<<�����ڵ� ��������>>
		 * \u00A4 : ��ȭ���� ( �� )
		 * \u2030 : �۹�ǥ�� (  ��  )
		 * ; : ����϶��� �����϶� ������ �������ִ� ����  (----;***** : ---[�������], *****[��������])*/
		
		DecimalFormat formatter = new DecimalFormat();
		formatter.applyPattern(pattern1);
		String str = formatter.format(num);
		System.out.println(pattern1 + " => " + str);
		
		formatter.applyPattern(pattern2);
		str = formatter.format(num);
		System.out.println(pattern2 + " => " + str);
		
		formatter.applyPattern(pattern3);
		str = formatter.format(12345.6789);
		System.out.println(pattern3 + " => " + str);
		str = formatter.format(-12345.6789);
		System.out.println(pattern3 + " => " + str);
	}

	public void dateFormatTest() {
		Date currentDate = new Date();
		Format dateFormat = DateFormat.getInstance();
		System.out.println("Date_Time :\t" + dateFormat.format(currentDate) + "\n");
		for(int i = 0; i<3;i++) {
			switch (i) {
			case 0:
				/** <<��� ���>>
				 * Date_Full :	2014�� 7�� 31�� �����
				 * Date_Long :	2014�� 7�� 31�� (��)
				 * Date_Medium :	2014. 7. 31
				 * Date_Short :	14. 7. 31
				 * */
				
				dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
				System.out.println("Date_Full :\t" + dateFormat.format(currentDate));
				dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
				System.out.println("Date_Long :\t" + dateFormat.format(currentDate));
				dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
				System.out.println("Date_Medium :\t" + dateFormat.format(currentDate));
				dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
				System.out.println("Date_Short :\t" + dateFormat.format(currentDate) + "\n");
				break;
			case 1:
				/** <<��°��>>
				 * Time_Full :	���� 10�� 59�� 49�� KST
				 * Time_Long :	���� 10�� 59�� 49��
				 * Time_Medium :	���� 10:59:49
				 * Time_Short :	���� 10:59
				 * 
				 * */
				
				dateFormat = DateFormat.getTimeInstance(DateFormat.FULL);
				System.out.println("Time_Full :\t" + dateFormat.format(currentDate));
				dateFormat = DateFormat.getTimeInstance(DateFormat.LONG);
				System.out.println("Time_Long :\t" + dateFormat.format(currentDate));
				dateFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM);
				System.out.println("Time_Medium :\t" + dateFormat.format(currentDate));
				dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT);
				System.out.println("Time_Short :\t" + dateFormat.format(currentDate) + "\n");
				break;
			case 2:
				dateFormat = DateFormat.getDateTimeInstance();
				System.out.println("Date_Time :\t" + dateFormat.format(currentDate));
				break;
			}
		}
	}

	public void simpleDateFormatTest() {
		Date date = new Date();
		/** M : 7, MM : 07, MMM : 7��
		 * yyyy : 2014, yy : 14 (��/�ҹ��� ��� ����)
		 * dd : 30 (���� ���)
		 * EEE : �� , EEEE : �����*/
		
		String pattern = "YYYY/MMM/dd EEE EEEE hh:mm";
		SimpleDateFormat formatter = new SimpleDateFormat();
		formatter.applyPattern(pattern);
		SimpleDateFormat Localeformatter = new SimpleDateFormat(pattern, Locale.US);  //Locale.���� : �� ������ ���� ��Ÿ��
		System.out.println(pattern + "\n" + formatter.format(date));
		System.out.println(pattern + "\n" + Localeformatter.format(date));
	}

	public void messageFormatTest() {
		Date date = new Date();
		String name = "�̽���";
		int price = 50000;
		
		/** << ��  ��  >>
		 * {���ϴ������� ������ argument�� ����(0����), FormatType , FormatStyle}
		 * FormatType : number, date, time
		 * fromat( ) �� static �̶� new ���� ����� �����ϴ�
		 * {0}���� date���� , {1}���� name ����, {2}���� price���� ����.*/
		
		String format="{0, date, full} / {1}���� �����Ͻ� �Ѿ��� {2, number, #,###.00��} �Դϴ�.";
		System.out.println(MessageFormat.format(format, date, name, price));

	}

	public static void main(String[] args) {
		FormatsTest ft = new FormatsTest();
		//ft.numberFormatTest();
		//ft.decimalFormatTest();
		//ft.dateFormatTest();
		//ft.simpleDateFormatTest();
		ft.messageFormatTest();
	}
}
