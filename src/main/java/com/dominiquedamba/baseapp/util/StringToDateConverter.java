/**
 * 
 */
package com.dominiquedamba.baseapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author DOMINIQUE DAMBA
 *
 */
public class StringToDateConverter {
	private static Date formatter;

	public static Date convert(String dateString) {
		try {
			 formatter = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatter;
	}
}
