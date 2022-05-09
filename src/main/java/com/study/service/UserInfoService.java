package com.study.service;

import java.util.List;


import com.study.model.UserInfo;


public interface UserInfoService {

	public boolean register(UserInfo userInfo) ;
	
	public UserInfo login(UserInfo userInfo) ;
	
	public List<UserInfo> getAllUserInfos();

	public UserInfo getUserInfoById(int userId)  ;
	
	public boolean updateUserInfo(UserInfo userInfo);
	
	public boolean deleteUserInfo (int userId);
}
