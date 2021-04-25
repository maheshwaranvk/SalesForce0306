package dustbin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateRegEx {

	public static void main(String[] args) {
		String str = "Maheshwaran, 43/158/2021, 10:49 PM";
		
		Matcher m = Pattern.compile("(\\d{1,2}/\\d{1,2}/\\d{4}|\\d{1,2}/\\d{1,2})", Pattern.CASE_INSENSITIVE).matcher(str);
        while (m.find()) {
            System.out.println(m.group(1));
        }
	}
}
