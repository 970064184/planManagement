package com.bin.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bin.web.domain.PmsUser;

@Repository
public interface PmsUserDao extends JpaRepository<PmsUser, Long>, JpaSpecificationExecutor<PmsUser> {
	
	public PmsUser findByUserNameAndPassword(String userName,String password);

	public PmsUser findByUserName(String userName);

	public PmsUser findByPhone(String phone);
	
	
	
}
