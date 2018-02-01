package com.bin.web.common;

public class DtoUtils {
	
	public static String isSuccess(){
		Dto dto=new Dto();
		dto.setMsg(CodeEnum.SUCCESS);
		return dto.toJson();
	}
	public static String isSuccess(Object data){
		Dto dto=new Dto();
		dto.setMsg(CodeEnum.SUCCESS);
		dto.data=data;
		return dto.toJson();
	}
	public static String isError(){
		Dto dto=new Dto();
		dto.setMsg(CodeEnum.PSM_SYSTEM_EXCEPTION);
		return dto.toJson();
	}
	public static String isError(CodeEnum codeEnum){
		Dto dto=new Dto();
		dto.setMsg(codeEnum);
		return dto.toJson();
	}
}
