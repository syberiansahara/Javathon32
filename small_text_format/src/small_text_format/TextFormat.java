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
		
		
		String text = "Стоимость доступа к услугам контент-провайдера устанавливается Вашим оператором.\r\n" + 
				"\r\n" + 
				"Стоимость услуги составляет 20.00 рублей с НДС за 1 календарный день для абонентов ПАО \"МТС\". С порядком списания стоимости услуги можно ознакомиться на cайте ПАО «МТС» www.mts.ru в разделе «Услуги по коротким номерам», введя короткий номер или идентификатор услуги в строке поиска, а также позвонив по единому номеру 88002500890. Для отказа от предоставления Подписки на Контент отправьте смс-сообщение с командой СТОП DFILES на номер 771177 (смс бесплатно в домашнем регионе) или наберите ussd-команду *152*22#вызов (бесплатно). Cлужба технической поддержки контент-провайдера ООО «МобиКит»: тел. 8-800-200-6554 (ежедневно с 8:00 до 20:00 по МСК), электронная почта cs@mobikit.ru\r\n" + 
				"\r\n" + 
				"Стоимость доступа составляет 30 рублей (включая НДС) за 1 день для абонентов ПАО «МегаФон»; Продление доступа происходит автоматически, посредством подписки. Для отказа от предоставления Подписки на услугу отправьте SMS-сообщение со словом СТОП 7672 на номер 5151 для абонентов ПАО «МегаФон» сообщение бесплатно в домашнем регионе. Либо воспользуйтесь формой управления подпиской. Cлужба технической поддержки контент-провайдера ООО «Информпартнер»: 8 800 333-89-81 (звонок бесплатный), e-mail: helpdesk@informpartner.com.\r\n" + 
				"\r\n" + 
				"Стоимость доступа составляет 20.00 рублей (включая НДС) за 1 день для абонентов ПАО \"Вымпелком\"; продление доступа происходит автоматически, посредством подписки. Для отказа от предоставления Подписки на услугу отправьте смс-сообщение со словом \"STOP DFILES\" на номер 7565 для абонентов ПАО \"Вымпелком\"; сообщение бесплатно в домашнем регионе. Либо воспользуйтесь формой управления подпиской. Служба технической поддержки ООО «Миллениум» телефон: 8-800-775-31-43 (звонок бесплатный), e-mail: cs@millenium.agency\r\n" + 
				"\r\n" + 
				"До 11.02.2016 абоненты ПАО «МТС» обслуживались Контент-провайдером ООО «Партнерские технологии». Абонентам, подписавшимся до 11.02.2016, для отказа от предоставления Подписки на Контент необходимо отправить смс-сообщение со словом СТОП на номер 771999 (смс бесплатно в домашнем регионе) или наберать ussd-команду *152*2#вызов (бесплатно). Служба технической поддержки ООО «Партнерские технологии» телефон: 8-800-555-39-76 (звонок бесплатный), e-mail: helpdesk@part-t.ru.\r\n" + 
				"\r\n" + 
				"До 09.03.2016 абоненты ПАО «ВымпелКом» обслуживались Контент-провайдером ООО «Партнерские технологии». Абонентам, подписавшимся до 09.03.2016, для отказа от предоставления Подписки на Контент необходимо отправить смс-сообщение со словом СТОП на номер 9115 (смс бесплатно в домашнем регионе). Служба технической поддержки ООО «Партнерские технологии» телефон: 8-800-555-39-76 (звонок бесплатный), e-mail: helpdesk@part-t.ru.";
		
		//String text = new String(input.getBytes("UTF-8"));
//		System.out.println(text);
		
		HashSet<String> keywords = new HashSet<String>();
		keywords.add("Стоимость");
		keywords.add("рублей");
		
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
