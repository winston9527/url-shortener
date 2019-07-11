package com.winston.urlshortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winston.urlshortener.entity.RespData;
import com.winston.urlshortener.entity.dto.UrlShortenerDTO;
import com.winston.urlshortener.service.UrlShortenerServie;
import com.winston.urlshortener.util.RespCodeEnum;
import com.winston.urlshortener.util.StringUtils;

/**
 * 
 * @Description: 短链接管理Controller
 * @Author Winston
 * @Version 1.0 2019年7月11日 下午7:50:42
 */
@Controller
public class UrlShortenerController {

	@Autowired
	UrlShortenerServie urlShortenerServie;
	
	/**
	 * 短链接添加
	 * @Title: add  
	 * @param urlShortenerDTO 接口传入的参数
	 * @return 添加后的数据
	 */
	@ResponseBody
	@PostMapping("/urlShortener")
	public RespData add(@RequestBody UrlShortenerDTO urlShortenerDTO){
		
		RespData respData = new RespData();
		if(urlShortenerDTO.getSourceUrl()==null) {
			//参数验证不通过
			respData.setRespMsg("目标地址为空");
			respData.setRespCode(RespCodeEnum.FAIL.getValue());
			return respData;
		}
		String urlId = urlShortenerServie.add(urlShortenerDTO);
		respData.setRespCode(RespCodeEnum.SUCCESS.getValue());
		respData.setRespMsg("添加成功");
		respData.addObject("urlId",urlId);
		return respData;
	}
	
	/**
	 * 获取短链接
	 * @Title: get  
	 * @param urlId 短链接Id
	 * @return 跳转到目标地址
	 */
	@GetMapping("/urlShortener/{urlId}")
	public String get(@PathVariable("urlId")String urlId){
		
		UrlShortenerDTO urlShortenerDTO =  urlShortenerServie.get(urlId);
		if(urlShortenerDTO==null) {
			//未查询到缩短后的url,跳到未知界面
			return "no_fonud";
		}
		return StringUtils.buildRedirectUrl(urlShortenerDTO.getSourceUrl());
	}
	
}
