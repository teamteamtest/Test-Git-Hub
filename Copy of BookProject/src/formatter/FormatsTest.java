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
		
		/**<<유니코드 문자형식>>
		 * \u00A4 : 통화문자 ( ¤ )
		 * \u2030 : 퍼밀표시 (  ‰  )
		 * ; : 양수일때와 음수일때 패턴을 구분해주는 역할  (----;***** : ---[양수포맷], *****[음수포맷])*/
		
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
				/** <<출력 결과>>
				 * Date_Full :	2014년 7월 31일 목요일
				 * Date_Long :	2014년 7월 31일 (목)
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
				/** <<출력결과>>
				 * Time_Full :	오전 10시 59분 49초 KST
				 * Time_Long :	오전 10시 59분 49초
				 * Time_Medium :	오전 10:59:49
				 * Time_Short :	오전 10:59
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
		/** M : 7, MM : 07, MMM : 7월
		 * yyyy : 2014, yy : 14 (대/소문자 상관 없음)
		 * dd : 30 (일을 출력)
		 * EEE : 목 , EEEE : 목요일*/
		
		String pattern = "YYYY/MMM/dd EEE EEEE hh:mm";
		SimpleDateFormat formatter = new SimpleDateFormat();
		formatter.applyPattern(pattern);
		SimpleDateFormat Localeformatter = new SimpleDateFormat(pattern, Locale.US);  //Locale.지역 : 그 지역의 언어로 나타남
		System.out.println(pattern + "\n" + formatter.format(date));
		System.out.println(pattern + "\n" + Localeformatter.format(date));
	}

	public void messageFormatTest() {
		Date date = new Date();
		String name = "이승현";
		int price = 50000;
		
		/** << 설  명  >>
		 * {패턴다음으로 들어오는 argument의 순서(0부터), FormatType , FormatStyle}
		 * FormatType : number, date, time
		 * fromat( ) 이 static 이라서 new 없이 사용이 가능하다
		 * {0}에는 date값이 , {1}에는 name 값이, {2}에는 price값이 들어간다.*/
		
		String format="{0, date, full} / {1}님이 구매하신 총액은 {2, number, #,###.00원} 입니다.";
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
