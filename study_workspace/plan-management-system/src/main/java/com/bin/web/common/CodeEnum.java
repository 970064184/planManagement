package com.bin.web.common;
/**
 * 1. 系统异常代码由7位组成， 规则为：S+3位系统代码+3位数字编码，如：SAPV001   服务调用超时
 * 2. 业务异常代码由7位代码组成，规则为：B+3位系统代码+3位数字， 如BAPV000   请求参数为空
 * 3. enum常量命名格式为：模块代码+‘_’+异常变量，异常变量含义与中文一致，命名含义清晰，见字识义
 * 4. 错误代码按模块连续编码，不同模块之间起始位数字不一样
 * @author admin
 *
 */
public enum CodeEnum {
	
	SUCCESS("成功","200"),
	
	PSM_SYSTEM_EXCEPTION("系统异常","SPSM500"),
	
	PSM_SYSTEM_EXCEPTION_SAVEFAILED("系统异常,保存失败","SPSM501"),
	
	PSM_USERORPASSWORD_NOTRIGHT("用户名或密码不正确","BPSM001"),
	
	PSM_USER_NOTLOGIN("用户未登录","BPSM002"),
	
	PSM_USERNAME_HASREGISTERED("用户名已注册","BPSM003"),
	
	PSM_PHONE_HASREGISTERED("手机号码已注册","BPSM003");
	
	private String code;
	private String name;
	
	private CodeEnum(String name, String code) {
		this.code = code;
		this.name = name;
	}
	/**
	 * 根据code查询值
	 * @param code
	 * @return
	 */
    public static String getCodeName(String code) {  
        for (CodeEnum ce : CodeEnum.values()) {  
            if (ce.getCode().equals(code)) {  
                return ce.name;  
            }  
        }  
        return null;  
    }
   
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
