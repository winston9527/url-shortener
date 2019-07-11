package com.winston.urlshortener.service;

import com.winston.urlshortener.entity.dto.UrlShortenerDTO;
/**
 * 
 * @Description: 短链接管理Service
 * @Author Winston
 * @Version 1.0 2019年7月11日 下午7:45:20
 */
public interface UrlShortenerServie {

	/**
	 * 添加短链接
	 * @Title: add  
	 * @param urlShortenerDTO 接口封装的对象
	 * @return 短链接id
	 */
	String add(UrlShortenerDTO urlShortenerDTO);
	
	/**
	 * 获取短链接信息
	 * @Title: get  
	 * @param urlId 短链接id
	 * @return 链接实体
	 */
	UrlShortenerDTO get(String urlId);
	
}
