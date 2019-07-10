package com.winston.urlshortener.entity.db;

import java.io.Serializable;

public class UrlShortenerDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4985675825468909456L;
	
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
