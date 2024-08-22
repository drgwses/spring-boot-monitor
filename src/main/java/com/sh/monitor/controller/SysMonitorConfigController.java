package com.sh.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sh.monitor.service.SysMonitorConfigService;
import com.sh.monitor.entity.SysMonitorConfig;

/**
 * SysMonitorConfig的路由接口服务
 * 
 * @author 
 *
 */
@RestController
@RequestMapping("/sysMonitorConfig")
public class SysMonitorConfigController {

	/** SysMonitorConfigService服务 */
	@Autowired
	private SysMonitorConfigService sysMonitorConfigService;
	
	/**
	 * 查询所有SysMonitorConfig数据的方法
	 * @return
	 */
	@PostMapping(value = "/querySysMonitorConfig", produces = {"application/json;charset=UTF-8"})
	public String find(@RequestBody SysMonitorConfig value) {
		return sysMonitorConfigService.find(value);
	}
	
	/**
	 * 通过id查询SysMonitorConfig数据的方法
	 * @return
	 */
	@PostMapping(value = "/querySysMonitorConfigOne", produces = {"application/json;charset=UTF-8"})
	public String findOne(@RequestBody SysMonitorConfig value) {
		String id = value.getId();
		return sysMonitorConfigService.findOne(id);
	}
	
	/**
	 * 插入SysMonitorConfig属性不为空的数据方法
	 * @return
	 */
	@PostMapping(value = "/addSysMonitorConfig", produces = {"application/json;charset=UTF-8"})
	public String save(@RequestBody SysMonitorConfig value) {
		return sysMonitorConfigService.saveNotNull(value);
	}
	
	/**
	 * 更新SysMonitorConfig属性不为空的数据方法
	 * @return
	 */
	@PostMapping(value = "/updateSysMonitorConfig", produces = {"application/json;charset=UTF-8"})
	public String update(@RequestBody SysMonitorConfig value) {
		return sysMonitorConfigService.updateNotNullById(value);
	}

	/**
	 * 通过id删除SysMonitorConfig数据方法
	 * @return
	 */
	@PostMapping(value = "/deleteSysMonitorConfig", produces = {"application/json;charset=UTF-8"})
	public String delete(@RequestBody SysMonitorConfig value) {
		String id = value.getId();
		return sysMonitorConfigService.deleteById(id);
	}
}
