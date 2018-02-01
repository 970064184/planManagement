package com.bin.web.service;

import com.bin.web.domain.PmsUser;

public interface PmsUserService {
	/**
	 * 根据用户名和密码查找用户
	 * @param userName
	 * @param password
	 * @return
	 */
	public PmsUser findByUserNameAndPassword(String userName,String password);
	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	public PmsUser findByUserName(String userName);
	/**
	 * 根据手机号码查找用户
	 * @param phone
	 * @return
	 */
	public PmsUser findByPhone(String phone);
	
	public boolean registPmsUser(PmsUser pmsUser) ;
}
