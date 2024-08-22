package com.sh.monitor.common.quartz;

import com.sh.monitor.common.config.SchedulingTaskManage;
import com.sh.monitor.common.config.SchedulingTaskRunnable;
import com.sh.monitor.common.util.Assist;
import com.sh.monitor.entity.SysMonitorConfig;
import com.sh.monitor.entity.SysMonitorScheduleTask;
import com.sh.monitor.mapper.SysMonitorConfigDao;
import com.sh.monitor.mapper.SysMonitorScheduleTaskDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Slf4j
public class LoadLocalScheduled {
    @Autowired
    private SysMonitorConfigDao sysMonitorConfigDao;
    // TODO 当你看到这个方法时你应该创建一个工具类做通用的方法,定义自己的返回格式化
    @Autowired
    private SysMonitorScheduleTaskDao sysMonitorScheduleTaskDao;

    @Autowired
    private SchedulingTaskManage taskManage;


    /**
     * fixedRate属性设置每隔固定时间执行
     */
    @Scheduled(fixedRateString = "${loadLocal.scheduled.fixedRate}")
    public void reportCurrentTime() {
        Assist assist = new Assist();
        assist.andEq("system_switch","0");
        List<SysMonitorConfig> sysMonitorConfigs = sysMonitorConfigDao.selectSysMonitorConfig(assist);
        if (!CollectionUtils.isEmpty(sysMonitorConfigs)){
            log.info("存在："+sysMonitorConfigs.size()+"条任务");
            for (SysMonitorConfig value : sysMonitorConfigs) {
                SysMonitorScheduleTask sysMonitorScheduleTask = new SysMonitorScheduleTask();
                sysMonitorScheduleTask.setSystemCode(value.getSystemCode());
                SysMonitorScheduleTask sysMonitorScheduleTask1 = sysMonitorScheduleTaskDao.selectSysMonitorScheduleTaskObjSingle(sysMonitorScheduleTask);
                SchedulingTaskRunnable taskRunnable = new SchedulingTaskRunnable<>(value, sysMonitorScheduleTask1.getTaskClazz(), sysMonitorScheduleTask1.getTaskMethod());
                taskManage.createSchedulingTask(String.valueOf(value.getSystemCode()), taskRunnable,value.getSystemCron());
            }
        }
    }
}
