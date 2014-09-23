package formatter;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

public class FormatterTest {
	public void argumentIndex() {
		// String, PrintStream, PrintWriter 클래스에 있는 format() 메소드 이용
		Calendar c = Calendar.getInstance();
		System.out.println("<<argumentIndex>>");
		/** <<형식>>
		 * => format(%[인자순서$][플래그][너비][정밀도]데이터타입, 숫자)*/
		
		String s1 = String.format("Duke's Birthday: %1$tm %1$te, %1$tY", c);
		String s2 = String.format("Duke's Birthday: %1$tm %<te, %<tY", c);
		// < : 앞에 썼었던(바로 전에 썼었던) 인수를 재사용하겠다.
		System.out.println(s1);
		System.out.println(s2);

		int c1 = 1;
		int c2 = 2;
		int c3 = 3;
		//세번째 인수, 세번째인수, 두번째 인수, 두번째 인수, 첫번째 인수
		String s3 = String.format("%3$d %<d %2$d %<d %d", c1, c2, c3);
		System.out.println(s3);
	}

	public void flags() {
		// Formatter 클래스 이용
		StringBuffer sb = new StringBuffer();
		Formatter f = new Formatter(sb);
		
		f.format(Locale.KOREA, "%,d \n", 1048576);
		f.format(Locale.FRANCE, "%,d \n", 1048576);
		f.format("%d, %d, %+d, %+d \n", 5, -5, 5, -5);
		f.format("% d% d\n", 1, -1);
		f.format("%(d, %(d \n", 12, -12);
		f.format("%-6dx \n", -5);
		f.format("%-3C, %3c \n", 'd', 0x65);
		f.format("%07d, %03d \n", 4, 55);
		f.format("%o %#o %#o \n", 17, 017, 0x1f);
		f.format("%x %#x %#x \n", 17, 0x1f, 017);
		f.format("%h %#x %#x \n", 17, 0x1f, 017);

		System.out.println(f);
	}

	public void widthAndPrecision() {
		// System.out의 printf() 메소드 이용
		System.out.println("widthAndPrecision");
		System.out.printf("%f\n", 1024.1024);
		System.out.printf("%10.5f\n", 1024.1024);
		System.out.printf("%10.2f\n", 1024.1024);
		System.out.printf("%20.2f\n", 1024.1024);
		System.out.printf("%15.5f\n", 1024.1024);
	}
	
/*	public void conversion() {
		System.out.println("========================");
		System.out.println("Conversion");
		System.out.println("========================");
		System.out.printf("%b | %b%n", true, false);  //boolean 값출력 -  true, false
		System.out.printf("%B | %B%n", true, false); //boolean 값 출력 - TRUE, FALSE
		System.out.printf("%b | %b%n", null, "hello");
		System.out.printf("%h | %H | %h%n", this, this, null);
		System.out.printf("%s | %s | %S | %S%n", "hello", "Hello", "hello", "Hello"); //s - 있는 그래도 출력, S-대문자로 출력
		System.out.printf("%c | %c | %C | %C%n", 'a', 'A', 'b', 'B'); //c - 있는 그래도 출력, C-대문자로 출력
		System.out.printf("%.2f %.2f\n", 4.44, 4.45);  //%.2f : 소수점 아래 두번째 자리까지 출력(출력을 원하는 자릿수)
		System.out.printf("%.1e %.1E\n", 4.44, 4.45); //소수형 e의 배수형 
		System.out.printf("%.1g %.1g\n", 4.44, 4.45); //일반적인 소수형( %.1g : 소수점 첫째자리에서 반올림 ==> 반올림 자릿수)
		System.out.printf("%.1a %.1a\n", 4.44, 4.45); //16진수 소수형
	}*/
	
	public void dtConversions() {
		System.out.println("========================");
		System.out.println("dtConversions");
		System.out.println("========================");
		Calendar c = Calendar.getInstance();
		Formatter f = new Formatter(new StringBuffer());
		f.format("%1$tc%n", c);
		f.format("%ta%<tb %<td %<tT %<tz %<ty%n", c);
		f.format("%tF %<tr", c);
		
		/**<<String.Format() 날짜/시간>> 
		 * %tA - 요일 출력 (목요일), %ta - 요일 출력(목)
		 * %d - 일 출력(31)
		 * %tY - 4자리 년도 출력(2014) , %ty - 2자리 년도 출력(14)
		 * %tB - 월의 이름(영어의 경우 January, February..) 출력 
		 * %tm - 01 ~ 12 로 표현하는 월 출력 
		 * %te - 1 ~ 31 로 표현하는 해당 월의 날짜 출력 
		 * %tk - 0 ~ 23 으로 표현하는 시 출력 
		 * %tl - 1 ~ 12로 표현하는 시 출력 
		 * %tM - 00 ~ 59 로 표현하는 분 
		 * %tS - 00 ~ 59 로 표현하는 초 
		 * %tZ - 타임존 출력 
		 * %tT - 24시간 출력*/
		
		System.out.println(f);
		
		/*
		// http://rednine.tistory.com/584
		f.format("%1$ta | %<tA%n", c);
		f.format("%1$tb | %<tB%n", c);
		f.format("%1$tc | %<tC%n", c);
		f.format("%1$td | %<tD%n", c);
		f.format("%1$te%n", c);
		f.format("%1$tF%n", c);
		f.format("%1$th | %<tH%n", c);
		f.format("%1$tI%n", c);
		f.format("%1$tj%n", c);
		f.format("%1$tk%n", c);
		f.format("%1$tl | %<tL%n", c);
		f.format("%1$tm | %<tM%n", c);
		f.format("%1$tN%n", c);
		f.format("%1$tp%n", c);
		f.format("%1$tQ%n", c);
		f.format("%1$tr | %<tR%n", c);
		f.format("%1$ts | %<tS%n", c);
		f.format("%tT%n", c);
		f.format("%1$ty | %<tY%n", c);
		f.format("%1$tz | %<tZ%n", c);
		*/
	}
	
	public static void main(String[] args) {
		FormatterTest t = new FormatterTest();
		t.argumentIndex();
		t.flags();
		t.widthAndPrecision();
		//t.conversion();
		t.dtConversions();
	}

}
