package com.bin.web.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 
 * @author zhangbin
 * @param <T>
 * @param <T>
 *
 */
public class Dto {
	
	private String code="000000";
	
	private String msg;
	
	public Object data;
	
	public void setMsg(CodeEnum codeEnum){
		this.code=codeEnum.getCode();
		this.msg=codeEnum.getName();
	}
	
	public String toJson(){
		return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
}
