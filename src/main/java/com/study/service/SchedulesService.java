package com.study.service;

import java.util.List;

import com.study.model.Schedules;

public interface SchedulesService {
	
	public boolean createSchedules(Schedules schedules);
	
	public List<Schedules> getAllSchedules ();
	
	public Schedules getSchedulesById(int  schedulesId);
	
	public boolean updateSchedules(Schedules schedules);
	
	public boolean deleteSchedules(int schedulesId);
}
