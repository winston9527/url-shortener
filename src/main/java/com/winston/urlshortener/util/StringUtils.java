package com.winston.urlshortener.util;


public class StringUtils {

	/**
	 * 构建重定向地址
	 * @Title: buildRedirectUrl  
	 * @param sourceUrl 目标地址
	 * @return 返回构建后的地址
	 */
	public static String buildRedirectUrl(String sourceUrl) {
		
		StringBuffer sbf = new StringBuffer();
		sbf.append("redirect:");
		sbf.append(sourceUrl);
		return sbf.toString();
	}
	
}
