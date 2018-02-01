package com.bin.web.service.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bin.web.dao.PmsUserDao;
import com.bin.web.domain.PmsUser;
import com.bin.web.service.PmsUserService;
@Service
public class PmsUserServiceImpl implements PmsUserService {
	@Autowired
	private PmsUserDao pmsUserDao;

	@Override
	public PmsUser findByUserNameAndPassword(String userName, String password) {
		return pmsUserDao.findByUserNameAndPassword(userName, password);
	}

	@Override
	public PmsUser findByUserName(String userName) {
		return pmsUserDao.findByUserName(userName);
	}

	@Override
	public PmsUser findByPhone(String phone) {
		return pmsUserDao.findByPhone(phone);
	}

	@Override
	public boolean registPmsUser(PmsUser pmsUser) {
		pmsUser.setCreated(new Date());
		pmsUser.setSort(0L);
		Byte[] status={1};
		pmsUser.setStatus(status);
		String id = pmsUserDao.save(pmsUser).getId();
		if("".equals(id) || id == null){
			return false;
		} 
		return true;
	}

}
