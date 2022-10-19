package com.czw.superProject.CommonUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.czw.superProject.Constants.ProConstants;

public class DateUtils {
	
	public static Date string2Date(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat(ProConstants.YYYYMMDD);
		Date date = new Date();
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static String date2String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(ProConstants.YYYYMMDD);
		String dateString = sdf.format(date);
		return dateString;
	}
}
