package com.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.mapper.SchedulesMapper;
import com.study.model.Schedules;
import com.study.service.SchedulesService;

@Service
public class SchedulesServiceImpl implements SchedulesService{
	
	@Autowired
	private SchedulesMapper Sm ;
	
	public boolean createSchedules(Schedules schedules) {
		
		return Sm.createSchedules(schedules) > 0;
	}

	public List<Schedules> getAllSchedules() {
		
		return Sm.getAllSchedules();
	}

	public Schedules getSchedulesById(int schedulesId) {
		
		return Sm.getSchedulesById(schedulesId);
	}

	public boolean updateSchedules(Schedules schedules) {
		
		return Sm.updateSchedules(schedules) > 0 ;
	}

	public boolean deleteSchedules(int schedulesId) {
		
		return Sm.deleteSchedules(schedulesId) > 0;
	}
	
		
}
