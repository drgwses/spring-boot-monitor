package com.sh.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sh.monitor.service.SysMonitorScheduleTaskService;
import com.sh.monitor.entity.SysMonitorScheduleTask;

/**
 * SysMonitorScheduleTask的路由接口服务
 * 
 * @author 
 *
 */
@RestController
@RequestMapping("/sysMonitorScheduleTask")
public class SysMonitorScheduleTaskController {

	/** SysMonitorScheduleTaskService服务 */
	@Autowired
	private SysMonitorScheduleTaskService sysMonitorScheduleTaskService;
	
	/**
	 * 查询所有SysMonitorScheduleTask数据的方法
	 * @param value
	 * @return
	 */
	@PostMapping(value = "/querySysMonitorScheduleTask", produces = {"application/json;charset=UTF-8"})
	public String find(@RequestBody SysMonitorScheduleTask value) {
		return sysMonitorScheduleTaskService.find(value);
	}
	
	/**
	 * 通过id查询SysMonitorScheduleTask数据的方法
	 * @return
	 */
	@PostMapping(value = "/querySysMonitorScheduleTaskOne", produces = {"application/json;charset=UTF-8"})
	public String findOne(@RequestBody SysMonitorScheduleTask value) {
		String id = value.getId();
		return sysMonitorScheduleTaskService.findOne(id);
	}
	
	/**
	 * 插入SysMonitorScheduleTask属性不为空的数据方法
	 * @return
	 */
	@PostMapping(value = "/addSysMonitorScheduleTask", produces = {"application/json;charset=UTF-8"})
	public String save(@RequestBody SysMonitorScheduleTask value) {
		return sysMonitorScheduleTaskService.saveNotNull(value);
	}
	
	/**
	 * 更新SysMonitorScheduleTask属性不为空的数据方法
	 * @return
	 */
	@PostMapping(value = "/updateSysMonitorScheduleTask", produces = {"application/json;charset=UTF-8"})
	public String update(@RequestBody SysMonitorScheduleTask value) {
		return sysMonitorScheduleTaskService.updateNotNullById(value);
	}

	/**
	 * 通过id删除SysMonitorScheduleTask数据方法
	 * @return
	 */
	@PostMapping(value = "/deleteSysMonitorScheduleTask", produces = {"application/json;charset=UTF-8"})
	public String delete(@RequestBody SysMonitorScheduleTask value) {
		String id = value.getId();
		return sysMonitorScheduleTaskService.deleteById(id);
	}
}
