package com.cognizant.moviecruiser.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToDate(String date) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dobj = null;
		try {
			dobj = formatter.parse(date);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dobj;
	}
}
