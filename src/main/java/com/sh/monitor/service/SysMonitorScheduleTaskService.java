package com.sh.monitor.service;
import java.util.List;

import com.sh.monitor.service.impl.SysMonitorScheduleTaskServiceImpl;
import com.sh.monitor.common.util.Assist;
import com.sh.monitor.entity.SysMonitorScheduleTask;

/**
 * SysMonitorScheduleTask的服务接口
 * 
 * @author 
 *
 */
public interface SysMonitorScheduleTaskService {
	/**
	 * 获得SysMonitorScheduleTask数据集,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @return
	 */
	String find(SysMonitorScheduleTask value);
	
	/**
	 * 通过SysMonitorScheduleTask的id获得SysMonitorScheduleTask对象
	 * 
	 * @param id
	 * @return
	 */
	String findOne(String id);
	
	/**
	 * 将SysMonitorScheduleTask中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	String saveNotNull(SysMonitorScheduleTask value);
	
	/**
	 * 通过SysMonitorScheduleTask的id更新SysMonitorScheduleTask中属性不为null的数据
	 * 
	 * @param enti
	 * @return
	 */
	String updateNotNullById(SysMonitorScheduleTask enti);
	
	/**
	 * 通过SysMonitorScheduleTask的id删除SysMonitorScheduleTask
	 * 
	 * @param id
	 * @return
	 */
	String deleteById(String id);
}
