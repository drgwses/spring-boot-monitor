package com.sh.monitor.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * sys_monitor_config实体类
 * 
 * @author 
 *
 */
public class SysMonitorConfig {
	/**主键*/
	private String id; 
	/**系统状态 0:正常 1：异常*/
	private String systemStatus; 
	/**巡检周期 cron 表达式*/
	private String systemCron; 
	/**巡检开关 0：开启 1:关闭*/
	private String systemSwitch; 
	/**系统名称*/
	private String systemName; 
	/**系统编码*/
	private String systemCode; 
	/**用户账户*/
	private String loggerName; 
	/**用户口令*/
	private String loggerPassword; 
	/**用户url路径*/
	private String clientUrl; 
	/**创建时间*/
	private String createDate; 
	/**最后更新时间*/
	private String updateDate; 
	/**是否已删除  1：已删除*/
	private String isDeleted; 
	/**1:内网 2:外网*/
	private String sysType; 
	/**
	 * 实例化
	 */
	public SysMonitorConfig() {
		super();
	}
	/**
	 * 实例化
	 * 
	 * @param obj
	 */
	public SysMonitorConfig(JSONObject obj) {
		this();
		if (obj.get("id") instanceof String) {
			this.setId((String) obj.get("id"));
		}
		if (obj.get("systemStatus") instanceof String) {
			this.setSystemStatus((String) obj.get("systemStatus"));
		}
		if (obj.get("systemCron") instanceof String) {
			this.setSystemCron((String) obj.get("systemCron"));
		}
		if (obj.get("systemSwitch") instanceof String) {
			this.setSystemSwitch((String) obj.get("systemSwitch"));
		}
		if (obj.get("systemName") instanceof String) {
			this.setSystemName((String) obj.get("systemName"));
		}
		if (obj.get("systemCode") instanceof String) {
			this.setSystemCode((String) obj.get("systemCode"));
		}
		if (obj.get("loggerName") instanceof String) {
			this.setLoggerName((String) obj.get("loggerName"));
		}
		if (obj.get("loggerPassword") instanceof String) {
			this.setLoggerPassword((String) obj.get("loggerPassword"));
		}
		if (obj.get("clientUrl") instanceof String) {
			this.setClientUrl((String) obj.get("clientUrl"));
		}
		if (obj.get("createDate") instanceof String) {
			this.setCreateDate((String) obj.get("createDate"));
		}
		if (obj.get("updateDate") instanceof String) {
			this.setUpdateDate((String) obj.get("updateDate"));
		}
		if (obj.get("isDeleted") instanceof String) {
			this.setIsDeleted((String) obj.get("isDeleted"));
		}
		if (obj.get("sysType") instanceof String) {
			this.setSysType((String) obj.get("sysType"));
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
		if (this.getSystemStatus() != null) {
			result.put("systemStatus",this.getSystemStatus());
		}
		if (this.getSystemCron() != null) {
			result.put("systemCron",this.getSystemCron());
		}
		if (this.getSystemSwitch() != null) {
			result.put("systemSwitch",this.getSystemSwitch());
		}
		if (this.getSystemName() != null) {
			result.put("systemName",this.getSystemName());
		}
		if (this.getSystemCode() != null) {
			result.put("systemCode",this.getSystemCode());
		}
		if (this.getLoggerName() != null) {
			result.put("loggerName",this.getLoggerName());
		}
		if (this.getLoggerPassword() != null) {
			result.put("loggerPassword",this.getLoggerPassword());
		}
		if (this.getClientUrl() != null) {
			result.put("clientUrl",this.getClientUrl());
		}
		if (this.getCreateDate() != null) {
			result.put("createDate",this.getCreateDate());
		}
		if (this.getUpdateDate() != null) {
			result.put("updateDate",this.getUpdateDate());
		}
		if (this.getIsDeleted() != null) {
			result.put("isDeleted",this.getIsDeleted());
		}
		if (this.getSysType() != null) {
			result.put("sysType",this.getSysType());
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
	 * 获取systemStatus
	 * 
	 * @return
	 */
	public String getSystemStatus() {
		return systemStatus;
	}

	/**
	 * 设置systemStatus
	 * 
	 * @param systemStatus
	 */
	public void setSystemStatus(String systemStatus) {
		this.systemStatus = systemStatus;
	}
	
	/**
	 * 获取systemCron
	 * 
	 * @return
	 */
	public String getSystemCron() {
		return systemCron;
	}

	/**
	 * 设置systemCron
	 * 
	 * @param systemCron
	 */
	public void setSystemCron(String systemCron) {
		this.systemCron = systemCron;
	}
	
	/**
	 * 获取systemSwitch
	 * 
	 * @return
	 */
	public String getSystemSwitch() {
		return systemSwitch;
	}

	/**
	 * 设置systemSwitch
	 * 
	 * @param systemSwitch
	 */
	public void setSystemSwitch(String systemSwitch) {
		this.systemSwitch = systemSwitch;
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
	 * 获取loggerName
	 * 
	 * @return
	 */
	public String getLoggerName() {
		return loggerName;
	}

	/**
	 * 设置loggerName
	 * 
	 * @param loggerName
	 */
	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}
	
	/**
	 * 获取loggerPassword
	 * 
	 * @return
	 */
	public String getLoggerPassword() {
		return loggerPassword;
	}

	/**
	 * 设置loggerPassword
	 * 
	 * @param loggerPassword
	 */
	public void setLoggerPassword(String loggerPassword) {
		this.loggerPassword = loggerPassword;
	}
	
	/**
	 * 获取clientUrl
	 * 
	 * @return
	 */
	public String getClientUrl() {
		return clientUrl;
	}

	/**
	 * 设置clientUrl
	 * 
	 * @param clientUrl
	 */
	public void setClientUrl(String clientUrl) {
		this.clientUrl = clientUrl;
	}
	
	/**
	 * 获取createDate
	 * 
	 * @return
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 设置createDate
	 * 
	 * @param createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * 获取updateDate
	 * 
	 * @return
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置updateDate
	 * 
	 * @param updateDate
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	/**
	 * 获取isDeleted
	 * 
	 * @return
	 */
	public String getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置isDeleted
	 * 
	 * @param isDeleted
	 */
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	/**
	 * 获取sysType
	 * 
	 * @return
	 */
	public String getSysType() {
		return sysType;
	}

	/**
	 * 设置sysType
	 * 
	 * @param sysType
	 */
	public void setSysType(String sysType) {
		this.sysType = sysType;
	}

	@Override
	public String toString() {
		return "SysMonitorConfig [id=" + id + " , systemStatus=" + systemStatus + " , systemCron=" + systemCron + " , systemSwitch=" + systemSwitch + " , systemName=" + systemName + " , systemCode=" + systemCode + " , loggerName=" + loggerName + " , loggerPassword=" + loggerPassword + " , clientUrl=" + clientUrl + " , createDate=" + createDate + " , updateDate=" + updateDate + " , isDeleted=" + isDeleted + " , sysType=" + sysType + "  ]";
	
	}
	
	
}
