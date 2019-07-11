package com.winston.urlshortener.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @Description: 统一返回对象
 * @Author Administrator
 * @Version 1.0 2019年7月11日 下午8:00:26
 */
public class RespData implements Serializable {

	private static final long serialVersionUID = -8237877626113958578L;

	/**
	 * 响应码
	 */
	private String respCode;
	/**
	 * 响应消息
	 */
	private String respMsg;
	
	/**
	 * 响应数据
	 */
	private Map<String, Object> respInfo;


	public RespData() {
		respInfo = new HashMap<String, Object>();
	}

	
	public String getRespCode() {
		return respCode;
	}


	
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}


	
	public String getRespMsg() {
		return respMsg;
	}


	
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}


	
	public Map<String, Object> getRespInfo() {
		return respInfo;
	}


	
	public void setRespInfo(Map<String, Object> respInfo) {
		this.respInfo = respInfo;
	}

	public void addObject (String key, Object value) {
		respInfo.put(key, value);
	}

}
