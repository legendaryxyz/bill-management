package vn.test.bill.utils;

public class StringUtils {

	public static String padStringRight(String s, int length) {
		
		StringBuilder sbSpaces = new StringBuilder();
		while(s.length() + sbSpaces.length() < length) {
			
			sbSpaces.append(" ");
		}
		
		return s + sbSpaces.toString();
	}
}
