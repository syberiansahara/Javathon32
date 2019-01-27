package small_text_format;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextFormat {
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		
		
		String text = "��������� ������� � ������� �������-���������� ��������������� ����� ����������.\r\n" + 
				"\r\n" + 
				"��������� ������ ���������� 20.00 ������ � ��� �� 1 ����������� ���� ��� ��������� ��� \"���\". � �������� �������� ��������� ������ ����� ������������ �� c���� ��� ���ѻ www.mts.ru � ������� ������� �� �������� �������, ����� �������� ����� ��� ������������� ������ � ������ ������, � ����� �������� �� ������� ������ 88002500890. ��� ������ �� �������������� �������� �� ������� ��������� ���-��������� � �������� ���� DFILES �� ����� 771177 (��� ��������� � �������� �������) ��� �������� ussd-������� *152*22#����� (���������). C����� ����������� ��������� �������-���������� ��� ��������: ���. 8-800-200-6554 (��������� � 8:00 �� 20:00 �� ���), ����������� ����� cs@mobikit.ru\r\n" + 
				"\r\n" + 
				"��������� ������� ���������� 30 ������ (������� ���) �� 1 ���� ��� ��������� ��� ��������; ��������� ������� ���������� �������������, ����������� ��������. ��� ������ �� �������������� �������� �� ������ ��������� SMS-��������� �� ������ ���� 7672 �� ����� 5151 ��� ��������� ��� �������� ��������� ��������� � �������� �������. ���� �������������� ������ ���������� ���������. C����� ����������� ��������� �������-���������� ��� ��������������: 8 800 333-89-81 (������ ����������), e-mail: helpdesk@informpartner.com.\r\n" + 
				"\r\n" + 
				"��������� ������� ���������� 20.00 ������ (������� ���) �� 1 ���� ��� ��������� ��� \"���������\"; ��������� ������� ���������� �������������, ����������� ��������. ��� ������ �� �������������� �������� �� ������ ��������� ���-��������� �� ������ \"STOP DFILES\" �� ����� 7565 ��� ��������� ��� \"���������\"; ��������� ��������� � �������� �������. ���� �������������� ������ ���������� ���������. ������ ����������� ��������� ��� ���������� �������: 8-800-775-31-43 (������ ����������), e-mail: cs@millenium.agency\r\n" + 
				"\r\n" + 
				"�� 11.02.2016 �������� ��� ���ѻ ������������� �������-����������� ��� ������������ ����������. ���������, ������������� �� 11.02.2016, ��� ������ �� �������������� �������� �� ������� ���������� ��������� ���-��������� �� ������ ���� �� ����� 771999 (��� ��������� � �������� �������) ��� �������� ussd-������� *152*2#����� (���������). ������ ����������� ��������� ��� ������������ ���������� �������: 8-800-555-39-76 (������ ����������), e-mail: helpdesk@part-t.ru.\r\n" + 
				"\r\n" + 
				"�� 09.03.2016 �������� ��� ���������� ������������� �������-����������� ��� ������������ ����������. ���������, ������������� �� 09.03.2016, ��� ������ �� �������������� �������� �� ������� ���������� ��������� ���-��������� �� ������ ���� �� ����� 9115 (��� ��������� � �������� �������). ������ ����������� ��������� ��� ������������ ���������� �������: 8-800-555-39-76 (������ ����������), e-mail: helpdesk@part-t.ru.";
		
		//String text = new String(input.getBytes("UTF-8"));
//		System.out.println(text);
		
		HashSet<String> keywords = new HashSet<String>();
		keywords.add("���������");
		keywords.add("������");
		
		//text = text.replaceAll("\\r\\n\\r\\n\\s+", " ");
		text = text.replaceAll("\\s+", " ");
		
		for(String keyword : keywords) {
			text = text.replaceAll(keyword, "<word>" + keyword + "</word>");
		}	
		
		text = "<html>\n<head><style>div{width: 98%; margin-left: 1%;} word{background-color: orange; font-weight: bolder;}</style>" + 
				"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \r\n" + 
				"	<title>Single page template</title> \r\n" + 
				"	<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.2.1/jquery.mobile-1.2.1.min.css\" />\r\n" + 
				"	<script src=\"http://code.jquery.com/jquery-1.8.3.min.js\"></script>\r\n" + 
				"	<script src=\"http://code.jquery.com/mobile/1.2.1/jquery.mobile-1.2.1.min.js\"></script></head>\n<body><div>\n" + text + "</div>\n</body>\n</html>";
		text = text.replaceAll("\\.\\s+", ".<br><br>");
		System.out.println(text);
		
		try (PrintWriter out = new PrintWriter("result.html")) {
		    out.println(text);
		    out.close();
		}
		
//		String input = "Hello Java! Hello JavaScript! JavaSE 8.";
//        Pattern pattern = Pattern.compile("Java(\\w*)");
//        Matcher matcher = pattern.matcher(input);
//        while(matcher.find())
//            System.out.println(matcher.group());
	}
}
