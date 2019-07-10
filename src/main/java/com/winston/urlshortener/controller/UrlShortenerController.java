package com.winston.urlshortener.controller;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winston.urlshortener.entity.db.UrlShortenerDO;
import com.winston.urlshortener.entity.dto.UrlShortenerDTO;
import com.winston.urlshortener.service.UrlShortenerServie;
import com.winston.urlshortener.util.StringUtils;

/**
 * 网址缩短服务
 * @author Administrator
 *
 */
@Controller
public class UrlShortenerController {

	@Autowired
	UrlShortenerServie urlShortenerServie;
	
	@ResponseBody
	@PostMapping("/urlShortener")
	public Map<String,String> add(@RequestBody UrlShortenerDTO urlDTO){
		
		Map<String,String> map = new HashMap<String,String>();
		
		return map;
	}
	
	@PostMapping("/url/{urlId}")
	public String get(@PathParam("urlId")String urlId){
		
		UrlShortenerDO urlShortenerDO =  urlShortenerServie.get(urlId);
		if(urlShortenerDO==null) {
			//未查询到缩短后的url,跳到未知界面
			return "";
		}
		return StringUtils.buildRedirectUrl(urlShortenerDO.getSourceUrl());
	}
	
}
