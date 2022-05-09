package com.study.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.study.model.UserInfo;


@Mapper
public interface UserInfoMapper {
	
	@Insert("insert into userInfo(userName,userPass) values(#{userName},#{userPass})")
	public int register(UserInfo userInfo) ;
	
	@Select("select * from userInfo where userName=#{userName} and userPass=#{userPass}")
	public UserInfo  login(UserInfo userInfo) ;
		
	@Select("select * from userInfo")
	public List<UserInfo> getAllUserInfos() ;
	
	@Select("select * from userInfo where userId=#{userId}")
	public UserInfo getUserInfoById(int userId) ;
	
	@Update("update userInfo set userName=#{userName},userPass=#{userPass} where userId=#{userId}")
	public int updateUserInfo(UserInfo userInfo);
	
	@Delete("delete from userInfo where userId=#{userId}")
	public int deleteUserInfo(int userId);
}
