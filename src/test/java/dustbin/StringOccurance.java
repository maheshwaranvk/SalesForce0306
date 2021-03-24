package dustbin;

import java.util.HashMap;
import java.util.Map;

public class StringOccurance {

	public static void main(String[] args) {
		
		String str = "Mahesh is a Good Boy";
		
		Map<Character,Integer> strMap = new HashMap<Character,Integer>();
		
		for (int i = str.length()-1; i >=0; i--) {
			
			if(strMap.containsKey(str.charAt(i)))
			{
				int count = strMap.get(str.charAt(i));
				strMap.put(str.charAt(i), ++count);
			}
			
			else {
				strMap.put(str.charAt(i), 1);
			}
			
		}
		System.out.println(strMap);

	}

}
