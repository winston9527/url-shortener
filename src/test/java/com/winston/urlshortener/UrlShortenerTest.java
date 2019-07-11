package com.winston.urlshortener;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.winston.urlshortener.entity.RespData;
import com.winston.urlshortener.entity.dto.UrlShortenerDTO;
import com.winston.urlshortener.util.HttpPostUtil;
import com.winston.urlshortener.util.RespCodeEnum;
/**
 * 
 * @Description: 测试类
 * @Author Winston
 * @Version 1.0 2019年7月11日 下午8:38:58
 */
public class UrlShortenerTest {

	Logger logger = LoggerFactory.getLogger(UrlShortenerTest.class);
	
	@Test
	public void testAdd() throws ClientProtocolException, IOException {
		
		String url = "http://localhost:8080/urlShortener";
		UrlShortenerDTO urlShortenerDTO = new UrlShortenerDTO();
		//设置映射的源地址
		urlShortenerDTO.setSourceUrl("https://github.com/spring-projects/spring-boot");
		
		String result = HttpPostUtil.httpPost(url, JSONObject.toJSONString(urlShortenerDTO));
		logger.info(">>>响应日志:{}",result);
		RespData respData = JSONObject.parseObject(result, RespData.class);
		if(RespCodeEnum.SUCCESS.getValue().equals(respData.getRespCode())) {
			StringBuffer sbf = new StringBuffer();
			sbf.append("http://localhost:8080/urlShortener/");
			sbf.append(respData.getRespInfo().get("urlId"));
			logger.info(">>>添加成功，请在浏览器访问：{}",sbf.toString());
		}
	}

}
