package com.sh.monitor.controller;

import com.sh.monitor.common.constant.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.sh.monitor.service.SysMonitorScheduleTaskService;
import com.sh.monitor.entity.SysMonitorScheduleTask;

import java.util.List;

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
	public String find(@RequestBody @Validated SysMonitorScheduleTask value, BindingResult bindingResult) {
		R r = new R();
		if (bindingResult.hasErrors()) {
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				String defaultMessage = fieldError.getDefaultMessage();
				String field = fieldError.getField();
				r.setCode(20001);
				r.setMessage(field+defaultMessage);
				return r.toString();
			}
		}else {
			return sysMonitorScheduleTaskService.find(value);
		}
		return "";
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
