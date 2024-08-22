package com.sh.monitor.service;
import java.util.List;

import com.sh.monitor.service.impl.SysMonitorLogServiceImpl;
import com.sh.monitor.common.util.Assist;
import com.sh.monitor.entity.SysMonitorLog;

/**
 * SysMonitorLog的服务接口
 * 
 * @author 
 *
 */
public interface SysMonitorLogService {
	/**
	 * 获得SysMonitorLog数据集,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @return
	 */
	String find(SysMonitorLog value);
	
	/**
	 * 通过SysMonitorLog的id获得SysMonitorLog对象
	 * 
	 * @param id
	 * @return
	 */
	String findOne(String id);
	
	/**
	 * 将SysMonitorLog中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	String saveNotNull(SysMonitorLog value);
	
	/**
	 * 通过SysMonitorLog的id更新SysMonitorLog中属性不为null的数据
	 * 
	 * @param enti
	 * @return
	 */
	String updateNotNullById(SysMonitorLog enti);
	
	/**
	 * 通过SysMonitorLog的id删除SysMonitorLog
	 * 
	 * @param id
	 * @return
	 */
	String deleteById(String id);
}
