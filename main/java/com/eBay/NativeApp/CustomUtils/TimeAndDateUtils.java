package com.eBay.NativeApp.CustomUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeAndDateUtils {

	/**
	 * @return TimeStamp in Format : MMddyyyy_hhmmss
	 */
	public static String getTimeStamp(){

		String stamp = new String();
		SimpleDateFormat format = new SimpleDateFormat("MMddyyyy_hhmmss");
		stamp = format.format(new Date());
		return stamp;
	}

	public static String getTimeStamp(String usingFormat){

		String stamp = new String();
		SimpleDateFormat format = new SimpleDateFormat(usingFormat);
		stamp = format.format(new Date());
		return stamp;
	}

	public static String getFutureTimeStamp(String usingFormat){

		String stamp = new String();
		SimpleDateFormat format = new SimpleDateFormat(usingFormat);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 2);
		stamp = format.format(cal.getTime());
		return stamp;
	}

	public static String customDate = "";
	
	public static String getCalDate(){

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:MM:SS.SSS");

		TimeZone tz = TimeZone.getTimeZone("AEST");
		Calendar cal = Calendar.getInstance(tz);
		cal.setTime(new Date());

		cal.add(Calendar.DAY_OF_MONTH, 2);
		cal.set(Calendar.HOUR_OF_DAY, 00);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		cal.set(Calendar.MILLISECOND, 00);

		String calDate = sdf.format(cal.getTime()); 
		String[] nodes = calDate.split(" ");
		calDate = nodes[0]+"T"+nodes[1]+"Z";

		return calDate;
	}

}
