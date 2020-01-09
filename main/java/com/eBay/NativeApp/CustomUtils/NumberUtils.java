package com.eBay.NativeApp.CustomUtils;

public class NumberUtils {

	public static String extractNumberFromString(String source) {
	    StringBuilder result = new StringBuilder(100);
	    for (char ch : source.toCharArray()) {
	        if (ch >= '0' && ch <= '9' || ch=='.') {
	            result.append(ch);
	        }
	    }

	    return result.toString();
	}
}
