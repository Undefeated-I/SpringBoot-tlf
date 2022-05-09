package com.study.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Schedules {
	
	private int scheduleId ;
    private int creatorId ;
    private UserInfo creator ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")  //日期格式转换
    private Date scheduleDate;
    private String content ;
    private Date createTime ;
    
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	public UserInfo getCreator() {
		return creator;
	}
	public void setCreator(UserInfo creator) {
		this.creator = creator;
	}
	public Date getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    
	
    

}
