package com.sh.monitor.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * sys_monitor_schedule_task实体类
 * 
 * @author 
 *
 */
public class SysMonitorScheduleTask {
	/**主键*/
	private String id; 
	/**系统名称*/
	private String systemName; 
	/**系统编码 关联sys_monitor_config 中的system_code*/
	private String systemCode; 
	/**定时任务类*/
	private String taskClazz; 
	/**定时任务执行方法*/
	private String taskMethod; 
	/**定时任务状态，0:开启，1:关闭*/
	private Integer status; 
	/**
	 * 实例化
	 */
	public SysMonitorScheduleTask() {
		super();
	}
	/**
	 * 实例化
	 * 
	 * @param obj
	 */
	public SysMonitorScheduleTask(JSONObject obj) {
		this();
		if (obj.get("id") instanceof String) {
			this.setId((String) obj.get("id"));
		}
		if (obj.get("systemName") instanceof String) {
			this.setSystemName((String) obj.get("systemName"));
		}
		if (obj.get("systemCode") instanceof String) {
			this.setSystemCode((String) obj.get("systemCode"));
		}
		if (obj.get("taskClazz") instanceof String) {
			this.setTaskClazz((String) obj.get("taskClazz"));
		}
		if (obj.get("taskMethod") instanceof String) {
			this.setTaskMethod((String) obj.get("taskMethod"));
		}
		if (obj.get("status") instanceof Number) {
			this.setStatus(((Number) obj.get("status")).intValue());
		}
	}
	
	/**
	 * 将当前对象转换为JsonObject
	 * 
	 * @return
	 */
	public JSONObject toJson() {
		JSONObject result = new JSONObject();
		if (this.getId() != null) {
			result.put("id",this.getId());
		}
		if (this.getSystemName() != null) {
			result.put("systemName",this.getSystemName());
		}
		if (this.getSystemCode() != null) {
			result.put("systemCode",this.getSystemCode());
		}
		if (this.getTaskClazz() != null) {
			result.put("taskClazz",this.getTaskClazz());
		}
		if (this.getTaskMethod() != null) {
			result.put("taskMethod",this.getTaskMethod());
		}
		if (this.getStatus() != null) {
			result.put("status",this.getStatus());
		}
		return result;
	}
	
	
	/**
	 * 获取id
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置id
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 获取systemName
	 * 
	 * @return
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * 设置systemName
	 * 
	 * @param systemName
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	/**
	 * 获取systemCode
	 * 
	 * @return
	 */
	public String getSystemCode() {
		return systemCode;
	}

	/**
	 * 设置systemCode
	 * 
	 * @param systemCode
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	
	/**
	 * 获取taskClazz
	 * 
	 * @return
	 */
	public String getTaskClazz() {
		return taskClazz;
	}

	/**
	 * 设置taskClazz
	 * 
	 * @param taskClazz
	 */
	public void setTaskClazz(String taskClazz) {
		this.taskClazz = taskClazz;
	}
	
	/**
	 * 获取taskMethod
	 * 
	 * @return
	 */
	public String getTaskMethod() {
		return taskMethod;
	}

	/**
	 * 设置taskMethod
	 * 
	 * @param taskMethod
	 */
	public void setTaskMethod(String taskMethod) {
		this.taskMethod = taskMethod;
	}
	
	/**
	 * 获取status
	 * 
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置status
	 * 
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SysMonitorScheduleTask [id=" + id + " , systemName=" + systemName + " , systemCode=" + systemCode + " , taskClazz=" + taskClazz + " , taskMethod=" + taskMethod + " , status=" + status + "  ]";
	
	}
	
	
}
