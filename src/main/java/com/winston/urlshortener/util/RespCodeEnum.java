package com.winston.urlshortener.util;

/**
 * 
 * @Description:响应码枚举
 * @Author Winston
 * @Version 1.0 2019年7月11日 下午8:14:23
 */
public enum RespCodeEnum {

	SUCCESS("0000","success"),
	FAIL("9999","Fail");
	
	private String value;
	
	private String desc;

	
	private RespCodeEnum(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}


	public String getValue() {
		return value;
	}

	
	public void setValue(String value) {
		this.value = value;
	}

	
	public String getDesc() {
		return desc;
	}

	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
