package com.winston.urlshortener.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @Description: HttpPost请求工具类
 * @Author Winston
 * @Version 1.0 2019年7月11日 下午7:17:46
 */
public class HttpPostUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpPostUtil.class);

	/**
	 * 提交post请求
	 * @Title: httpPost  
	 * @param url 请求地址
	 * @param params 参数
	 * @return 返回内容
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String httpPost(String url, String params) throws ClientProtocolException, IOException {

		logger.info(">>>请求地址:{}，请求参数:{}", url, params);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost method = new HttpPost(url);
		// 解决中文乱码问题
		StringEntity entity = new StringEntity(params, "UTF-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		method.setEntity(entity);
		HttpResponse result = httpClient.execute(method);
		/** 请求发送成功，并得到响应 **/
		if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			/** 读取服务器返回过来的字符串数据 **/
			return  EntityUtils.toString(result.getEntity());
		}else {
			logger.info(">>>返回码:{}",result.getStatusLine().getStatusCode());
			return null;
		}
	}

}
