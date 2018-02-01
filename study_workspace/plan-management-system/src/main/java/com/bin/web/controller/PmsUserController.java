package com.bin.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bin.web.common.CodeEnum;
import com.bin.web.common.DtoUtils;
import com.bin.web.common.MediaType;
import com.bin.web.domain.PmsUser;
import com.bin.web.service.PmsUserService;


@RestController
@RequestMapping("/api/pmsUser")
public class PmsUserController {
	
	private final int SESSION_TIME=30*60;
	
	@Autowired
	private PmsUserService pmsUserService;
	/**
	 * 登录
	 * @param request
	 * @param pmsUser
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/v1/login",produces=MediaType.APPLICATION_JSON_UTF8,consumes=MediaType.APPLICATION_JSON_UTF8,method=RequestMethod.POST)
	public String login(HttpServletRequest request,@RequestBody PmsUser pmsUser,HttpServletResponse response){
		System.out.println(pmsUser);
		PmsUser loginUser = pmsUserService.findByUserNameAndPassword(pmsUser.getUserName(), pmsUser.getPassword());
		if(loginUser==null){
			return DtoUtils.isError(CodeEnum.PSM_USERORPASSWORD_NOTRIGHT);
		}
		JSONObject json=new JSONObject();
		HttpSession session = request.getSession();
		json.put("id_token", session.getId());
		session.setAttribute("userName", loginUser.getId());
		session.setMaxInactiveInterval(SESSION_TIME);
		System.out.println(System.currentTimeMillis());
		
		Cookie cookie=new Cookie("userName", loginUser.getId().toString());
		cookie.setPath("/");
		cookie.setMaxAge(SESSION_TIME);
		response.addCookie(cookie);
		return DtoUtils.isSuccess(json);
	}
	/**
	 * 注册
	 * @param request
	 * @param pmsUser
	 * @return
	 */
	@RequestMapping(value="/v1/registPmsUser",produces=MediaType.APPLICATION_JSON_UTF8,consumes=MediaType.APPLICATION_JSON_UTF8,method=RequestMethod.POST)
	public String registPmsUser(HttpServletRequest request,@RequestBody PmsUser pmsUser){
		PmsUser findByUserName = pmsUserService.findByUserName(pmsUser.getUserName());
		if(findByUserName != null){
			return DtoUtils.isError(CodeEnum.PSM_USERNAME_HASREGISTERED);
		}
		PmsUser findByPhone = pmsUserService.findByPhone(pmsUser.getPhone());
		if(findByPhone != null){
			return DtoUtils.isError(CodeEnum.PSM_PHONE_HASREGISTERED);
		}
		boolean registPmsUser = pmsUserService.registPmsUser(pmsUser);
		if(registPmsUser == false){
			return DtoUtils.isError(CodeEnum.PSM_SYSTEM_EXCEPTION_SAVEFAILED);
		}
		return DtoUtils.isSuccess();
	}
	/**
	 * 退出登录
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value="/v1/logout")
	public String logout(HttpServletRequest req,HttpServletResponse resp){
		HttpSession session = req.getSession();
		session.removeAttribute("userName");
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if("userName".equals(cookie.getName())){
				cookie.setValue(null);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				resp.addCookie(cookie);
				break;
			}
		}
		return DtoUtils.isSuccess();
	}
}
