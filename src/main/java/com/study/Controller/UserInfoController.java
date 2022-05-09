package com.study.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.model.UserInfo;
import com.study.service.UserInfoService;

@Controller
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService ;
	
	@RequestMapping("register")
	public String register(UserInfo userInfo) {
		boolean success = userInfoService.register(userInfo) ;
		if ( success ) {
			return "login" ;
		} else {
			return "register" ;
		}
	}
	
	@RequestMapping("showRegister")
	public String showRegister() {
		return "register" ;
	}
	
	@RequestMapping("showLogin")
	public String showLogin() {
		return "login" ;
	}
	
	@RequestMapping("login")
	public String login(UserInfo userInfo,HttpSession session) {
		UserInfo us = userInfoService.login(userInfo) ;
		if ( us != null ) {
			//登录成功
			session.setAttribute("userInfo", us) ;
			return "main" ;
		} else {
			//登录失败
			return "login" ;
		}
	}
	
	@RequestMapping("userInfoManage")
	public String userInfoManage(Model model) {
		List<UserInfo> userInfoList= userInfoService.getAllUserInfos() ;
		model.addAttribute("userInfoList",userInfoList) ;
		return "userInfo/userInfoManage" ;
	}
	
//	@RequestMapping("showUpdateUserInfo")
//	public String showUpdataeUserInfo(@RequestParam(name="userId",required=true)int userId,Model model) {
//		UserInfo userInfo = userInfoService.getUserInfoById(userId) ;
//		model.addAttribute("userInfo",userInfo) ;
//		return "userInfo/updateUserInfo" ;
//	}
	
	@RequestMapping("updateUserInfo")
	public String updateUserInfo(UserInfo userInfo) {
		boolean success = userInfoService.updateUserInfo(userInfo) ;
		if ( success ) {
			return "redirect:userInfoManage" ;
		} else {
			return "redirect:showUpdateUserInfo?userId="+userInfo.getUserId() ;
		}
	}
	
	@RequestMapping("deleteUserInfo")
	public String deleteUserInfo(int userId) {
		userInfoService.deleteUserInfo(userId) ;
		return "redirect:userInfoManage" ;
	}

}
