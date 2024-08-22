package com.sh.monitor.mapper;
import java.util.List;

import com.sh.monitor.common.util.Assist;
import com.sh.monitor.entity.SysMonitorScheduleTask;

import org.apache.ibatis.annotations.Param;
/**
 * SysMonitorScheduleTask的Dao接口
 * 
 * @author 
 *
 */
public interface SysMonitorScheduleTaskDao {

	/**
	 * 获得SysMonitorScheduleTask数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	long getSysMonitorScheduleTaskRowCount(Assist assist);
	
	/**
	 * 获得SysMonitorScheduleTask数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	List<SysMonitorScheduleTask> selectSysMonitorScheduleTask(Assist assist);
	/**
	 * 通过SysMonitorScheduleTask的id获得SysMonitorScheduleTask对象
	 * 
	 * @param id
	 * @return
	 */
	SysMonitorScheduleTask selectSysMonitorScheduleTaskById(String id);
	
	/**
	 * 获得一个SysMonitorScheduleTask对象,以参数SysMonitorScheduleTask对象中不为空的属性作为条件进行查询,返回符合条件的第一条
	 * 
	 * @param obj
	 * @return
	 */
	SysMonitorScheduleTask selectSysMonitorScheduleTaskObjSingle(SysMonitorScheduleTask obj);
	
	/**
	 * 获得一个SysMonitorScheduleTask对象,以参数SysMonitorScheduleTask对象中不为空的属性作为条件进行查询
	 * 
	 * @param obj
	 * @return
	 */
	List<SysMonitorScheduleTask> selectSysMonitorScheduleTaskByObj(SysMonitorScheduleTask obj);

	/**
	 * 插入SysMonitorScheduleTask到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertSysMonitorScheduleTask(SysMonitorScheduleTask value);
	
	/**
	 * 插入SysMonitorScheduleTask中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	int insertNotNullSysMonitorScheduleTask(SysMonitorScheduleTask value);
	
	/**
	 * 批量插入SysMonitorScheduleTask到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertSysMonitorScheduleTaskByBatch(List<SysMonitorScheduleTask> value);
	/**
	 * 通过SysMonitorScheduleTask的id删除SysMonitorScheduleTask
	 * 
	 * @param id
	 * @return
	 */
	int deleteSysMonitorScheduleTaskById(String id);
	
	/**
	 * 通过辅助工具Assist的条件删除SysMonitorScheduleTask
	 * 
	 * @param assist
	 * @return
	 */
	int deleteSysMonitorScheduleTaskByAssist(Assist assist);
	
	/**
	 * 通过SysMonitorScheduleTask的id更新SysMonitorScheduleTask中的数据,包括null值
	 * 
	 * @param enti
	 * @return
	 */
	int updateSysMonitorScheduleTaskById(SysMonitorScheduleTask enti);
	
	/**
	 * 通过SysMonitorScheduleTask的id更新SysMonitorScheduleTask中属性不为null的数据
	 * 
	 * @param enti
	 * @return
	 */
	int updateNotNullSysMonitorScheduleTaskById(SysMonitorScheduleTask enti);
	
	/**
	 * 通过辅助工具Assist的条件更新SysMonitorScheduleTask中的数据,包括null值
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateSysMonitorScheduleTask(@Param("enti") SysMonitorScheduleTask value, @Param("assist") Assist assist);
	
	/**
	 * 通过辅助工具Assist的条件更新SysMonitorScheduleTask中属性不为null的数据
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateNotNullSysMonitorScheduleTask(@Param("enti") SysMonitorScheduleTask value, @Param("assist") Assist assist);
}