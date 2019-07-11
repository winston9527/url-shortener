package com.winston.urlshortener.service.impl;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.winston.urlshortener.entity.dto.UrlShortenerDTO;
import com.winston.urlshortener.service.UrlShortenerServie;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerServie {

	// 存储短链接的映射关系
	private Map<String, UrlShortenerDTO> urlShortenerMap = new ConcurrentHashMap<String, UrlShortenerDTO>();

	// 当前的urlId
	private AtomicLong currUrlId = new AtomicLong(1000);

	@Override
	public String add(UrlShortenerDTO urlShortenerDTO) {

		String sourceUrl = urlShortenerDTO.getSourceUrl();
		for (Entry<String, UrlShortenerDTO> entry : urlShortenerMap.entrySet()) {
			if (sourceUrl.equals(entry.getValue().getSourceUrl())) {
				// url已经存在
				return entry.getKey();
			}
		}
		
		//获取本次的urlId
		String urlId = String.valueOf(currUrlId.incrementAndGet());
		urlShortenerMap.put(urlId, urlShortenerDTO);
		
		return urlId;
	}

	@Override
	public UrlShortenerDTO get(String urlId) {
		
		return urlShortenerMap.get(urlId);
	}

}
