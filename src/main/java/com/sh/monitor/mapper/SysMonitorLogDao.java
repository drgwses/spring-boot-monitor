package com.sh.monitor.mapper;
import java.util.List;

import com.sh.monitor.common.util.Assist;
import com.sh.monitor.entity.SysMonitorLog;

import org.apache.ibatis.annotations.Param;
/**
 * SysMonitorLog的Dao接口
 * 
 * @author 
 *
 */
public interface SysMonitorLogDao {

	/**
	 * 获得SysMonitorLog数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	long getSysMonitorLogRowCount(Assist assist);
	
	/**
	 * 获得SysMonitorLog数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	List<SysMonitorLog> selectSysMonitorLog(Assist assist);
	/**
	 * 通过SysMonitorLog的id获得SysMonitorLog对象
	 * 
	 * @param id
	 * @return
	 */
	SysMonitorLog selectSysMonitorLogById(String id);
	
	/**
	 * 获得一个SysMonitorLog对象,以参数SysMonitorLog对象中不为空的属性作为条件进行查询,返回符合条件的第一条
	 * 
	 * @param obj
	 * @return
	 */
	SysMonitorLog selectSysMonitorLogObjSingle(SysMonitorLog obj);
	
	/**
	 * 获得一个SysMonitorLog对象,以参数SysMonitorLog对象中不为空的属性作为条件进行查询
	 * 
	 * @param obj
	 * @return
	 */
	List<SysMonitorLog> selectSysMonitorLogByObj(SysMonitorLog obj);

	/**
	 * 插入SysMonitorLog到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertSysMonitorLog(SysMonitorLog value);
	
	/**
	 * 插入SysMonitorLog中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	int insertNotNullSysMonitorLog(SysMonitorLog value);
	
	/**
	 * 批量插入SysMonitorLog到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertSysMonitorLogByBatch(List<SysMonitorLog> value);
	/**
	 * 通过SysMonitorLog的id删除SysMonitorLog
	 * 
	 * @param id
	 * @return
	 */
	int deleteSysMonitorLogById(String id);
	
	/**
	 * 通过辅助工具Assist的条件删除SysMonitorLog
	 * 
	 * @param assist
	 * @return
	 */
	int deleteSysMonitorLogByAssist(Assist assist);
	
	/**
	 * 通过SysMonitorLog的id更新SysMonitorLog中的数据,包括null值
	 * 
	 * @param enti
	 * @return
	 */
	int updateSysMonitorLogById(SysMonitorLog enti);
	
	/**
	 * 通过SysMonitorLog的id更新SysMonitorLog中属性不为null的数据
	 * 
	 * @param enti
	 * @return
	 */
	int updateNotNullSysMonitorLogById(SysMonitorLog enti);
	
	/**
	 * 通过辅助工具Assist的条件更新SysMonitorLog中的数据,包括null值
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateSysMonitorLog(@Param("enti") SysMonitorLog value, @Param("assist") Assist assist);
	
	/**
	 * 通过辅助工具Assist的条件更新SysMonitorLog中属性不为null的数据
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateNotNullSysMonitorLog(@Param("enti") SysMonitorLog value, @Param("assist") Assist assist);
}