package formatter;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

public class FormatterTest {
	public void argumentIndex() {
		// String, PrintStream, PrintWriter Ŭ������ �ִ� format() �޼ҵ� �̿�
		Calendar c = Calendar.getInstance();
		System.out.println("<<argumentIndex>>");
		/** <<����>>
		 * => format(%[���ڼ���$][�÷���][�ʺ�][���е�]������Ÿ��, ����)*/
		
		String s1 = String.format("Duke's Birthday: %1$tm %1$te, %1$tY", c);
		String s2 = String.format("Duke's Birthday: %1$tm %<te, %<tY", c);
		// < : �տ� �����(�ٷ� ���� �����) �μ��� �����ϰڴ�.
		System.out.println(s1);
		System.out.println(s2);

		int c1 = 1;
		int c2 = 2;
		int c3 = 3;
		//����° �μ�, ����°�μ�, �ι�° �μ�, �ι�° �μ�, ù��° �μ�
		String s3 = String.format("%3$d %<d %2$d %<d %d", c1, c2, c3);
		System.out.println(s3);
	}

	public void flags() {
		// Formatter Ŭ���� �̿�
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
		// System.out�� printf() �޼ҵ� �̿�
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
		System.out.printf("%b | %b%n", true, false);  //boolean ����� -  true, false
		System.out.printf("%B | %B%n", true, false); //boolean �� ��� - TRUE, FALSE
		System.out.printf("%b | %b%n", null, "hello");
		System.out.printf("%h | %H | %h%n", this, this, null);
		System.out.printf("%s | %s | %S | %S%n", "hello", "Hello", "hello", "Hello"); //s - �ִ� �׷��� ���, S-�빮�ڷ� ���
		System.out.printf("%c | %c | %C | %C%n", 'a', 'A', 'b', 'B'); //c - �ִ� �׷��� ���, C-�빮�ڷ� ���
		System.out.printf("%.2f %.2f\n", 4.44, 4.45);  //%.2f : �Ҽ��� �Ʒ� �ι�° �ڸ����� ���(����� ���ϴ� �ڸ���)
		System.out.printf("%.1e %.1E\n", 4.44, 4.45); //�Ҽ��� e�� ����� 
		System.out.printf("%.1g %.1g\n", 4.44, 4.45); //�Ϲ����� �Ҽ���( %.1g : �Ҽ��� ù°�ڸ����� �ݿø� ==> �ݿø� �ڸ���)
		System.out.printf("%.1a %.1a\n", 4.44, 4.45); //16���� �Ҽ���
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
		
		/**<<String.Format() ��¥/�ð�>> 
		 * %tA - ���� ��� (�����), %ta - ���� ���(��)
		 * %d - �� ���(31)
		 * %tY - 4�ڸ� �⵵ ���(2014) , %ty - 2�ڸ� �⵵ ���(14)
		 * %tB - ���� �̸�(������ ��� January, February..) ��� 
		 * %tm - 01 ~ 12 �� ǥ���ϴ� �� ��� 
		 * %te - 1 ~ 31 �� ǥ���ϴ� �ش� ���� ��¥ ��� 
		 * %tk - 0 ~ 23 ���� ǥ���ϴ� �� ��� 
		 * %tl - 1 ~ 12�� ǥ���ϴ� �� ��� 
		 * %tM - 00 ~ 59 �� ǥ���ϴ� �� 
		 * %tS - 00 ~ 59 �� ǥ���ϴ� �� 
		 * %tZ - Ÿ���� ��� 
		 * %tT - 24�ð� ���*/
		
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
