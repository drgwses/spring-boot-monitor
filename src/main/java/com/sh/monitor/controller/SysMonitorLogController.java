package com.sh.monitor.controller;

import com.sh.monitor.common.constant.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.sh.monitor.service.SysMonitorLogService;
import com.sh.monitor.entity.SysMonitorLog;

import java.util.List;

/**
 * SysMonitorLog的路由接口服务
 * 
 * @author 
 *
 */
@RestController
@RequestMapping("/sysMonitorLog")
public class SysMonitorLogController {

	/** SysMonitorLogService服务 */
	@Autowired
	private SysMonitorLogService sysMonitorLogService;
	
	/**
	 * 查询所有SysMonitorLog数据的方法
	 * @param value
	 * @return
	 */
	@PostMapping(value = "/querySysMonitorLog", produces = {"application/json;charset=UTF-8"})
	public String find(@RequestBody @Validated SysMonitorLog value, BindingResult bindingResult) {
		R r = new R();
		if (bindingResult.hasErrors()) {
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				String defaultMessage = fieldError.getDefaultMessage();
				r.setCode(20001);
				r.setMessage( defaultMessage);
				return r.toString();
			}
		}else {
			return sysMonitorLogService.find(value);
		}
		return "";
	}
	
	/**
	 * 通过id查询SysMonitorLog数据的方法
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/SysMonitorLog/{id}", produces = {"application/json;charset=UTF-8"})
	public String findOne(@PathVariable(name="id") String id) {
		return sysMonitorLogService.findOne(id);
	}
	
	/**
	 * 插入SysMonitorLog属性不为空的数据方法
	 * @return
	 */
	@PostMapping(value = "/addSysMonitorLog", produces = {"application/json;charset=UTF-8"})
	public String save(SysMonitorLog value) {
		return sysMonitorLogService.saveNotNull(value);
	}
	
	/**
	 * 更新SysMonitorLog属性不为空的数据方法
	 * @return
	 */
	@PostMapping(value = "/updateSysMonitorLog", produces = {"application/json;charset=UTF-8"})
	public String update(SysMonitorLog value) {
		return sysMonitorLogService.updateNotNullById(value);
	}

	/**
	 * 通过id删除SysMonitorLog数据方法
	 * @return
	 */
	@PostMapping(value = "/deleteSysMonitorLog", produces = {"application/json;charset=UTF-8"})
	public String delete(@RequestBody SysMonitorLog value) {
		String id = value.getId();
		return sysMonitorLogService.deleteById(id);
	}
}
