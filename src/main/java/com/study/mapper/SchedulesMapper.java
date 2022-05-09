package com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.study.model.Schedules;

@Mapper
public interface SchedulesMapper {
	
	@Insert("insert into Schedules(creatorId,scheduleDate,content,createTime) values(#{creatorId},#{scheduleDate},#{content},now())")
	public int createSchedules(Schedules schedules);
	
	@Select("select * from Schedules")
	@Result(property = "creator",column = "creatorId",
			one=@One(select="com.study.mapper.UserInfoMapper.getUserInfoById",fetchType = FetchType.EAGER)
			)
	public List<Schedules> getAllSchedules() ;
	
	@Select("select * from Schedules where scheduleId=#{scheduleId}")
	public Schedules getSchedulesById(int schedulesId);
	
	@Update("update Schedules set scheduleDate=#{scheduleDate},content=#{content} where scheduleId=#{scheduleId} ")
	public int updateSchedules(Schedules schedules);
	
	@Delete("delete from schedules where scheduleId=#{scheduleId}" ) 
	public int deleteSchedules(int schedulesId);
}
