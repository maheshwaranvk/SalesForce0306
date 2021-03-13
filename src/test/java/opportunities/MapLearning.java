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
import java.util.TimeZone;

public class MapLearning {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		Map<String,Integer> months = new HashMap<String,Integer>();
		months.put("January", 1);
		months.put("February", 2);
		months.put("March", 3);
		months.put("April", 4);
		months.put("May", 5);
		months.put("June", 6);
		months.put("July", 7);
		months.put("August", 8);
		months.put("September", 9);
		months.put("October", 10);
		months.put("November", 11);
		months.put("December", 12);
		
		Integer integer = months.get("September");

		
		  Calendar c = Calendar.getInstance(); //13 Mar 2021 Time   
			c.add(Calendar.DATE, 1); // 14 Mar 2021 Time
			System.out.println(c.getTime());
	
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");  
			System.out.println(df.format(c.getTime()));
	}
}
