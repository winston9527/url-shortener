package com.winston.urlshortener.util;


public class StringUtils {

	
	public static String buildRedirectUrl(String sourceUrl) {
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("redirect:");
		sbf.append(sourceUrl);
		return sbf.toString();
	}
	
}
