package com.study.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.model.Schedules;
import com.study.model.UserInfo;
import com.study.service.SchedulesService;

@Controller
public class SchedulesController {
	
	@Autowired
	private SchedulesService schedulesService ;
	
	@RequestMapping("showCreateSchedules")
	public String showCreateSchedules() {
		return "schedules/createSchedules";
	}
	
	@RequestMapping("createSchedules")
	public String createSchedules(HttpSession session,Schedules schedules) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		if ( userInfo == null ) {
			//没有登录 或 会话过期
			return "login" ;
		}
		schedules.setCreatorId(userInfo.getUserId());
		boolean pd = schedulesService.createSchedules(schedules);
		if(pd) {
			return "main";
		}else {
			return "redirect:showCreateSchedules";
		}
	}
	@RequestMapping("selectSchedules")
	public String selectSchedules(Model model) {
		List<Schedules> schedulesList = schedulesService.getAllSchedules();
		model.addAttribute(schedulesList);
		return "schedules/schedulesManage";
	}
	@RequestMapping("showUpadteSchedules")
	public String showUpadteSchedules(@RequestParam(name="scheduleId",required=true)  int schedulesId,Model model) {
		Schedules schedules = schedulesService.getSchedulesById(schedulesId);
		model.addAttribute("schedules",schedules);
		return "schedules/updateSchedules";
	}
	@Delete("deleteSchedules")
	public String deleteSchedules(int schedulesId) {
		schedulesService.deleteSchedules(schedulesId);
		
		return "redirect:selectSchedules" ;
	}
	
}

