package com.sh.monitor.service.impl;
import java.util.List;

import com.mysql.cj.util.StringUtils;
import com.sh.monitor.common.util.AutoSeleniumUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.sh.monitor.service.SysMonitorScheduleTaskService;
import com.sh.monitor.mapper.SysMonitorScheduleTaskDao;
import com.sh.monitor.common.util.Assist;
import com.sh.monitor.entity.SysMonitorScheduleTask;
/**
 * SysMonitorScheduleTask的服务接口的实现类
 * 
 * @author 
 *
 */
@Service
public class SysMonitorScheduleTaskServiceImpl implements SysMonitorScheduleTaskService {
	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired
	private SysMonitorScheduleTaskDao sysMonitorScheduleTaskDao;
	// TODO 当你看到这个方法时你应该创建一个工具类做通用的方法,定义自己的返回格式化
	private static final int C200 = 20000;
	private static final int C412 = 20001;
	public String resultFormat(int code, Object data) {
		JSONObject result = new JSONObject();
		result.put("code", code);
		if (data != null) {
			result.put("data", data);
		}
		return result.toJSONString();
	}

	@Override
	public String find(SysMonitorScheduleTask value) {
		//TODO这里可以做通过Assist做添加查询
		Assist assist = new Assist();
		if (StringUtils.isNullOrEmpty(value.getSystemName())){
			assist.andLike("system_name",value.getSystemName());
		}
		if (StringUtils.isNullOrEmpty(value.getSystemName())) {
			assist.andEq("system_code",value.getSystemCode());
		}
		assist.setResultColumn("id,system_name,system_code,task_clazz,task_method");
		List<SysMonitorScheduleTask> result = sysMonitorScheduleTaskDao.selectSysMonitorScheduleTask(assist);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行获取SysMonitorScheduleTask数据集-->结果:", result);
		}
		return resultFormat(C200, result);
	}
	@Override
	public String findOne(String id) {
		if (id == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行通过SysMonitorScheduleTask的id获得SysMonitorScheduleTask对象-->失败:id不能为空");
			}
			return resultFormat(C412, null);
		}
		SysMonitorScheduleTask result = sysMonitorScheduleTaskDao.selectSysMonitorScheduleTaskById(id);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行通过SysMonitorScheduleTask的id获得SysMonitorScheduleTask对象-->结果:", result);
		}
		return resultFormat(C200, result);
	}

	@Override
	public String saveNotNull(SysMonitorScheduleTask value) {
		if (value == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行将SysMonitorScheduleTask中属性值不为null的数据保存到数据库-->失败:对象不能为空");
			}
			return resultFormat(C412, null);
		}
		if(value.getTaskClazz() == null || value.getTaskMethod() == null  ){
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行将SysMonitorScheduleTask中属性值不为null的数据保存到数据库-->失败:存在不能为空的空值");
			}
			return resultFormat(C412, null);
		}
		value.setId(AutoSeleniumUtil.getUUID());
		value.setStatus(0);
		int result = sysMonitorScheduleTaskDao.insertNotNullSysMonitorScheduleTask(value);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行将SysMonitorScheduleTask中属性值不为null的数据保存到数据库-->结果:", result);
		}
		return resultFormat(C200, result);
	}
	@Override
	public String updateNotNullById(SysMonitorScheduleTask value) {
		if (value == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行通过SysMonitorScheduleTask的id更新SysMonitorScheduleTask中属性不为null的数据-->失败:对象为null");
			}
			return resultFormat(C412, null);
		}
		int result = sysMonitorScheduleTaskDao.updateNotNullSysMonitorScheduleTaskById(value);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行通过SysMonitorScheduleTask的id更新SysMonitorScheduleTask中属性不为null的数据-->结果:", result);
		}
		return resultFormat(C200, result);
	}

	@Override
	public String deleteById(String id) {
		if (id == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("执行通过SysMonitorScheduleTask的id删除SysMonitorScheduleTask-->失败:id不能为空");
			}
			return resultFormat(C412, null);
		}
		int result = sysMonitorScheduleTaskDao.deleteSysMonitorScheduleTaskById(id);
		if (LOG.isDebugEnabled()) {
			LOG.debug("执行通过SysMonitorScheduleTask的id删除SysMonitorScheduleTask-->结果:", result);
		}
		return resultFormat(C200, result);
	}


}