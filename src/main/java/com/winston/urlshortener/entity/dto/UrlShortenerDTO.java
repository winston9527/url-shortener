package com.winston.urlshortener.entity.dto;

import java.io.Serializable;
/**
 * 
 * @Description:短链接传输对象
 * @Author Administrator
 * @Version 1.0 2019年7月11日 下午7:46:39
 */
public class UrlShortenerDTO implements Serializable {

	private static final long serialVersionUID = 4151382891236629522L;
	
	private String urlId;

	private String sourceUrl;

	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	

}
