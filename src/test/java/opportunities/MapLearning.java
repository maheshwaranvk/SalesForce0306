package opportunities;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

public class MapLearning {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Map<String,Integer> months = new HashMap<String,Integer>();
		months.put("Jan", 1);
		months.put("Feb", 2);
		months.put("Mar", 3);
		months.put("Apr", 4);
		months.put("May", 5);
		months.put("Jun", 6);
		months.put("Jul", 7);
		months.put("Aug", 8);
		months.put("Sept", 9);
		months.put("Oct", 10);
		months.put("Nov", 11);
		months.put("Dec", 12);
		
	Set<Entry<String, Integer>> entrySet = months.entrySet();
	
		
		
Calendar c=	Calendar.getInstance();
		c.add(Calendar.MONTH, 1);

		/*
		 * String [] date = new
		 * SimpleDateFormat("MM/dd/yyyy").format(c.getTime()).toString().split("/");
		 * System.out.println(Integer.parseInt(date[0]));
		 */
		
		String[] split = c.getTime().toString().split(" ");
		String a = "Apr 26 - Apr 30";
		String b = "Mar 15 - Apr 19";
		String d = "MAr 15 - Mar 19";
		
		System.out.println(a.contains(split[1]));
		System.out.println(b.contains(split[1]));
		System.out.println(d.contains(split[1]));
		
	
		
			
	}
}
