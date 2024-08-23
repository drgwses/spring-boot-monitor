package com.sh.monitor.service.impl;

import java.util.List;

import com.mysql.cj.util.StringUtils;
import com.sh.monitor.common.config.SchedulingTaskManage;
import com.sh.monitor.common.config.SchedulingTaskRunnable;
import com.sh.monitor.common.util.Assist;
import com.sh.monitor.common.util.AutoSeleniumUtil;
import com.sh.monitor.entity.SysMonitorScheduleTask;
import com.sh.monitor.mapper.SysMonitorScheduleTaskDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.sh.monitor.service.SysMonitorConfigService;
import com.sh.monitor.mapper.SysMonitorConfigDao;
import com.sh.monitor.entity.SysMonitorConfig;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 * SysMonitorConfig的服务接口的实现类
 *
 * @author
 */
@Service
public class SysMonitorConfigServiceImpl implements SysMonitorConfigService {
    private final Logger LOG = LogManager.getLogger(this.getClass());

    @Autowired
    private SysMonitorConfigDao sysMonitorConfigDao;
    // TODO 当你看到这个方法时你应该创建一个工具类做通用的方法,定义自己的返回格式化
    @Autowired
    private SysMonitorScheduleTaskDao sysMonitorScheduleTaskDao;
    private static final int C200 = 20000;
    private static final int C412 = 20001;
    @Autowired
    private SchedulingTaskManage taskManage;

    public String resultFormat(int code, Object data) {
        JSONObject result = new JSONObject();
        result.put("code", code);
        if (data != null) {
            result.put("data", data);
        }
        return result.toJSONString();
    }

    @Override
    public String find(SysMonitorConfig value) {

        //TODO这里可以做通过Assist做添加查询
        Assist assist = new Assist();
        if (StringUtils.isNullOrEmpty(value.getSystemName())) {
            assist.andLike("system_name", value.getSystemName());
        }
        if (StringUtils.isNullOrEmpty(value.getSystemName())) {
            assist.andEq("system_code", value.getSystemCode());
        }
        assist.setResultColumn("id,system_status,system_switch,system_name,system_code,sys_type,create_date");
        List<SysMonitorConfig> result = sysMonitorConfigDao.selectSysMonitorConfig(assist);
        if (LOG.isDebugEnabled()) {
            LOG.debug("执行获取SysMonitorConfig数据集-->结果:", result);
        }
        return resultFormat(C200, result);
    }

    @Override
    public String findOne(String id) {
        if (id == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("执行通过SysMonitorConfig的id获得SysMonitorConfig对象-->失败:id不能为空");
            }
            return resultFormat(C412, null);
        }
        SysMonitorConfig result = sysMonitorConfigDao.selectSysMonitorConfigById(id);
        if (LOG.isDebugEnabled()) {
            LOG.debug("执行通过SysMonitorConfig的id获得SysMonitorConfig对象-->结果:", result);
        }
        return resultFormat(C200, result);
    }

    @Override
    public String saveNotNull(SysMonitorConfig value) {
        if (value == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("执行将SysMonitorConfig中属性值不为null的数据保存到数据库-->失败:对象不能为空");
            }
            return resultFormat(C412, null);
        }
        Assist assist = new Assist();
        assist.andEq("system_code", value.getSystemCode());
        List<SysMonitorConfig> sysMonitorConfigs = sysMonitorConfigDao.selectSysMonitorConfig(assist);
        if (!CollectionUtils.isEmpty(sysMonitorConfigs)) {
            return resultFormat(C412, "系统编号已存在");
        }

        value.setId(AutoSeleniumUtil.getUUID());
        value.setSystemStatus("0");
        value.setSystemSwitch("0");
        value.setCreateDate(AutoSeleniumUtil.getBusinessDateTime());
        value.setIsDeleted("0");

        SysMonitorScheduleTask sysMonitorScheduleTask = new SysMonitorScheduleTask();
        sysMonitorScheduleTask.setSystemCode(value.getSystemCode());
        SysMonitorScheduleTask sysMonitorScheduleTask1 = sysMonitorScheduleTaskDao.selectSysMonitorScheduleTaskObjSingle(sysMonitorScheduleTask);
        if (null == sysMonitorScheduleTask1) {
            return resultFormat(C412, "未查询到服务配置，请联系开发人员配制");
        }
        int result = sysMonitorConfigDao.insertNotNullSysMonitorConfig(value);
        if (LOG.isDebugEnabled()) {
            LOG.debug("执行将SysMonitorConfig中属性值不为null的数据保存到数据库-->结果:", result);
        }
        if (result > 0) {
            SchedulingTaskRunnable taskRunnable = new SchedulingTaskRunnable<>(value, sysMonitorScheduleTask1.getTaskClazz(), sysMonitorScheduleTask1.getTaskMethod());
            taskManage.createSchedulingTask(String.valueOf(value.getSystemCode()), taskRunnable, value.getSystemCron());
        }
        return resultFormat(C200, result);
    }

    @Override
    public String updateNotNullById(SysMonitorConfig value) {
        if (value == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("执行通过SysMonitorConfig的id更新SysMonitorConfig中属性不为null的数据-->失败:对象为null");
            }
            return resultFormat(C412, null);
        }
        Assist assist = new Assist();
        assist.andEq("system_code", value.getSystemCode());
        List<SysMonitorConfig> sysMonitorConfigs = sysMonitorConfigDao.selectSysMonitorConfig(assist);
        if (!CollectionUtils.isEmpty(sysMonitorConfigs) && !sysMonitorConfigs.get(0).getId().equals(value.getId())) {
            return resultFormat(C412, "系统编号已存在");
        }
        int result = sysMonitorConfigDao.updateNotNullSysMonitorConfigById(value);

        if (result > 0) {
            SysMonitorConfig sysMonitorConfig = sysMonitorConfigDao.selectSysMonitorConfigById(value.getId());
            Assist assist2 = new Assist();
            assist2.andEq("system_code", sysMonitorConfig.getSystemCode());
            List<SysMonitorScheduleTask> sysMonitorScheduleTask1 = sysMonitorScheduleTaskDao.selectSysMonitorScheduleTask(assist);
            SchedulingTaskRunnable taskRunnable = new SchedulingTaskRunnable<>(value, sysMonitorScheduleTask1.get(0).getTaskClazz(), sysMonitorScheduleTask1.get(0).getTaskMethod());
            taskManage.createSchedulingTask(String.valueOf(sysMonitorConfig.getSystemCode()), taskRunnable, value.getSystemCron());
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("执行通过SysMonitorConfig的id更新SysMonitorConfig中属性不为null的数据-->结果:", result);
        }
        return resultFormat(C200, result);
    }

    @Override
    public String deleteById(String id) {
        if (id == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("执行通过SysMonitorConfig的id删除SysMonitorConfig-->失败:id不能为空");
            }
            return resultFormat(C412, null);
        }
        SysMonitorConfig sysMonitorConfig = sysMonitorConfigDao.selectSysMonitorConfigById(id);
        taskManage.stopSchedulingTask(sysMonitorConfig.getSystemCode());
        int result = sysMonitorConfigDao.deleteSysMonitorConfigById(id);
        if (LOG.isDebugEnabled()) {
            LOG.debug("执行通过SysMonitorConfig的id删除SysMonitorConfig-->结果:", result);
        }
        return resultFormat(C200, result);
    }


}