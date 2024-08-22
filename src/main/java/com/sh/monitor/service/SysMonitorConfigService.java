package com.sh.monitor.service;
import java.util.List;

import com.sh.monitor.service.impl.SysMonitorConfigServiceImpl;
import com.sh.monitor.common.util.Assist;
import com.sh.monitor.entity.SysMonitorConfig;

/**
 * SysMonitorConfig的服务接口
 * 
 * @author 
 *
 */
public interface SysMonitorConfigService {
	/**
	 * 获得SysMonitorConfig数据集,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @return
	 */
	String find(SysMonitorConfig value);
	
	/**
	 * 通过SysMonitorConfig的id获得SysMonitorConfig对象
	 * 
	 * @param id
	 * @return
	 */
	String findOne(String id);
	
	/**
	 * 将SysMonitorConfig中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	String saveNotNull(SysMonitorConfig value);
	
	/**
	 * 通过SysMonitorConfig的id更新SysMonitorConfig中属性不为null的数据
	 * 
	 * @param enti
	 * @return
	 */
	String updateNotNullById(SysMonitorConfig enti);
	
	/**
	 * 通过SysMonitorConfig的id删除SysMonitorConfig
	 * 
	 * @param id
	 * @return
	 */
	String deleteById(String id);
}
