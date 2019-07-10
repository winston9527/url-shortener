package com.winston.urlshortener.service;

import com.winston.urlshortener.entity.db.UrlShortenerDO;

public interface UrlShortenerServie {

	int add(UrlShortenerDO urlShortenerDO);
	
	
	UrlShortenerDO get(String urlId);
	
}
