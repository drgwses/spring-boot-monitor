package com.sh.monitor.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * sys_monitor_log实体类
 * 
 * @author 
 *
 */
public class SysMonitorLog {
	/**主键*/
	private String id; 
	/**系统名称*/
	private String systemName; 
	/**系统编码 关联sys_monitor_config 中的system_code*/
	private String systemCode; 
	/**巡检结果 0:成功 1：失败*/
	private String monitorResult; 
	/**失败原因*/
	private String failInfo; 
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
	public SysMonitorLog() {
		super();
	}
	/**
	 * 实例化
	 * 
	 * @param obj
	 */
	public SysMonitorLog(JSONObject obj) {
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
		if (obj.get("monitorResult") instanceof String) {
			this.setMonitorResult((String) obj.get("monitorResult"));
		}
		if (obj.get("failInfo") instanceof String) {
			this.setFailInfo((String) obj.get("failInfo"));
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
		if (this.getSystemName() != null) {
			result.put("systemName",this.getSystemName());
		}
		if (this.getSystemCode() != null) {
			result.put("systemCode",this.getSystemCode());
		}
		if (this.getMonitorResult() != null) {
			result.put("monitorResult",this.getMonitorResult());
		}
		if (this.getFailInfo() != null) {
			result.put("failInfo",this.getFailInfo());
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
	 * 获取monitorResult
	 * 
	 * @return
	 */
	public String getMonitorResult() {
		return monitorResult;
	}

	/**
	 * 设置monitorResult
	 * 
	 * @param monitorResult
	 */
	public void setMonitorResult(String monitorResult) {
		this.monitorResult = monitorResult;
	}
	
	/**
	 * 获取failInfo
	 * 
	 * @return
	 */
	public String getFailInfo() {
		return failInfo;
	}

	/**
	 * 设置failInfo
	 * 
	 * @param failInfo
	 */
	public void setFailInfo(String failInfo) {
		this.failInfo = failInfo;
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
		return "SysMonitorLog [id=" + id + " , systemName=" + systemName + " , systemCode=" + systemCode + " , monitorResult=" + monitorResult + " , failInfo=" + failInfo + " , createDate=" + createDate + " , updateDate=" + updateDate + " , isDeleted=" + isDeleted + " , sysType=" + sysType + "  ]";
	
	}
	
	
}
