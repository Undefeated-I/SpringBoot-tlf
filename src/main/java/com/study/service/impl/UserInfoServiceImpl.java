package com.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.mapper.UserInfoMapper;
import com.study.model.UserInfo;
import com.study.service.UserInfoService;


@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper ; //����ע��Mybatis���ݲ����ӿڵ�ʵ�� <bean id="userInfoMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
	
	public boolean register(UserInfo userInfo) {
		return userInfoMapper.register(userInfo) > 0;
	}

	public UserInfo login(UserInfo userInfo) {
		return userInfoMapper.login(userInfo);
	}

	public List<UserInfo> getAllUserInfos() {
		return userInfoMapper.getAllUserInfos();
	}

	public UserInfo getUserInfoById(int userId) {
		return userInfoMapper.getUserInfoById(userId) ;
	}

	public boolean updateUserInfo(UserInfo userInfo) {
		
		return userInfoMapper.updateUserInfo(userInfo) > 0;
	}

	public boolean deleteUserInfo(int userId) {
		return userInfoMapper.deleteUserInfo(userId) > 0;
	}
}
